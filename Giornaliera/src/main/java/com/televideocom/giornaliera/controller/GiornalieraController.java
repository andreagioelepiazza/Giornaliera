package com.televideocom.giornaliera.controller;


import com.televideocom.giornaliera.entity.Giornaliera;
import com.televideocom.giornaliera.entity.dto.GiornalieraDto;
import com.televideocom.giornaliera.entity.dto.PersonalEntity;
import com.televideocom.giornaliera.errors.EmptyObjException;
import com.televideocom.giornaliera.errors.WrongInputException;
import com.televideocom.giornaliera.repository.GiornalieraRepository;
import com.televideocom.giornaliera.service.GiornalieraService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api/giornaliera")
public class GiornalieraController {

    @Autowired
    GiornalieraService gs;

    @Autowired
    GiornalieraRepository gr;


    @Autowired
    private GiornalieraRepository giornalieraRepository;
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(giornalieraRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/test/{id}")
    public ResponseEntity<?> test1(@PathVariable("id") Long id) {
        return new ResponseEntity<>(giornalieraRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/giornaliera/{id}")
    public ResponseEntity<?> getGiornalieraById(@PathVariable("id") long id) {

        return new ResponseEntity<>(gs.findById(id), HttpStatus.OK);
    }


    @GetMapping(value = "/month", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByMonth(@RequestParam int month, @RequestParam int year) throws WrongInputException {
       List<Giornaliera> giornaliera = gs.findByMonth();
        return new ResponseEntity<>(giornaliera, HttpStatus.OK);
    }

//    @GetMapping("/day")
//    public ResponseEntity<GiornalieraDto> findByDay(@RequestParam int day) throws EmptyObjException {
//        return new ResponseEntity(gs.findByDay(day),HttpStatus.OK);
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<GiornalieraDto> updateDay(@RequestParam int day,@RequestParam int hours) throws EmptyObjException {
//        return new ResponseEntity(gs.updateDay(day,hours), HttpStatus.OK);
//    }

//    @GetMapping("/username")
//    public ResponseEntity<List<GiornalieraDto>> username(@RequestParam String username) throws EmptyObjException {
//        return new ResponseEntity(gs.findActualMonth(username), HttpStatus.OK);
//    }

    @GetMapping("/giornaliere")
    public ResponseEntity<List<GiornalieraDto>> giornaliere(@RequestParam String username, @RequestParam int click) throws EmptyObjException {
        return new ResponseEntity(gs.getAll(username, click), HttpStatus.OK);
    }

//    @PostMapping("/update")
//    public ResponseEntity<Giornaliera> update(@RequestBody Long id, @RequestBody GiornalieraDto a){
//        return new ResponseEntity(gs.update(id,a), HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Giornaliera> updateGiornaliera(@PathVariable("id") long id, @RequestBody GiornalieraDto giornaliera) {

        return new ResponseEntity<Giornaliera>(gs.update(id, giornaliera), HttpStatus.OK);

    }

}
