package com.televideocom.giornaliera.utils;

import com.televideocom.giornaliera.entity.Dipendente;
import com.televideocom.giornaliera.entity.Giornaliera;
import com.televideocom.giornaliera.entity.dto.DipendenteDto;
import com.televideocom.giornaliera.entity.dto.GiornalieraDto;
import com.televideocom.giornaliera.errors.EmptyObjException;
import com.televideocom.giornaliera.repository.DipendenteRepository;
import com.televideocom.giornaliera.repository.GiornalieraRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GiornalieraUtils {

    @Autowired
    DipendenteRepository dr;

    @Autowired
    static GiornalieraRepository gr;

    private Giornaliera convert (GiornalieraDto d) throws EmptyObjException {
       Giornaliera gio = new Giornaliera();

       gio.setOre(d.getOre());
       gio.setData(d.getData());
       gio.setDipendente(dr.findByNomeIgnoreCaseAndCognomeIgnoreCase(d.getNomeDipendente(),d.getCognomeDipendente()));
        return gio;
    }


    public static DipendenteDto convertDipendenteDto(Dipendente d) {
        DipendenteDto dip = new DipendenteDto();
        dip.setId(d.getIdDipendente());
        dip.setCognome(d.getCognome());
        dip.setNome(d.getNome());
        dip.setUsername(d.getUsername());
        dip.setPassword(d.getPassword());
        dip.setCodIdentificativo(d.getCodIdentificativo());
        return dip;
    }

    public static LocalDate getFirstOfMonth(int i) {
        LocalDate now = LocalDate.now();
        now = now.minusMonths(i);
        now = now.minusDays(now.getDayOfMonth() - 1);
        return now;
    }

    public static ArrayList<GiornalieraDto> createAllDays(LocalDate now, Dipendente d) {
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

    public static List<GiornalieraDto> uploadGiornaliere(Dipendente d, ArrayList <GiornalieraDto> g){



        for(int i = 0; i<g.size(); i++){
            for(int y = 0; y<d.getGiornaliera().size(); y++){
                if(g.get(i).getData().equals(d.getGiornaliera().get(y).getData())){
                    g.get(i).setOre(d.getGiornaliera().get(y).getOre());
                    g.get(i).setCognomeDipendente(d.getCognome());
                    g.get(i).setNomeDipendente(d.getNome());
                    g.get(i).setId(d.getGiornaliera().get(y).getIdGiornaliera());

                }
            }
        }
        return g;
    }







}
