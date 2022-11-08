package edu.uc.javahotkey.dto;


import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

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
        p.lua="function func_name(keys)\nDown(Key.A)\nSleep(25)--ms\nUp(Key.A)\nPress(Key.B)\nend";
        return p;
    }
}
