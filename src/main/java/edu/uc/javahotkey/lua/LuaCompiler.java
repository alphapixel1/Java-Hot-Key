package edu.uc.javahotkey.lua;
import edu.uc.javahotkey.dto.Project;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
public class LuaCompiler implements  ILuaCompileService{

    @Override
    public Globals CompileProject(Project p) {
        return null;
    }

    @Override
    public RunTimeMessage TestMethod(String methodName) {
        return null;
    }


}
