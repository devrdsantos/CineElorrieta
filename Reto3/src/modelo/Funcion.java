package modelo;

public class Funcion {
	private int idfuncion;
	private String horafuncion, fechafuncion;
	private double precio;
	private int idsala, idpelicula;
	
public Funcion() {
		
	};

	public Funcion(int idfuncion, String horafuncion, String fechafuncion, double precio, int idsala, int idpelicula) {

		this.idfuncion = idfuncion;
		this.horafuncion = horafuncion;
		this.fechafuncion = fechafuncion;
		this.precio = precio;
		this.idsala = idsala;
		this.idpelicula = idpelicula;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public String getHorafuncion() {
		return horafuncion;
	}

	public void setHorafuncion(String horafuncion) {
		this.horafuncion = horafuncion;
	}

	public String getFechafuncion() {
		return fechafuncion;
	}

	public void setFechafuncion(String fechafuncion) {
		this.fechafuncion = fechafuncion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdsala() {
		return idsala;
	}

	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	@Override
	public String toString() {
		return "Funcion [idfuncion=" + idfuncion + ", horafuncion=" + horafuncion + ", fechafuncion=" + fechafuncion
				+ ", precio=" + precio + ", idsala=" + idsala + ", idpelicula=" + idpelicula + "]";
	}

}
