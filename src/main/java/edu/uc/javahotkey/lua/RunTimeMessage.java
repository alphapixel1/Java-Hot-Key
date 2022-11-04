package edu.uc.javahotkey.lua;

public class RunTimeMessage {
    private String Message;
    private int LineNumber;

    public void setMessage(String message) {
        Message = message;
    }

    public void setLineNumber(int lineNumber) {
        LineNumber = lineNumber;
    }

    public void setSuccess(boolean success) {
        IsSuccess = success;
    }

    private boolean IsSuccess;

    public RunTimeMessage(String message, int lineNumber, boolean isSuccess){
        Message=message;
        LineNumber=lineNumber;
        IsSuccess =isSuccess;
    }



    /**
     *
     * @return returns whether the run was successful
     */
    public boolean isSuccess() {
        return IsSuccess;
    }

    /**
     *
     * @return the message from runtime
     */
    public String getMessage() {
        return Message;
    }

    /**
     *
     * @return the line number
     */
    public int getLineNumber() {
        return LineNumber;
    }
}
