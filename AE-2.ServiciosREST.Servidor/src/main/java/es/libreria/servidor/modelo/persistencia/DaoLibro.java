package es.libreria.servidor.modelo.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import es.libreria.servidor.entidad.Libro;

@Repository
public class DaoLibro {
	ArrayList<Libro> listaLibros = new ArrayList<>();

	public DaoLibro() {
		
		System.out.println("Dao Libro Creando La lista de libros");
		listaLibros.add(new Libro("Novela", "Cien años de soledad", "Gabriel García Márquez", 20, "P02", 20.5));
		listaLibros.add(new Libro("Novela", "Don Quijote de la Mancha", "Miguel de Cervantes", 20, "P03", 20.5));

		listaLibros.add(new Libro("Poesía", "Veinte poemas de amor y una canción desesperada", "Pablo Neruda", 20,"P04", 20.5));
		listaLibros.add(new Libro("Poesía", "Poeta en Nueva York", "Federico García Lorca", 20, "P05", 20.5));
		listaLibros.add(new Libro("Poesía", "Cantares Gallegos", "Rosalía de Castro", 20, "P06", 20.5));

		listaLibros.add(new Libro("Drama", "La casa de Bernarda Alba", "Federico García Lorca", 20, "P07", 20.5));
		listaLibros.add(new Libro("Drama", "Bodas de sangre", "Federico García Lorca", 20, "P08", 20.5));
		listaLibros.add(new Libro("Drama", "Yerma", "Federico García Lorca", 20, "P09", 20.5));

		listaLibros.add(new Libro("Ensayo", "El laberinto de la soledad", "Octavio Paz", 20, "P10", 20.5));
		listaLibros.add(new Libro("Ensayo", "Las venas abiertas de América Latina", "Eduardo Galeano", 20, "P11", 20.5));
		listaLibros.add(new Libro("Ensayo", "Del amor y otros demonios", "Gabriel García Márquez", 20, "P12", 20.5));
	}

	public Libro obtenerLibroPorId(String id) {
		for (Libro libro : listaLibros) {
			if (libro.getIdLibro().equals(id)) {
				return libro;
			}
		}
		return null;
	}
	
	public void eliminarLibro(Libro libro) {
	    listaLibros.remove(libro);
	}


	public void agregarLibro(Libro nuevoLibro) {
		listaLibros.add(nuevoLibro);
	}

	public void modificarLibro(Libro libroModificado) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getIdLibro().equals(libroModificado.getIdLibro())) {
                listaLibros.set(i, libroModificado);
                return;
            }
        }
    }

	public ArrayList<Libro> obtenerTodosLosLibros() {
	    return listaLibros;
	}
}