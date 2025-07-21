package com.propio.literalura;

import com.propio.literalura.Principal.principal;
import com.propio.literalura.Repository.LibroRepository;
import com.propio.literalura.Repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepositorio;
	@Autowired
	private AutorRepository AutorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal principal= new principal(libroRepositorio, AutorRepositorio);
		principal.menuPrincipal();
	}
}