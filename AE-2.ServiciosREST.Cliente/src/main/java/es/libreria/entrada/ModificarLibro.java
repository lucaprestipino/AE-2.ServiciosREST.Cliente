package es.libreria.entrada;

import java.util.Scanner;
import es.libreria.cliente.entidad.Libro;

public class ModificarLibro {
	
    public void modificarLibroExistente(Libro libro) {
        Scanner read = new Scanner(System.in);

        System.out.println("Por favor, introduce el id del libro:");
        String id = read.next();
        libro.setIdLibro(id);

        System.out.println("Por favor, introduce el genero del libro:");
        String genero = read.next();
        libro.setGeneroLibro(genero);

        System.out.println("Por favor, introduce el titulo del libro:");
        String titulo = read.next();
        libro.setTitulo(titulo);

        System.out.println("Por favor, introduce el escritor del libro:");
        String escritor = read.next();
        libro.setEscritor(escritor);

        System.out.println("Por favor, introduce el stock del libro:");
        int stock = read.nextInt();
        libro.setStock(stock);

        System.out.println("Por favor, introduce el precio del libro:");
        double precio = read.nextDouble();
        libro.setPrecioLibro(precio);
    }
}
