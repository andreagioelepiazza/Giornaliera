package com.televideocom.giornaliera.utils;

import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.dto.DipendenteDto;
import com.televideocom.giornaliera.errors.EmptyObjException;

import java.util.Optional;

public class DipendenteUtils {

    public static DipendenteDto convert (Optional<Dipendente> d) throws EmptyObjException {
        DipendenteDto dip = new DipendenteDto();
            dip.setNome(d.get().getNome());
            dip.setCognome(d.get().getCognome());
            dip.setUsername(d.get().getUsername());
            dip.setPassword(d.get().getPassword());
            dip.setCodIdentificativo(d.get().getCodIdentificativo());
            return dip;

    }
    public static Dipendente reverseConvert (DipendenteDto d) throws EmptyObjException {
        Dipendente dip = new Dipendente();
        if(isEmpty(d)) {
            dip.setNome(d.getNome());
            dip.setCognome(d.getCognome());
            dip.setUsername(d.getUsername());
            dip.setPassword(d.getPassword());
            dip.setCodIdentificativo(d.getCodIdentificativo());
            return dip;
        }else{
            throw new EmptyObjException("Empty object arrived");
        }

    }




    public static Dipendente reverseConvert (Optional<Dipendente> d) throws EmptyObjException {
        Dipendente dip = new Dipendente();
        if(d.isEmpty()) {
            throw new EmptyObjException("Empty object arrived");
        }else{
            dip.setNome(d.get().getNome());
            dip.setCognome(d.get().getCognome());
            dip.setUsername(d.get().getUsername());
            dip.setPassword(d.get().getPassword());
            dip.setCodIdentificativo(d.get().getCodIdentificativo());
            return dip;
        }

    }

    public static boolean isEmpty (DipendenteDto d){
        if(d != null){
            return true;
        }else{
            return false;
        }
    }






}
