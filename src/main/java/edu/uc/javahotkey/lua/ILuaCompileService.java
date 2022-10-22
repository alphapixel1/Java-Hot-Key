package edu.uc.javahotkey.lua;

import edu.uc.javahotkey.dto.Project;

public interface ILuaCompileService {
    LuaState CompileProject(Project p);
}
