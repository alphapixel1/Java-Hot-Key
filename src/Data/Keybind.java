package Data;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class Keybind {
    public String LuaFunction;
    public int[] keybind;
    public Keybind(){
        LuaFunction="";
        keybind=new int[0];
    }
    public Keybind(String func,int[] keys){
        LuaFunction=func;
        keybind=keys;
    }

    public static String getKeybindString(int[] keys){
        if(keys.length==0)
            return"Unset";
        var ret="";
        for (int key : keys) {
            ret+= NativeKeyEvent.getKeyText(key)+" + ";
        }
        return ret.substring(0,ret.length()-3);
    }
}
