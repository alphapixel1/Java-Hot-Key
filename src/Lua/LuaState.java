package Lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.awt.*;
import java.awt.event.KeyEvent;
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
        state.set(LuaValue.valueOf("Keys"),keys);


        LuaValue test = CoerceJavaToLua.coerce(new KeyboardSim());
        state.set("Keyboard", test);
        LuaTable t=new LuaTable();
        t.set("down",new KeyboardSim.Down());

        t.set("__index", t);
        test.setmetatable(t);
        //state.hashset(LuaValue.valueOf("Keys"),keys);
        //state.get(LuaValue.valueOf("run")).checkfunction();
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

    static final public class KeyboardSim {

        static public class Down extends org.luaj.vm2.lib.OneArgFunction  {
            @Override
            public LuaValue call(LuaValue arg) {
                try {

                    var code=arg.checkint();
                    if(Keys.containsValue(code)) {
                        //System.out.println(code + " checkInt");a
                        //System.out.println(KeyEvent.getKeyText(code));
                        var a = new java.awt.Robot();
                        a.keyPress(code);
                    }
                } catch (AWTException e) {
                    return null;
                    //Ignore
                }

                return null;
            }

        }
    }

    /**
     * Hashmap of all the keys and their key codes
     */
    public static HashMap<String,Integer> Keys=new HashMap<>(){{
        put("CANCEL",0x03);
        put("CLEAR",0x0C);
        put("SHIFT",0x10);
        put("CONTROL",0x11);
        put("ALT",0x12);
        put("PAUSE",0x13);
        put("CAPS_LOCK",0x14);
        put("ESCAPE",0x1B);
        put("SPACE",0x20);
        put("PAGE_UP",0x21);
        put("PAGE_DOWN",0x22);
        put("END",0x23);
        put("HOME",0x24);
        put("LEFT",0x25);
        put("UP",0x26);
        put("RIGHT",0x27);
        put("DOWN",0x28);
        put("COMMA",0x2C);
        put("MINUS",0x2D);
        put("PERIOD",0x2E);
        put("SLASH",0x2F);
        put("0",0x30);
        put("1",0x31);
        put("2",0x32);
        put("3",0x33);
        put("4",0x34);
        put("5",0x35);
        put("6",0x36);
        put("7",0x37);
        put("8",0x38);
        put("9",0x39);
        put("SEMICOLON",0x3B);
        put("EQUALS",0x3D);
        put("A",0x41);
        put("B",0x42);
        put("C",0x43);
        put("D",0x44);
        put("E",0x45);
        put("F",0x46);
        put("G",0x47);
        put("H",0x48);
        put("I",0x49);
        put("J",0x4A);
        put("K",0x4B);
        put("L",0x4C);
        put("M",0x4D);
        put("N",0x4E);
        put("O",0x4F);
        put("P",0x50);
        put("Q",0x51);
        put("R",0x52);
        put("S",0x53);
        put("T",0x54);
        put("U",0x55);
        put("V",0x56);
        put("W",0x57);
        put("X",0x58);
        put("Y",0x59);
        put("Z",0x5A);
        put("OPEN_BRACKET",0x5B);
        put("BACK_SLASH",0x5C);
        put("CLOSE_BRACKET",0x5D);
        put("NUMPAD0",0x60);
        put("NUMPAD1",0x61);
        put("NUMPAD2",0x62);
        put("NUMPAD3",0x63);
        put("NUMPAD4",0x64);
        put("NUMPAD5",0x65);
        put("NUMPAD6",0x66);
        put("NUMPAD7",0x67);
        put("NUMPAD8",0x68);
        put("NUMPAD9",0x69);
        put("MULTIPLY",0x6A);
        put("ADD",0x6B);
        //put("SEPARATER",0x6C);
        put("SEPARATOR",0x6C);
        put("SUBTRACT",0x6D);
        put("DECIMAL",0x6E);
        put("DIVIDE",0x6F);
        put("DELETE",0x7F);
        put("NUM_LOCK",0x90);
        put("SCROLL_LOCK",0x91);
        put("F1",0x70);
        put("F2",0x71);
        put("F3",0x72);
        put("F4",0x73);
        put("F5",0x74);
        put("F6",0x75);
        put("F7",0x76);
        put("F8",0x77);
        put("F9",0x78);
        put("F10",0x79);
        put("F11",0x7A);
        put("F12",0x7B);
        put("F13",0xF000);
        put("F14",0xF001);
        put("F15",0xF002);
        put("F16",0xF003);
        put("F17",0xF004);
        put("F18",0xF005);
        put("F19",0xF006);
        put("F20",0xF007);
        put("F21",0xF008);
        put("F22",0xF009);
        put("F23",0xF00A);
        put("F24",0xF00B);
        put("PRINTSCREEN",0x9A);
        put("INSERT",0x9B);
        put("HELP",0x9C);
        put("META",0x9D);
        put("BACK_QUOTE",0xC0);
        put("QUOTE",0xDE);
        put("KP_UP",0xE0);
        put("KP_DOWN",0xE1);
        put("KP_LEFT",0xE2);
        put("KP_RIGHT",0xE3);
        put("DEAD_GRAVE",0x80);
        put("DEAD_ACUTE",0x81);
        put("DEAD_CIRCUMFLEX",0x82);
        put("DEAD_TILDE",0x83);
        put("DEAD_MACRON",0x84);
        put("DEAD_BREVE",0x85);
        put("DEAD_ABOVEDOT",0x86);
        put("DEAD_DIAERESIS",0x87);
        put("DEAD_ABOVERING",0x88);
        put("DEAD_DOUBLEACUTE",0x89);
        put("DEAD_CARON",0x8a);
        put("DEAD_CEDILLA",0x8b);
        put("DEAD_OGONEK",0x8c);
        put("DEAD_IOTA",0x8d);
        put("DEAD_VOICED_SOUND",0x8e);
        put("DEAD_SEMIVOICED_SOUND",0x8f);
        put("AMPERSAND",0x96);
        put("ASTERISK",0x97);
        put("QUOTEDBL",0x98);
        put("LESS",0x99);
        put("GREATER",0xa0);
        put("BRACELEFT",0xa1);
        put("BRACERIGHT",0xa2);
        put("AT",0x0200);
        put("COLON",0x0201);
        put("CIRCUMFLEX",0x0202);
        put("DOLLAR",0x0203);
        put("EURO_SIGN",0x0204);
        put("EXCLAMATION_MARK",0x0205);
        put("INVERTED_EXCLAMATION_MARK",0x0206);
        put("LEFT_PARENTHESIS",0x0207);
        put("NUMBER_SIGN",0x0208);
        put("PLUS",0x0209);
        put("RIGHT_PARENTHESIS",0x020A);
        put("UNDERSCORE",0x020B);
        put("WINDOWS",0x020C);
        put("CONTEXT_MENU",0x020D);
        put("FINAL",0x0018);
        put("CONVERT",0x001C);
        put("NONCONVERT",0x001D);
        put("ACCEPT",0x001E);
        put("MODECHANGE",0x001F);
        put("KANA",0x0015);
        put("KANJI",0x0019);
        put("ALPHANUMERIC",0x00F0);
        put("KATAKANA",0x00F1);
        put("HIRAGANA",0x00F2);
        put("FULL_WIDTH",0x00F3);
        put("HALF_WIDTH",0x00F4);
        put("ROMAN_CHARACTERS",0x00F5);
        put("ALL_CANDIDATES",0x0100);
        put("PREVIOUS_CANDIDATE",0x0101);
        put("CODE_INPUT",0x0102);
        put("JAPANESE_KATAKANA",0x0103);
        put("JAPANESE_HIRAGANA",0x0104);
        put("JAPANESE_ROMAN",0x0105);
        put("KANA_LOCK",0x0106);
        put("INPUT_METHOD_ON_OFF",0x0107);
        put("CUT",0xFFD1);
        put("COPY",0xFFCD);
        put("PASTE",0xFFCF);
        put("UNDO",0xFFCB);
        put("AGAIN",0xFFC9);
        put("FIND",0xFFD0);
        put("PROPS",0xFFCA);
        put("STOP",0xFFC8);
        put("COMPOSE",0xFF20);
        put("ALT_GRAPH",0xFF7E);
        put("BEGIN",0xFF58);
        }
    };
    /*
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
    */
}
