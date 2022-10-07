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
}
