package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import edu.uc.javahotkey.service.IJavaHotKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JavaHotKeyController {

    @Autowired
    IJavaHotKeyService javaHotKeyService;


    private static final Logger log = LoggerFactory.getLogger(JavaHotKeyController.class);

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("project", "I am the project model and I'm passed to the view");
        return "index";
    }

    @GetMapping("/findAllProjects")
    @ResponseBody
    public List<Project> findAllProjects() {
        return javaHotKeyService.fetchAllProjects();
    }


    @GetMapping("/findProject")
    @ResponseBody
    public Project findProject(@RequestParam("id") int id) {
        return javaHotKeyService.fetchById(id);
    }

    @PostMapping("/saveProject")
    @ResponseBody
    public void saveProject(@RequestBody Project project, HttpServletResponse response) {
        try {
            javaHotKeyService.save(project);
            response.setStatus(HttpServletResponse.SC_CREATED);
            log.info("Created project with id ", project.getId());
        } catch (Exception e) {
            log.error("Unable to save DTO", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveProjectModel")
    public ModelAndView saveProjectModel(Model model, Project project) {
        javaHotKeyService.save(project);
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @GetMapping("/getAllProjectsModel")
    public ModelAndView getProjectsModel() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("project", javaHotKeyService.fetchAllProjects());
        return mav;
    }

    @GetMapping("/sampleJsonSchema")
    @ResponseBody
    public Project sampleJsonSchema() {
        log.debug("Sample Json schema requested");
        Project project = new Project(0, "p");
        project.setId(0);
        project.setLua("function func_name(keys)\\nDown(Key.A)\\nSleep(25)--ms\\nUp(Key.A)\\nPress(Key.B)\\nen");
        project.setName("Sample Project");
        KeyMap keyMap = new KeyMap();
        keyMap.setFunctionName("func_name");
        keyMap.setKeymap(new ArrayList<>());
        keyMap.getKeymap().add(17);
        keyMap.getKeymap().add(65);
        project.setKeymaps(new ArrayList<>());
        project.getKeymaps().add(keyMap);
        return project;
    }

}
