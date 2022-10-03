package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class JavaHotKeyController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/GetHotKeys{keyMap}")
    public ResponseEntity fetchAllHotKeys(){return new ResponseEntity(HttpStatus.OK);}
    @ResponseBody
    public Project sampleJsonSchema() {
        Project project = new Project();
        project.setLua("function func_name(keys)\\nDown(Key.A)\\nSleep(25)--ms\\nUp(Key.A)\\nPress(Key.B)\\nen");
        project.setName("Java Hot-Keys");
        KeyMap keyMap = new KeyMap();
        keyMap.setFunctionName("func_name");
        keyMap.setKeymap(new ArrayList<Integer>());
        project.setKeymaps(new ArrayList<KeyMap>());
        project.getKeymaps().add(keyMap);
        return project;
    }

}
