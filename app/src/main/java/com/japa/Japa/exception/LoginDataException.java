package com.japa.Japa.exception;

public class LoginDataException extends Exception {
    private String errorMessage;


    public LoginDataException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
