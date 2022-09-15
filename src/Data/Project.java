package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {
    public String name,luaCode;
    public ArrayList<Keybind> keybinds;
    public static Project getDefaultProject(){
        var p= new Project();
        p.name="Unnamed";
        p.keybinds= new ArrayList<>(List.of(new Keybind("run", new int[]{56, 20})));
        p.luaCode= "--This is a comment\n" +
                "--run is the function that is called when Alt + T is pressed\n" +
                "function run(keys)\n" +
                "\tkeyboard.down(key.A)\n" +
                "\tsleep(40)--ms\n" +
                "\tkeyboard.up(key.A)\n" +
                "end";
        return p;
    }
}
