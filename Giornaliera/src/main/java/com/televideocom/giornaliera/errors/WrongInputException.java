package com.televideocom.giornaliera.errors;

import lombok.Data;

@Data
public class WrongInputException extends Exception{

    private String message = "Wrong input";

    public WrongInputException (String message){
        super(message);
        this.message = message;
    }

}
