package com.propio.literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(
       @JsonAlias("name") String nombre,
       @JsonAlias("birth_year") String fechaDeNacimiento,
       @JsonAlias("death_year") String fechaDeFallecimiento
) {
}
