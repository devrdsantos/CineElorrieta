package modelo;

public class Funcion {
	private int idfuncion;
	private String horafuncion, fechafuncion;
	private double precio;
	private int idsala, idpelicula;

	public Funcion(int idfuncion, String horafuncion, String fechafuncion, double precio, int idsala, int idpelicula) {

		this.idfuncion = idfuncion;
		this.horafuncion = horafuncion;
		this.fechafuncion = fechafuncion;
		this.precio = precio;
		this.idsala = idsala;
		this.idpelicula = idpelicula;
	}

}
