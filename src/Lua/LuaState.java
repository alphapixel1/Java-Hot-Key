package Lua;

import jdk.jshell.spi.ExecutionControl;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LuaState {
    public static LuaState currentState;
    private Globals state;
    //private String LuaCode;
    public LuaState(String LuaCode){
        state=JsePlatform.standardGlobals();
        state.load(LuaCode).call();

        //state.call();
        LuaTable keys=LuaValue.tableOf();
        for(Map.Entry<String,Integer> entry:Keys.entrySet()){
            keys.set(LuaValue.valueOf(entry.getKey()),LuaValue.valueOf(entry.getValue()));
        }
        //_g.hashset(LuaValue.valueOf("Keys"),keys);
        state.get(LuaValue.valueOf("run")).checkfunction();
        //state.set("__index",keys);
    }

    /**
     * Gets method from compiled state
     * @param name
     * @return
     */
    public LuaValue getMethod(String name){
        return state.get(name);
    }

    /**
     * Converts int array into LuaTable
     * @param keys
     * @return
     */
    public static LuaTable GetKeyArray(int[] keys){
        var table=LuaTable.tableOf();
        for (int i = 0; i < keys.length; i++) {
            table.set(i,LuaValue.valueOf(keys[i]));
        }
        return table;
    }

    /**
     * Hashmap of all the keys and their key codes
     */
    public static HashMap<String,Integer> Keys=new HashMap<>(){{
        put("Undefined",0);
        put("Escape",1);
        put("1",2);
        put("2",3);
        put("3",4);
        put("4",5);
        put("5",6);
        put("6",7);
        put("7",8);
        put("8",9);
        put("9",10);
        put("0",11);
        put("Minus",12);
        put("Equals",13);
        put("Backspace",14);
        put("Tab",15);
        put("Q",16);
        put("W",17);
        put("E",18);
        put("R",19);
        put("T",20);
        put("Y",21);
        put("U",22);
        put("I",23);
        put("O",24);
        put("P",25);
        put("OpenBracket",26);
        put("CloseBracket",27);
        put("Enter",28);
        put("Control",29);
        put("A",30);
        put("S",31);
        put("D",32);
        put("F",33);
        put("G",34);
        put("H",35);
        put("J",36);
        put("K",37);
        put("L",38);
        put("Semicolon",39);
        put("Quote",40);
        put("BackQuote",41);
        put("Shift",42);
        put("BackSlash",43);
        put("Z",44);
        put("X",45);
        put("C",46);
        put("V",47);
        put("B",48);
        put("N",49);
        put("M",50);
        put("Comma",51);
        put("Period",52);
        put("Slash",53);
        put("Alt",56);
        put("Space",57);
        put("CapsLock",58);
        put("F1",59);
        put("F2",60);
        put("F3",61);
        put("F4",62);
        put("F5",63);
        put("F6",64);
        put("F7",65);
        put("F8",66);
        put("F9",67);
        put("F10",68);
        put("NumLock",69);
        put("ScrollLock",70);
        put("NumPad",83);
        put("F11",87);
        put("F12",88);
        put("F13",91);
        put("F14",92);
        put("F15",93);
        put("F16",99);
        put("F17",100);
        put("F18",101);
        put("F19",102);
        put("F20",103);
        put("F21",104);
        put("F22",105);
        put("F23",106);
        put("F24",107);
        put("Katakana",112);
        put("Underscore",115);
        put("Furigana",119);
        put("Kanji",121);
        put("Hiragana",123);
        put("¥",125);
        put("PrintScreen",3639);
        put("Pause",3653);
        put("Home",3655);
        put("PageUp",3657);
        put("End",3663);
        put("PageDown",3665);
        put("Insert",3666);
        put("Delete",3667);
        put("Meta",3675);
        put("ContextMenu",3677);
        put("Previous",57360);
        put("Next",57369);
        put("Mute",57376);
        put("AppCalculator",57377);
        put("Play",57378);
        put("Stop",57380);
        put("Eject",57388);
        put("VolumeDown",57390);
        put("VolumeUp",57392);
        put("BrowserHome",57394);
        put("AppMusic",57404);
        put("Up",57416);
        put("Left",57419);
        put("Clear",57420);
        put("Right",57421);
        put("Down",57424);
        put("Power",57438);
        put("Sleep",57439);
        put("Wake",57443);
        put("AppPictures",57444);
        put("BrowserSearch",57445);
        put("BrowserFavorites",57446);
        put("BrowserRefresh",57447);
        put("BrowserStop",57448);
        put("BrowserForward",57449);
        put("BrowserBack",57450);
        put("AppMail",57452);
        put("Select",57453);
        put("SunOpen",65396);
        put("SunHelp",65397);
        put("SunProps",65398);
        put("SunFront",65399);
        put("SunStop",65400);
        put("SunAgain",65401);
        put("SunUndo",65402);
        put("SunCut",65403);
        put("SunCopy",65404);
        put("SunInsert",65405);
        put("SunFind",65406);
    }};
}
