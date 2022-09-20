package edu.uc.javahotkey.dto;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Project {
    private String name;
    private ArrayList<KeyMap> keymaps;
    private String lua;
}
