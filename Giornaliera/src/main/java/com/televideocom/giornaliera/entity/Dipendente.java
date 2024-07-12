package com.televideocom.giornaliera.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "dipendente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dipendente")
    private Long idDipendente;

    @Column(name="cod_identificativo", length=100)
    private String codIdentificativo;


    @Column(name="nome", length=100)
    private String nome;

    @Column(name="cognome", length=100)
    private String cognome;

    @Column(name="username", length=100)
    private String username;

    @Column(name="password", length=100)
    private String password;


    @OneToMany(mappedBy = "dipendente")
    @JsonManagedReference
    private List<Giornaliera> giornaliera;



}

