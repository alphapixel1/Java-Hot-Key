package edu.uc.javahotkey.lua;
import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import kotlin.NotImplementedError;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LuaCompiler implements  ILuaCompileService{
    private String GlobalString;
    private String getGlobalString() throws IOException {
        if(GlobalString!=null)
            return GlobalString;
        GlobalString=Files.readString(Path.of("src/main/java/edu/uc/javahotkey/lua/globals.lua"));
        return GlobalString;
    }
    public ArrayList<CompilerMessage> TestProject(Project p){
        ArrayList<CompilerMessage> ret=new ArrayList<>();
        Globals g=JsePlatform.standardGlobals();
        try{
            g.load(getGlobalString()).call();
            //System.err.println(p.getLua());
            g.load(p.getLua()).call();
            ret.add(new CompilerMessage("Initial Compiling Successful",false));
            if(p.getKeymaps()!=null) {
                CheckFunctions(g, ret, p);
            }
        }catch (LuaError e){
            ret.add(new CompilerMessage("Compile Error: "+e.getMessage(),true));
        } catch (IOException e) {
            ret.add(new CompilerMessage("Server Error: globals.lua Was Not Found",true));
        }
        return ret;
    }
   /* @Override
    public LuaCompileData CompileProject(Project p) {
        Globals g=JsePlatform.standardGlobals();
        RunTimeMessage msg;
        try{
            g.load(getGlobalString()).call();
            System.err.println(p.getLua());
            g.load(p.getLua()).call();
            msg=new RunTimeMessage("Code Compiled Successfully",-1,true);
        }catch (LuaError e){
            msg=new RunTimeMessage(e.getMessage(),-1,false);
        } catch (IOException e) {
           msg=new RunTimeMessage("globals.lua Was Not Found: Server Error",-1,false);
        }
        return new LuaCompileData(g,msg);
    }*/
    private void CheckFunctions(Globals g,ArrayList<CompilerMessage> msg, Project p) {
        for (KeyMap km:p.getKeymaps()) {
            try{
                g.get(km.functionName).call(LuaValue.listOf(new LuaValue[]{LuaValue.valueOf(65)}));
                msg.add(new CompilerMessage("Function \""+km.functionName+"\" Exists And Compiled Successfully",false));
            }catch (LuaError e){
                msg.add(new CompilerMessage("Function \""+km.functionName+"\" Does Not Exist Or Could Not Be Compiled Successfully",true));
                msg.add(new CompilerMessage("- Error: "+e.getMessage(),true));
            }catch (Exception e){
                throw new NotImplementedError();
            }
        }

    }
}
