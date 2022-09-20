package edu.uc.javahotkey.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class KeyMap {
    public ArrayList<Integer> keymap;
    public String functionName;
}
