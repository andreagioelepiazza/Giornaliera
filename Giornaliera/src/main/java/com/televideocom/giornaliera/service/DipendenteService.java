package com.televideocom.giornaliera.service;

import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.dto.DipendenteDto;
import com.televideocom.giornaliera.entity.dto.DipendenteRequest;
import com.televideocom.giornaliera.errors.EmptyObjException;
import com.televideocom.giornaliera.errors.WrongInputException;
import com.televideocom.giornaliera.errors.notAvailableException;
import com.televideocom.giornaliera.repository.DipendenteRepository;
import com.televideocom.giornaliera.utils.DipendenteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    DipendenteRepository dr;


    public Dipendente findById(Long id) throws EmptyObjException {
        Optional<Dipendente> d = dr.findById(id);
        Dipendente dip = d.get();
        if(d.isEmpty()){
            throw new EmptyObjException("La ricerca non ha prodotto nessun risultato");
        }else{
           return dip;
        }
    }

    public Dipendente findByUsername(String username) throws EmptyObjException {
        Optional<Dipendente> d = dr.findByUsername(username);
        Dipendente dipendente = d.get();

        if(d.isEmpty()){
            throw new EmptyObjException("La ricerca non ha prodotto nessun risultato");
        }else{
            return dipendente;
        }
    }

    public DipendenteDto saveDipendente (DipendenteDto dip) throws EmptyObjException {
        Dipendente d = DipendenteUtils.reverseConvert(dip);
        dr.save(d);
        return dip;
    }

    public DipendenteDto updateDipendente(DipendenteDto request) throws EmptyObjException {
        Optional<Dipendente> d = dr.findByCodIdentificativo(request.getCodIdentificativo());
        if(d.isEmpty()){
            throw new EmptyObjException("La ricerca non ha prodotto nessun risultato");
        }else{
            Dipendente dip = d.get();
            dip.setIdDipendente(d.get().getIdDipendente());
            dip.setNome(request.getNome());
            dip.setCognome(request.getCognome());
            dip.setUsername(request.getUsername());
            dip.setCodIdentificativo(request.getCodIdentificativo());
            dr.save(dip);
            return request;

        }
    }


    public Dipendente login (DipendenteRequest d) throws WrongInputException {
        Optional<Dipendente> dip = dr.findByUsername(d.getUsername());
        if (d.getUsername().equals(dip.get().getUsername())) {
            if (d.getPassword().equals(dip.get().getPassword())) {
                return dip.get();
            } else {
                throw new WrongInputException("Username o password non corretti");
            }
        }else {
            throw new WrongInputException("Username o password non corretti");
        }
    }




}
