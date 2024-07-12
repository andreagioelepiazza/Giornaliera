package com.televideocom.giornaliera.errors;

public class notAvailableException extends Exception{

    private String message = "Codice identificativo già presente";

    public notAvailableException (){

    }

    public notAvailableException (String message){
        super(message);
        this.message = message;
    }
}
