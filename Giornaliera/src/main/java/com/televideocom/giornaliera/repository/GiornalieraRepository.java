package com.televideocom.giornaliera.repository;

import com.televideocom.giornaliera.entity.Giornaliera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface GiornalieraRepository extends JpaRepository<Giornaliera, Long> {

    @Query("SELECT g FROM Giornaliera g WHERE MONTH(g.data) = :month AND YEAR(g.data) = :year")
    List<Giornaliera> findByMonthAndYear(@Param("month") int month, @Param("year") int year);


    @Query("SELECT g FROM Giornaliera g WHERE DAY(g.data) = :day")
    Optional<Giornaliera> findByDay (@Param("day") int day);
}
