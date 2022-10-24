package edu.uc.javahotkey.lua;

import org.luaj.vm2.Globals;

public class LuaCompileData {

    private final Globals global;
    private final RunTimeMessage message;

    public LuaCompileData (Globals global, RunTimeMessage message){

        this.global = global;
        this.message = message;
    }

    public RunTimeMessage getMessage() {
        return message;
    }

    public Globals getGlobal() {
        return global;
    }
}
