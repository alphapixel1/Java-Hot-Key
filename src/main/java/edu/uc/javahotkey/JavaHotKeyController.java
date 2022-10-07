package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import edu.uc.javahotkey.service.IJavaHotKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class JavaHotKeyController {

    @Autowired
    IJavaHotKeyService javaHotKeyService;

    private static final Logger log = LoggerFactory.getLogger(JavaHotKeyController.class);

    @RequestMapping("/")
    public String index() {
        return "index";
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
            log.error("Unable to dave DTO", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
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
