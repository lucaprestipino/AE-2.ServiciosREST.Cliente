package es.libreria.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.libreria.cliente.entidad.Libro;

@Service
public class ServicioProxyLibros {

	public static final String URL = "http://localhost:8081/Libro"; // Removed trailing slash

	@Autowired
	private RestTemplate restTemplate;

	public Libro agregarLibro(Libro libro) {
		try {
			ResponseEntity<Libro> response = restTemplate.postForEntity(URL, libro, Libro.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				System.out.println("Libro añadido con éxito!");
				return response.getBody();
			} else {
				System.out.println("Error al añadir el libro!");
				return null;
			}
		} catch (HttpClientErrorException e) {
			System.out.println("Error al añadir el libro: " + e.getStatusCode());
			return null;
		}
	}

	public Libro buscarLibro(String idLibro) {
		try {
			ResponseEntity<Libro> response = restTemplate.getForEntity(URL + "/" + idLibro, Libro.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				return response.getBody();
			} else {
				System.out.println("Libro no encontrado!");
				return null;
			}
		} catch (HttpClientErrorException e) {
			System.out.println("Error al buscar el libro: " + e.getStatusCode());
			return null;
		}
	}

	public void eliminarLibro(String idLibro) {
		try {
			restTemplate.delete(URL + "/" + idLibro);
			System.out.println("Libro eliminado con éxito!");
		} catch (HttpClientErrorException e) {
			System.out.println("Error al eliminar el libro: " + e.getStatusCode());
		}
	}
}
