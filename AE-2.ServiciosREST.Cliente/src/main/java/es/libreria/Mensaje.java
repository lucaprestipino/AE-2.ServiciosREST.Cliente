package es.libreria;

import es.libreria.servicio.ServicioProxyMensaje;

public class Mensaje {
	

	
	public void escribirMensaje() {
		
		ServicioProxyMensaje spm = new ServicioProxyMensaje();
		
		System.out.println("**** Arrancando el Servicio Spring Rest Cliente ****");
		System.out.println("*****Mensaje*****");
		String mensaje = spm.obtener("mensaje");
		System.out.println("Run-> Mensaje"+mensaje);
		
		
		System.out.println("**** Mensaje HTML ****");
		String mensajeHtml = spm.obtener("mensaje HTML");
		System.out.println("Run-> Mensaje"+mensajeHtml);
	}
	
	
}
