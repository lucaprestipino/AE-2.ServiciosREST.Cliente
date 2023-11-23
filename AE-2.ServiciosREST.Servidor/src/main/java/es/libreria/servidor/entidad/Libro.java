package es.libreria.servidor.entidad;

import org.springframework.stereotype.Component;

@Component
public class Libro {

	private String generoLibro;
	private String titulo;
	private String escritor;
	private int stock;
	private String idLibro;
	private double precioLibro;

	
	public Libro() {

	}

	public Libro(String generoLibro, String titulo, String escritor, int stock, String idLibro, double precioLibro) {

		this.generoLibro = generoLibro;
		this.titulo = titulo;
		this.escritor = escritor;
		this.stock = stock;
		this.idLibro = idLibro;
		this.precioLibro = precioLibro;
	}

	public String getGeneroLibro() {
		return generoLibro;
	}

	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}

	public double getPrecioLibro() {
		return precioLibro;
	}

	public void setPrecioLibro(double precioLibro) {
		this.precioLibro = precioLibro;
	}

}
