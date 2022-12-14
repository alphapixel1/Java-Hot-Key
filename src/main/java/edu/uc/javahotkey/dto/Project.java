package edu.uc.javahotkey.dto;


import edu.uc.javahotkey.JavaHotKeyController;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
@Entity
public @Data class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NonNull
    private int id;
    @NonNull
    private String name;
    //private ArrayList<KeyMap> keymaps;
    private String keymapString;
    private String lua;

    private static final Logger log = LoggerFactory.getLogger(Project.class);

    public Project() {

    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return a default project with default code
     */
    public static Project Default() {
        var p=new Project(-1,"Unnamed");
        //p.keymaps=new ArrayList<>();
        p.keymapString=null;
        p.lua="function func_name(keys)\ndown(key.A)\nsleep(25)--ms\nup(key.A)\nend";
        return p;
    }
    @Override
    public String toString(){
        var s="null";
        if(this.keymapString!=null && !this.keymapString.isEmpty())
            s=Arrays.toString(getKeymaps().stream().map(KeyMap::toString).toArray());
        return "{ id="+id+
                ",name="+name+
                ",keymaps="+ s+
                ",lua="+lua.replace("\n","\\n")+"}";
    }

    /**
     * Parses the keymaps from the string and returns them as a keymap class
     * @return
     */
    public ArrayList<KeyMap> getKeymaps() {
        var keymaps = new ArrayList<KeyMap>();
        if (this.keymapString!=null && !this.keymapString.isEmpty()) {//saving the keybinds to the project
            for (String kbString : keymapString.split("\\.~\\.")) {
                var s = kbString.split("~");
                var map = new KeyMap();
                map.functionName = s[0];
                var keys = new ArrayList<Integer>();
                if (s.length > 1) {
                    for (String n : s[1].split(",")) {
                        try {
                            keys.add(Integer.parseInt(n));
                        } catch (Exception e) {
                            log.error("error with keybind", e);
                        }
                    }
                }
                map.keymap = keys;
                keymaps.add(map);
            }
        }
        return keymaps;
    }
}
