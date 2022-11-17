package edu.uc.javahotkey.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class KeyMap {
    public ArrayList<Integer> keymap;
    public String functionName;
    @Override
    public String toString(){
        return "{ function="+functionName+
                ", keymap="+ Arrays.toString(keymap.toArray())+"}";
    }
}
