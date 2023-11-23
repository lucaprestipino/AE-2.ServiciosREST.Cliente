package es.libreria.servidor.modelo.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import es.libreria.servidor.entidad.Cliente;

@Repository
public class DaoCliente {
    ArrayList<Cliente> listaClientes;

    public DaoCliente() {
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente("Luca", "Vazquez", "Luca86", "Admin1"));
        listaClientes.add(new Cliente("Mario", "Vargas", "Mario11", "Admin2"));
        listaClientes.add(new Cliente("Sergio", "Dalmas", "Sergio12", "Admin3"));
        listaClientes.add(new Cliente("Marcos", "Aurelio", "Marcos2", "Admin4"));
    }

    public Cliente getByUsernameAndPassword(String username, String password) {
        for (Cliente cliente : listaClientes) {
            System.out.println("Checking cliente with id: " + cliente.getUsername());
            if (cliente.getUsername().equals(username) && cliente.getPassword().equals(password)) {
                System.out.println("Found matching cliente: " + cliente.getNombre());
                return cliente;
            }
        }
        return null;
    }

}
