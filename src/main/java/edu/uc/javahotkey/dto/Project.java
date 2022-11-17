package edu.uc.javahotkey.dto;


import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Project {
    @NonNull
    private int id;
    @NonNull
    private String name;
    private ArrayList<KeyMap> keymaps;
    private String lua;
    public static Project Default(){
        var p=new Project(-1,"Unnamed");
        p.keymaps=new ArrayList<>();
        p.lua="function func_name(keys)\ndown(key.A)\nsleep(25)--ms\nup(key.A)\nend";
        return p;
    }
    @Override
    public String toString(){
        var s="null";
        if(keymaps!=null)
            s=Arrays.toString(keymaps.stream().map(KeyMap::toString).toArray());
        return "{ id="+id+
                ",name="+name+
                ",keymaps="+ s+
                ",lua="+lua.replace("\n","\\n")+"}";
    }
}
