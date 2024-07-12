package com.televideocom.giornaliera.controller;


import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.Giornaliera;
import com.televideocom.giornaliera.entity.dto.DipendenteDto;
import com.televideocom.giornaliera.entity.dto.DipendenteRequest;
import com.televideocom.giornaliera.errors.EmptyObjException;
import com.televideocom.giornaliera.errors.WrongInputException;
import com.televideocom.giornaliera.errors.notAvailableException;
import com.televideocom.giornaliera.service.DipendenteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@Controller
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    DipendenteService ds;

    @GetMapping("/id")
    public ResponseEntity<Dipendente> findById (@RequestParam Long id) throws EmptyObjException {
        return new ResponseEntity(ds.findById(id), HttpStatus.OK);
    }

    @PostMapping("/username")
    public ResponseEntity<List<Giornaliera>> findByUsername (@RequestParam String username) throws EmptyObjException {
        return new ResponseEntity(ds.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DipendenteDto> saveDipendente (@RequestBody DipendenteDto d) throws EmptyObjException {
        return new ResponseEntity(ds.saveDipendente(d), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<DipendenteDto> updateDipendente(@RequestBody DipendenteDto request) throws EmptyObjException {
        return new ResponseEntity(ds.updateDipendente(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Dipendente> login (@RequestBody DipendenteRequest request) throws WrongInputException {
        return new ResponseEntity(ds.login(request), HttpStatus.OK);
    }

}
