package com.propio.literalura.Repository;

import com.propio.literalura.DTO.DatosLibro;
import com.propio.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
