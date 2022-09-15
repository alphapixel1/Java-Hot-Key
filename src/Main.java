import Data.Keybind;
import Data.Project;
import UI.MainForm;

import java.util.ArrayList;
import java.util.Arrays;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.ZeroArgFunction;
import org.luaj.vm2.lib.jse.*;
public class Main {
    static final public class MyClass {

        public static int asd = 5;

        static public class Test extends ZeroArgFunction {

            @Override
            public LuaValue call() {
                System.out.println("Worked");
                return NIL;
            }
        }
    }

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
        //works https://sourceforge.net/projects/luaj/
       /* Globals globals = JsePlatform.standardGlobals();
        LuaValue test = CoerceJavaToLua.coerce(new MyClass());
        globals.set("obj", test);
        LuaTable t = new LuaTable();
        t.set("test", new MyClass.Test());
        t.set("__index", t);
        test.setmetatable(t);
        LuaValue chunk = globals.load("print('Testing', obj.asd) obj.test()");
        chunk.call();*/

        mf2.loadKeybinds(kbs);
        mf2.loadProject(Project.getDefaultProject());
        mf2.show();
    }

}
