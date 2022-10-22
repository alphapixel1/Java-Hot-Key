package edu.uc.javahotkey.lua;

import edu.uc.javahotkey.dto.Project;

public interface ILuaCompileService {
    org.luaj.vm2.Globals CompileProject(Project p);

    RunTimeMessage TestMethod(String methodName);

}
