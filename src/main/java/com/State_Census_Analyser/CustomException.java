package com.State_Census_Analyser;

public class CustomException extends Exception{
    public enum ExceptionType {
        Wrong_File,
        Wrong_File_Type,
        Wrong_File_Delimiter
    }
    public ExceptionType type;

    public CustomException(String s,ExceptionType type){
        super(s);
        this.type=type;
    }

}