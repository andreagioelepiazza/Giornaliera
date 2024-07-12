package com.televideocom.giornaliera.errors;

public class EmptyObjException extends Exception {

    private String message = "Oggetto vuoto";

    public EmptyObjException (){

    }

    public EmptyObjException (String message){
        super(message);
        this.message = message;
    }
}
