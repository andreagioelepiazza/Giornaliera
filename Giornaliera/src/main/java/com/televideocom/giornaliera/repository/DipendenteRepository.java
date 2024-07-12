package com.televideocom.giornaliera.repository;

import com.televideocom.giornaliera.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository <Dipendente, Long> {

    public Optional<Dipendente> findByUsername(String username);

    public Dipendente findByNomeIgnoreCaseAndCognomeIgnoreCase(String nome, String cognome);

    public Optional<Dipendente> findByCodIdentificativo(String codIdentificativo);



}
