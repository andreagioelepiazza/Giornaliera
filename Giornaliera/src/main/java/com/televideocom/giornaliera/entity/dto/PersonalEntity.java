package com.televideocom.giornaliera.entity.dto;

import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.Giornaliera;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonalEntity {

    private Dipendente dipendente;

    private List<Giornaliera> giornaliere;








}
