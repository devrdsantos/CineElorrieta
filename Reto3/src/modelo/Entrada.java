package modelo;

public class Entrada {

	private int idEntrada = 0;
	private String fecha = null;
	private String nombrePelicula = null;
	private String horario = null;
	private int idsala = 0;
	private double precio = 0;
	private String cine = null;
	private int cantidad = 0;
	private int idCompra = 0;

	public Entrada() {
		
	}

	public Entrada(int idEntrada, String fecha, String nombrePelicula, String horario, int idsala, double precio, String cine,
			int cantidad, int idCompra) {
		this.idEntrada = idEntrada;
		this.fecha = fecha;
		this.nombrePelicula = nombrePelicula;
		this.horario = horario;
		this.idsala = idsala;
		this.precio = precio;
		this.cine = cine;
		this.cantidad = cantidad;
		this.idCompra = idCompra;
	}
	
	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getIdsala() {
		return idsala;
	}

	public void setIdsala(int idsala) {
		this.idsala = idsala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCine() {
		return cine;
	}

	public void setCine(String cine) {
		this.cine = cine;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	@Override
	public String toString() {
		return "----------------------------------------\nCine: " + cine
				+ "\n----------------------------------------\nPelicula: " + nombrePelicula
				+ "\n----------------------------------------\nSala: " + idsala
				+ "\n----------------------------------------\nHora: " + horario
				+ "\n----------------------------------------\nFecha: " + fecha
				+ "\n----------------------------------------\nPrecio: " + precio
				+ "\n----------------------------------------\nCantidad: " + cantidad;
	}

}
