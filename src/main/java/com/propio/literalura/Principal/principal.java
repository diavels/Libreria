package com.propio.literalura.Principal;
import com.propio.literalura.DTO.DatosAutor;
import com.propio.literalura.DTO.Datos;
import com.propio.literalura.DTO.DatosLibro;
import com.propio.literalura.Repository.LibroRepository;
import com.propio.literalura.Repository.AutorRepository;
import com.propio.literalura.Service.ConsumoAPI;
import com.propio.literalura.Service.ConvierteDatos;
import com.propio.literalura.model.Autor;
import com.propio.literalura.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class principal {

    @Autowired
    private final LibroRepository libroRepository;
    @Autowired
    private final AutorRepository AutorRepository;

    private final String UrlApi = "https://gutendex.com/books/?search=";
    Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<Libro> libros;
    private List<Autor> autores;


    public principal(LibroRepository libroRepository, AutorRepository AutorRepository) {
        this.libroRepository = libroRepository;
        this.AutorRepository = AutorRepository;
    }


    public void menuPrincipal() throws IOException, InterruptedException {

        int opcion = -1;
        //generar el menu y su bucle
        while (opcion != 0) {
            System.out.println("""
                    =====Bienvenidos a LiterAlura=========
                    
                    Elige una opcion
                    
                    1 - BUSCA UN LIBRO POR SU NOMBRE
                    2 - LISTA DE LIBROS REGISTRADOS
                    3 - LISTA DE AUTORES REGISTRADOS
                    4 - LISTA DE AUTORES VIVOS EN DETERMINADO AÑO
                    5 - LIBROS REGISTRADOS POR IDIOMA
                    
                    
                    0 - SALIR
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();
            //genera el switch que integra los metodos a aplicar segun cada caso

            switch (opcion) {
                case 1:
                    //funcion de budcar libro por nombre
                    buscarLibro();
                    break;
                case 2:
                    //mostrar lista de libros
                    mostrarListaDeLibros();
                    break;
                case 3:
                    //funcion de mostrar lista de autores registrados
                    mostrarListaDeAutores();
                case 4:
                    //mostrar lista de autores vivos segun año
                    mostrarAutoresVivos();
                case 5:
                    //mostrar libros por idioma, debe generar un texto
                    //que pueda hacer elegir entre distintos idiomas
                    //y luego mostrar los libros registrados en el idioma correspondiente
                    //mostrarLibrosPorIdioma();
                case 0:
                    System.out.println("""
                            ====CERRANDO LA APLICACION=====
                              GRACIAS POR SU PREFERENCIA
                            """);
                    break;
                default:
                    System.out.println("opcion incorrecta, ingrese otra opcion");
            }
        }
    }


    private Datos getDatosLibro() {
        System.out.println("¿Que libro desea buscar?");
        var nombreLibro = teclado.nextLine();
        var Json = consumoAPI.obtenerDatos(UrlApi + nombreLibro.replace(" ", "+"));
        Datos datos = conversor.obtenerDatos(Json, Datos.class);
        return datos;
    }

    private void buscarLibro() {
        Datos libro = getDatosLibro();
        Optional<DatosLibro> libroBuscado = libro.resultados().stream()
                .findFirst();


        if (libroBuscado.isPresent()) {
            DatosLibro datosLibro = libroBuscado.get();
            // Trae los datos que se necesitan en DatosAutor.
            DatosAutor nombreAutores = datosLibro.datosAutor().get(0);
            String nombreAutor = nombreAutores.nombre();
            String fechaNacimiento = nombreAutores.fechaDeNacimiento(); // Puede que sea un String o LocalDate
            String fechaFallecimiento = nombreAutores.fechaDeFallecimiento();
            //Busca si existe el nombre del autor
            Autor datosAutor = AutorRepository.findByNombre(nombreAutor)
                    .orElseGet(() -> {
                        Autor nuevoDatosAutor = new Autor();
                        nuevoDatosAutor.setNombre(nombreAutor);
                        nuevoDatosAutor.setFechaDeNacimiento(fechaNacimiento);
                        nuevoDatosAutor.setFechaDeFallecimiento(fechaFallecimiento);
                        return AutorRepository.save(nuevoDatosAutor);
                    });
            // Ahora sí, crear el libro
            Libro libroConvertido = Libro.convertirDesdeDatos(datosLibro, datosAutor);
            // Guardar libro o mostrarlo
            libroRepository.save(libroConvertido);
            System.out.println("Libro guardado: \n" + libroConvertido);


        } else {
            System.out.println("Libro no encontrado");
        }

    }


    private void mostrarListaDeLibros() {
        libros = libroRepository.findAll();
        System.out.println(libros);
    }

    private void mostrarListaDeAutores() {
        autores = AutorRepository.findAll();
        System.out.println(autores);
    }

    public void mostrarAutoresVivos() {
        System.out.print("Ingrese el año para consultar autores vivos: ");
        int año = teclado.nextInt();

        List<Autor> autoresVivos = AutorRepository.encontrarAutoresVivosEn(año);

        autoresVivos.forEach(a ->
                System.out.println(a.getNombre() + " — Nacido: " + a.getFechaDeNacimiento() +
                        ", Fallecido: " + (a.getFechaDeFallecimiento() != null ? a.getFechaDeFallecimiento() : "Vive"))
        );
    }




}