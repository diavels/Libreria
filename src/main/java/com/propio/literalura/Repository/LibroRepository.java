package com.propio.literalura.Repository;

import com.propio.literalura.DTO.DatosLibro;
import com.propio.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.idioma = :opcion")
    List<Libro> findByLanguages(String opcion);
}
