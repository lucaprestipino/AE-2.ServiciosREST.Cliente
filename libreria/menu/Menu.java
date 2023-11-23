package es.libreria.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import es.libreria.cliente.entidad.Libro;
import es.libreria.entrada.*;
import es.libreria.servicio.*;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServicioProxyLibros libros;

    private String baseUrl = "http://localhost:8080/libros"; // replace with your server URL

    public void tipoDeBusqueda() {
        Scanner read = new Scanner(System.in);
        int opc;
        String id;

        do {
            System.out.println("Bienvenido a la Libreria elige la operacion que quieres hacer");
            System.out.println("1: Dar de alta libro");
            System.out.println("2: Obtener libro por id");
            System.out.println("3: Dar de baja libro");
            System.out.println("4: Modificar libro");
            System.out.println("5: Ver todos los libros");
            System.out.println("6: Salir");
            while (!read.hasNextInt()) {
                System.out.println("¡Eso no es un número! Por favor, introduce un número:");
                read.next(); // discard
            }
            opc = read.nextInt();

            try {
                switch (opc) {
                case 1:
                    DarDeAltaLibro darDeAltaLibro = new DarDeAltaLibro();
                    Libro libro = darDeAltaLibro.CrearLibro();
                    libros.agregarLibro(libro);
                    break;
                case 2:
                	System.out.println("Por favor, introduce el id del libro que quieres buscar:");
                    id = read.next();
                	libros.buscarLibro(id);
                    break;
                case 3:
                	System.out.println("Por favor, introduce el id del libro a eliminar:");
                    id = read.next();
                    libros.eliminarLibro(id);
                    break;
                case 4:
                	ModificarLibro modificarLibro = new ModificarLibro();
                    System.out.println("Por favor, introduce el id del libro a modificar:");
                    id = read.next();
                    Libro libroAModificar = libros.buscarLibro(id);
                    modificarLibro.modificarLibroExistente(libroAModificar);
                    libros.agregarLibro(libroAModificar);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 5.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (opc != 6);
    }
}
