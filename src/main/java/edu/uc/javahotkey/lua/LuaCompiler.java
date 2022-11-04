package edu.uc.javahotkey.lua;
import edu.uc.javahotkey.dto.Project;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LuaCompiler implements  ILuaCompileService{
    private String GlobalString;
    private String getGlobalString() throws IOException {
        if(GlobalString!=null)
            return GlobalString;
        GlobalString=Files.readString(Path.of("src/main/java/edu/uc/javahotkey/lua/globals.lua"));
        return GlobalString;
    }

    @Override
    public LuaCompileData CompileProject(Project p) {
        Globals g=JsePlatform.standardGlobals();
        RunTimeMessage msg;
        try{
            g.load(getGlobalString()).call();
            g.load(p.getLua()).call();
            /*LuaValue test = CoerceJavaToLua.coerce(new KeyboardSim());
            g.set("Keyboard", test);
            LuaTable t=new LuaTable();
            t.set("down",new KeyboardSim.Down());
            t.set("up",new KeyboardSim.Up());
            t.set("__index", t);
            test.setmetatable(t);*/
            msg=new RunTimeMessage("Code Compiled Successfully",-1,true);
        }catch (LuaError e){
            msg=new RunTimeMessage(e.getMessage(),-1,false);
        } catch (IOException e) {
           msg=new RunTimeMessage("globals.lua Was Not Found: Server Error",-1,false);
        }
        return new LuaCompileData(g,msg);
    }

    @Override
    public RunTimeMessage TestMethod(LuaCompileData data, String methodName) {
        return null;
    }
}
