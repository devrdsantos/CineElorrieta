package modelo;

public class Entrada {

	private int idEntrada = 0;
	private String fecha = null;
	private String nombrePelicula = null;
	private String horario = null;
	private int idsala = 0;
	private double precio = 0;
	private String cine = null;
	private static int generadorIdEntrada = 0;
	
	public Entrada() {
		idEntrada = generadorIdEntrada;
		generadorIdEntrada++;
	}

	public Entrada(String fecha, String nombrePelicula, String horario, int idsala, double precio, String cine) {
		idEntrada = generadorIdEntrada;
		generadorIdEntrada++;
		this.fecha = fecha;
		this.nombrePelicula = nombrePelicula;
		this.horario = horario;
		this.idsala = idsala;
		this.precio = precio;
		this.cine = cine;
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

	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", fecha=" + fecha + ", nombrePelicula=" + nombrePelicula
				+ ", horario=" + horario + ", idsala=" + idsala + ", precio=" + precio + ", cine=" + cine + "]";
	}
}
