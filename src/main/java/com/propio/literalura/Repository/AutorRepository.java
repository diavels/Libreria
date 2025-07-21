package com.propio.literalura.Repository;

import com.propio.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("SELECT a FROM Autor WHERE a.fechaDeNacimiento <= :año AND a.fechaDeFallecimiento >= :año")
    List<Autor> findAutoresVivos(String año);
}
