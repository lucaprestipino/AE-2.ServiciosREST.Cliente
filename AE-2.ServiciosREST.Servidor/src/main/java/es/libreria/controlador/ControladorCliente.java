package es.libreria.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.libreria.servidor.entidad.Cliente;
import es.libreria.servidor.modelo.persistencia.DaoCliente;
import jakarta.annotation.PostConstruct;

@RestController
public class ControladorCliente {

    @Autowired
    private DaoCliente daoCliente;
    
    
    @Autowired
    private ApplicationContext appContext;

    
    @GetMapping(path = "/Home/{username}/{password}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getCliente(@PathVariable("username") String username, @PathVariable("password") String password){
        System.out.println("Buscando Usuario con id: "+username);
        Cliente cliente = daoCliente.getByUsernameAndPassword(username, password);
        if(cliente != null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

}
