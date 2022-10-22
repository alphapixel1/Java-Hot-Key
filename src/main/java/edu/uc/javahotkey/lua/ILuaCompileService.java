package edu.uc.javahotkey.lua;

import edu.uc.javahotkey.dto.Project;
import org.springframework.lang.Nullable;

public interface ILuaCompileService {
    LuaCompileData CompileProject(Project p);

    RunTimeMessage TestMethod(LuaCompileData data,String methodName);



}
