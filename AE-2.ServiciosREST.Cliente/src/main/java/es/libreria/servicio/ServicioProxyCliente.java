package es.libreria.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.libreria.cliente.entidad.*;

@Service
public class ServicioProxyCliente {

	public static final String URL = "http://localhost:8081/Home"; // Removed trailing slash

	@Autowired
	private RestTemplate restTemplate;

	public Cliente getClienteByPassword(String username, String password) {
	    try {
	        ResponseEntity<Cliente> cliente = restTemplate.getForEntity(URL + "/" + username + "/" + password, Cliente.class);
	        HttpStatusCode http = cliente.getStatusCode();
	        if (http == HttpStatus.OK) {
	            return cliente.getBody();
	        } else {
	            System.out.println("Usuario y/o  Contraseña incorrectos!");
	            return null;
	        }
	    } catch (HttpClientErrorException e) {
	        System.out.println("Obtener -> Usuario No encontrado " + username + " " + password);
	        System.out.println("Obtener -> " + e.getStatusCode());
	        return null;
	    }
	}

}
