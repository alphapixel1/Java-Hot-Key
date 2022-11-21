package edu.uc.javahotkey.lua;

import edu.uc.javahotkey.dto.Project;

import java.util.ArrayList;

public interface ILuaCompileService {
    //LuaCompileData CompileProject(Project p);
    ArrayList<CompilerMessage> TestProject(Project p);


}
