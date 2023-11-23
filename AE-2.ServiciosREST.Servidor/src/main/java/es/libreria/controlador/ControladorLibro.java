package es.libreria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.libreria.servidor.entidad.Libro;
import es.libreria.servidor.modelo.persistencia.DaoLibro; // Import the DaoLibro class

@RestController
@RequestMapping("/libros")
public class ControladorLibro {
    @Autowired
    private DaoLibro daoLibro; 

    @PostMapping(path = "/libro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> darDeAlta(@RequestBody Libro nuevoLibro) {
        System.out.println("Agregando libro con id: " + nuevoLibro.getIdLibro());
        daoLibro.agregarLibro(nuevoLibro);
        return new ResponseEntity<Libro>(nuevoLibro, HttpStatus.CREATED);
    }

    @GetMapping(path = "/libro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> getLibro(@PathVariable("id") String id) {
        System.out.println("Buscando libro con id: " + id);
        Libro libro = daoLibro.obtenerLibroPorId(id);
        if (libro != null) {
            return new ResponseEntity<Libro>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/libro/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> modificar(@PathVariable("id") String id, @RequestBody Libro libroModificado) {
        System.out.println("Modificando libro con id: " + id);
        daoLibro.modificarLibro(libroModificado);
        return new ResponseEntity<Libro>(libroModificado, HttpStatus.OK);
    }

    @DeleteMapping(path = "/libro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> darDeBaja(@PathVariable("id") String id) {
        System.out.println("Eliminando libro con id: " + id);
        Libro libro = daoLibro.obtenerLibroPorId(id);
        if (libro != null) {
            daoLibro.eliminarLibro(libro);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
