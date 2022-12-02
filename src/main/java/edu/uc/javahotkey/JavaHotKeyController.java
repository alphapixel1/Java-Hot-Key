package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.Project;
import edu.uc.javahotkey.lua.ILuaCompileService;
import edu.uc.javahotkey.lua.LuaCompiler;
import edu.uc.javahotkey.service.IJavaHotKeyService;
//import kotlin.NotImplementedError;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JavaHotKeyController {

    @Autowired
    IJavaHotKeyService javaHotKeyService;

    private static final Logger log = LoggerFactory.getLogger(JavaHotKeyController.class);

    /**
     *
     * @param model
     * @return index page
     */
    @RequestMapping("/")
    public String index(Model model) {
        log.trace("Indexing projects");
        var p=findAllProjects();
        model.addAttribute("projects",p);
        return "projectsPage";
    }

    /**
     * Filters projects list based on query
     * @param model
     * @param query
     * @return
     */
    @GetMapping("/search")
    public String searchProjects(Model model, @RequestParam("q") String query){
        var lowQuery=query.toLowerCase();
        log.trace("Searching projects: "+query);
        var projects=javaHotKeyService.fetchAllProjects().stream().filter(e->e.getName().toLowerCase().contains(lowQuery)).toList();
        model.addAttribute("projects",projects);
        return "projectsPage";
    }

    /**
     * fills model with a project to edit
     * @param model
     * @param id
     * @return edit project page
     */
    @GetMapping("/edit")
    public String editProject(Model model, @RequestParam("id") int id){

        if(id>=0) {//project id's less than zero are new projects
            var p=findProject(id);
            if(p==null){
                log.error("Project Could Not Be Found: ID="+id);
                return "redirect:/";
                //throw new NotImplementedError();
            }else {
                log.trace("Editing Project: ID="+id);
                model.addAttribute("project",p);
            }
        }else{
            log.trace("Editing Default Project");
            model.addAttribute("project",Project.Default());
        }
        return "editProject";
    }

    /**
     *
     * @return redirects to documentation page
     */
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
        log.trace("Saving Project: ID="+id);
        Project p= projectFromParams(id,name,lua,keybindData);
        log.error("Controller.saveProject: "+ p.getKeymapString());
        if(isCompile){
            ILuaCompileService service=new LuaCompiler();
            model.addAttribute("CompileData",service.TestProject(p));
            model.addAttribute("project",p);
            return "editProject";
        }else {
            javaHotKeyService.save(p);
            return "redirect:/";
        }
    }

    /**
     * Deletes the project with the id
     * @param id
     * @return the redirect to home
     */
    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") int id){
        try {
            javaHotKeyService.delete(id);
            log.trace("Deleted Project: ID="+id);
        }catch (Exception e){
            log.error("Error Deleting Project: ID="+id, e);
        }
        return "redirect:/";
    }

    /**
     *
     * @return a list of all projects
     */
    @GetMapping("/findAllProjects")
    @ResponseBody
    public List<Project> findAllProjects() {
        return javaHotKeyService.fetchAllProjects();
    }

    /**
     *
     * @param id
     * @return project if project exists by id, if not, returns null
     */
    @MaybeNull
    @GetMapping("/findProject")
    @ResponseBody
    public Project findProject(@RequestParam("id") int id) {
        try {
            return javaHotKeyService.fetchById(id);
        }catch (Exception e){
            log.error("Unable To Find Project: ID="+id, e);
            return null;
        }
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
        //System.err.println(keybindData);
        Project p=new Project(id,name);
        p.setKeymapString(keybindData);
        p.setLua(lua);
        return p;
    }
}