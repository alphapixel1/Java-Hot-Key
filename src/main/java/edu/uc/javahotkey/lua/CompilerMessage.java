package edu.uc.javahotkey.lua;


/**
 * For use in the webapp to display compiler messages
 */
public class CompilerMessage {
    public CompilerMessage(String message, boolean isError) {
        Message = message;
        this.isError = isError;
    }

    public String Message;
    public boolean isError;
}
