package com.outatime.app.exceptions;

/*
Unchecked exception
 */
public class SubjectsNotFoundException extends RuntimeException{
    public SubjectsNotFoundException(String message){
        super(message);
    }
}
