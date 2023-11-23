package es.libreria.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.libreria.cliente.entidad.*;
import es.libreria.servicio.ServicioProxyCliente;
import jakarta.annotation.PreDestroy;

@Component
public class Login {

    private Scanner read = new Scanner(System.in);

    @Autowired
    private ServicioProxyCliente servicioProxyCliente;

    @Autowired
    private Menu menu;

    public Cliente accesoClientes() {
        Cliente usuarioTemp;
        boolean opcionNoValida = true;

        System.out.println("Bienvenido A La Libreria");

        while (opcionNoValida) {
            System.out.println("Dame tu usuario");
            String username = read.next();

            System.out.println("Dame tu contraseña");
            String password = read.next();

            try {
                usuarioTemp = servicioProxyCliente.getClienteByPassword(username, password);
            } catch (Exception e) {
                System.out.println("Error al obtener el cliente: " + e.getMessage());
                continue;
            }

            if (usuarioTemp != null) {
                System.out.println("Bienvenido " + usuarioTemp.getNombre());
                opcionNoValida = false;
                menu.tipoDeBusqueda();
                return usuarioTemp;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        }

        return null;
    }

    @PreDestroy
    public void preDestroy() {
        if (read != null) {
            read.close();
        }
    }
}
