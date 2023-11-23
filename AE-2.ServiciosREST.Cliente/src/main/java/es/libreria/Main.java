package es.libreria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.libreria.menu.Login;

@Component
public class Main {

    @Autowired
    private Login login;
    private Mensaje mensaje;


    public void run() {
    	mensaje.escribirMensaje();
        login.accesoClientes();
        
    }
}
