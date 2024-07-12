package com.televideocom.giornaliera.entity.dto;

import lombok.Data;

@Data
public class DipendenteRequest {

    String username;

    String password;

    public String getUsername(){
        return username;
    }
}
