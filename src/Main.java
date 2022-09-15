import Data.Keybind;
import UI.MainForm;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("lol");
    //    MainGUI.Show();
        System.out.println(Keybind.getKeybindString(new int[]{1,2}));
        var mf2=new MainForm();
        var kbs= new ArrayList<Keybind>(Arrays.asList(
                new Keybind("func name",new int[]{1,2}),
                new Keybind("func name2",new int[]{20,30}),
                new Keybind()
        ));

        mf2.loadKeybinds(kbs);
        mf2.show();
    }

}
