package com.propio.literalura.Repository;

import com.propio.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE " +
            "YEAR(a.fechaNacimiento) <= :anio AND " +
            "(a.fechaFallecimiento IS NULL OR YEAR(a.fechaFallecimiento) > :año)")
    List<Autor> encontrarAutoresVivosEn(@Param("año") int año);
}
