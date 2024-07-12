package com.televideocom.giornaliera.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name= "giornaliera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Giornaliera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_giornaliera")
    private Long idGiornaliera;

    @Temporal(TemporalType.DATE)
    private LocalDate data;

    private int ore;

    @ManyToOne
    @JoinColumn(name = "id_dipendente")
    @JsonBackReference
    private Dipendente dipendente;
}
