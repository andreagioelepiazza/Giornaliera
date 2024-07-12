package com.televideocom.giornaliera.service;

import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.Giornaliera;
import com.televideocom.giornaliera.entity.dto.GiornalieraDto;
import com.televideocom.giornaliera.entity.dto.PersonalEntity;
import com.televideocom.giornaliera.errors.EmptyObjException;
import com.televideocom.giornaliera.errors.WrongInputException;
import com.televideocom.giornaliera.repository.DipendenteRepository;
import com.televideocom.giornaliera.repository.GiornalieraRepository;
import com.televideocom.giornaliera.utils.GiornalieraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiornalieraService {

    @Autowired
    GiornalieraRepository gr;

    @Autowired
    DipendenteRepository dr;

    @Autowired
    DipendenteService ds;

    public List<Giornaliera> findByMonth() {
        LocalDate now = LocalDate.now();

        return gr.findByMonthAndYear(now.getMonthValue(), now.getYear());
    }


    public Giornaliera findById(Long id){
        Optional<Giornaliera> giornalieraData = gr.findById(id);

        if (giornalieraData.isPresent()) {
            return giornalieraData.get();
        }else{
            return null;
        }
    }

//    public GiornalieraDto findByDay(int day) throws EmptyObjException {
//        Optional<Giornaliera> g = gr.findByDay(day);
//        if(g.isEmpty()){
//            throw new EmptyObjException("Object not found");
//        }else {
//            GiornalieraDto gdto = GiornalieraUtils.convert(g);
//
//            return gdto;
//        }
//    }


//    public GiornalieraDto updateDay(int day, int hours) throws EmptyObjException {
//        Optional<Giornaliera> g = gr.findByDay(day);
//        if(g.isEmpty()){
//            throw new EmptyObjException("Object not found");
//        }else{
//            Giornaliera gio = g.get();
//            gio.setOre(hours);
//            GiornalieraDto gdto = GiornalieraUtils.convert(g);
//            gr.save(gio);
//            return gdto;
//        }
//    }

    public List<GiornalieraDto> findByUsername(String username) throws EmptyObjException {
        Dipendente d = ds.findByUsername(username);
        List<GiornalieraDto> lista = new ArrayList<GiornalieraDto>();
        for (int i = 0; i < d.getGiornaliera().size(); i++) {
            GiornalieraDto p = new GiornalieraDto();
            p.setData(d.getGiornaliera().get(i).getData());
            p.setOre(d.getGiornaliera().get(i).getOre());
            p.setNomeDipendente(d.getGiornaliera().get(i).getDipendente().getNome());
            p.setCognomeDipendente(d.getGiornaliera().get(i).getDipendente().getCognome());
            p.setId(d.getIdDipendente());
            lista.add(p);
        }


        return lista;
    }

    public List<GiornalieraDto> findActualMonth(String username, LocalDate date) throws EmptyObjException {
        Dipendente d = ds.findByUsername(username);
        List<GiornalieraDto> lista = new ArrayList<GiornalieraDto>();

        for (int i = 0; i < d.getGiornaliera().size(); i++) {

            int a = d.getGiornaliera().get(i).getData().getYear();
            int b = d.getGiornaliera().get(i).getData().getMonthValue();

            if (d.getGiornaliera().get(i).getData().getYear() == date.getYear() &&
                    d.getGiornaliera().get(i).getData().getMonthValue() == date.getMonthValue()) {

                GiornalieraDto p = new GiornalieraDto();


                p.setData(d.getGiornaliera().get(i).getData());
                p.setOre(d.getGiornaliera().get(i).getOre());
                p.setNomeDipendente(d.getGiornaliera().get(i).getDipendente().getNome());
                p.setCognomeDipendente(d.getGiornaliera().get(i).getDipendente().getCognome());
                p.setId(d.getIdDipendente());
                lista.add(p);
            }
        }
        return lista;
    }

    public List<GiornalieraDto> getAll(String username, int click) throws EmptyObjException {
        Dipendente d = ds.findByUsername(username);
        ArrayList <GiornalieraDto> giornaliera = createAllDays(GiornalieraUtils.getFirstOfMonth(click), d);

        giornaliera = (ArrayList<GiornalieraDto>) uploadGiornaliere(d,giornaliera);



        return giornaliera;


    }

    private ArrayList<GiornalieraDto> createAllDays(LocalDate now, Dipendente d) throws EmptyObjException {
        int month = now.getMonthValue();
        ArrayList<GiornalieraDto> giornaliere = new ArrayList<GiornalieraDto>();
        for (int j = 0; j < 31; j++) {
            GiornalieraDto a = new GiornalieraDto();

            LocalDate ex = now.plusDays(j);
            if (month == ex.getMonthValue()) {

                a.setCognomeDipendente(d.getCognome());
                a.setNomeDipendente(d.getNome());
                a.setData(ex);
                a.setOre(0);
                giornaliere.add(a);
            }
        }

        return giornaliere;

    }



    private Giornaliera convert (GiornalieraDto d) throws EmptyObjException {
        Giornaliera gio = new Giornaliera();

        gio.setOre(d.getOre());
        gio.setData(d.getData());
        gio.setDipendente(dr.findByNomeIgnoreCaseAndCognomeIgnoreCase(d.getNomeDipendente(),d.getCognomeDipendente()));
        return gio;
    }



    private List<GiornalieraDto> uploadGiornaliere(Dipendente d, ArrayList <GiornalieraDto> g) throws EmptyObjException {



        for(int i = 0; i<g.size(); i++){
            boolean save = true;

            for(int y = 0; y<d.getGiornaliera().size(); y++){
                if(g.get(i).getData().equals(d.getGiornaliera().get(y).getData())){
                    g.get(i).setId(d.getGiornaliera().get(y).getIdGiornaliera());
                    g.get(i).setOre(d.getGiornaliera().get(y).getOre());
                    g.get(i).setCognomeDipendente(d.getCognome());
                    g.get(i).setNomeDipendente(d.getNome());
                    save = false;
                }
            }
            if(save){
                Giornaliera a = convert(g.get(i));
                gr.save(a);
            }
        }
        return g;
    }

    public Giornaliera update (Long id, GiornalieraDto giornaliera) {
        Optional<Giornaliera> giornalieraData = gr.findById(id);

        if (giornalieraData.isPresent()) {
            Giornaliera gio = giornalieraData.get();
            gio.setOre(giornaliera.getOre());

            gr.save(gio);

            return gio;
        } else {
            return null;
        }

    }

}









