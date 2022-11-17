package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import edu.uc.javahotkey.lua.CompilerMessage;
import edu.uc.javahotkey.lua.ILuaCompileService;
import edu.uc.javahotkey.lua.LuaCompiler;
import edu.uc.javahotkey.service.IJavaHotKeyService;
import kotlin.NotImplementedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JavaHotKeyController {

    @Autowired
    IJavaHotKeyService javaHotKeyService;

    private static final Logger log = LoggerFactory.getLogger(JavaHotKeyController.class);

    @RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("project", "I am the project model and I'm passed to the view");
        var p=findAllProjects();
        //p.add(new Project(0,"test"));
        //p.add(new Project(1,"test2"));
        model.addAttribute("projects",p);
        //return "index";
        return "projectsPage";
    }
    @GetMapping("/search")
    public String searchProjects(Model model, @RequestParam("q") String query){
        var lowQuery=query.toLowerCase();

        var projects=javaHotKeyService.fetchAllProjects().stream().filter(e->e.getName().toLowerCase().contains(lowQuery)).toList();
        model.addAttribute("projects",projects);
        return "projectsPage";
    }
    @GetMapping("/edit")
    public String editProject(Model model, @RequestParam("id") int id){
        //model.addAttribute("CompileData","this is the main edit attribute");
        if(id>=0) {//project id's less than zero are new projects
            var p=findProject(id);
            if(p==null){
                throw new NotImplementedError();
            }else {
                model.addAttribute("project",p);
            }
        }else{
            model.addAttribute("project",Project.Default());
        }
        return "editProject";
    }
    @GetMapping("/Documentation")
    public String documentation(){
    return "documentation";
    }


    /**
     * Updates/Saves the project changes
     * @param id
     * @param name
     * @param lua
     * @return
     */
    @PostMapping(value="/edit")
    public String saveProject(Model model, @RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("lua") String lua, @RequestParam("keybindData") String keybindData, @RequestParam("isCompile") boolean isCompile) {
        Project p= projectFromParams(id,name,lua,keybindData);
        if(isCompile){
            ILuaCompileService service=new LuaCompiler();
            model.addAttribute("CompileData",service.TestProject(p));
            model.addAttribute("project",p);
            return "editProject";
        }else {
            if (id >= 0) {
                javaHotKeyService.save(p);
            } else {
                int nid = getNextAvailableProjectID();
                p.setId(nid);
                javaHotKeyService.save(p);
            }
            return "redirect:/";
        }
    }
    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") int id){
        javaHotKeyService.delete(id);
        return "redirect:/";
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

    /**
     * Gets the next available project id
     * @return the next available project id
     */
    @Deprecated//to be removed when autoid is added
    private int getNextAvailableProjectID(){
        int id=0;
        while(findProject(id)!=null)
            id++;
        return id;
    }

    /**
     * Converts params to project
     * @param id
     * @param name
     * @param lua
     * @param keybindData
     * @return the project class
     */
    private Project projectFromParams(int id,String name,String lua, String keybindData){
        Project p=new Project(id,name);
        if(!keybindData.isEmpty()) {//saving the keybinds to the project
            var keymaps=new ArrayList<KeyMap>();
            for (String kbString: keybindData.split("\\.~\\.")) {
                var s=kbString.split("~");
                var map=new KeyMap();
                map.functionName=s[0];
                var keys=new ArrayList<Integer>();
                if(s.length>1) {
                    for (String n : s[1].split(",")) {
                        try {
                            keys.add(Integer.parseInt(n));
                        } catch (Exception e) {
                            //throw new NotImplementedError();
                        }
                    }
                }
                map.keymap=keys;
                keymaps.add(map);
            }
            p.setKeymaps(keymaps);
        }
        p.setLua(lua);
        return p;
    }
}

