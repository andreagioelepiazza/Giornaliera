package com.televideocom.giornaliera.entity.dto;

import com.televideocom.giornaliera.entity.Giornaliera;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GiornalieraDto {

    private Long id = 0L;

    private String nomeDipendente;

    private String cognomeDipendente;

    private LocalDate data;

    private int ore;


    public GiornalieraDto (){
    }




}
