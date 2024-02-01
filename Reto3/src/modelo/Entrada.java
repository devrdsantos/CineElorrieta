package modelo;

public class Entrada {

	private int numeroEntrada;
	private double descuento;
	private String fechaCompra, horaCompra;
	private int idfuncion, idcompra;
	
	public Entrada(int numeroEntrada, double descuento, String fechaCompra, String horaCompra, int idfuncion,
			int idcompra) {
		
		this.numeroEntrada = numeroEntrada;
		this.descuento = descuento;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.idfuncion = idfuncion;
		this.idcompra = idcompra;
	}

	public int getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getHoraCompra() {
		return horaCompra;
	}

	public void setHoraCompra(String horaCompra) {
		this.horaCompra = horaCompra;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public int getIdcompra() {
		return idcompra;
	}

	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}

	@Override
	public String toString() {
		return "Entrada [numeroEntrada=" + numeroEntrada + ", descuento=" + descuento + ", fechaCompra=" + fechaCompra
				+ ", horaCompra=" + horaCompra + ", idfuncion=" + idfuncion + ", idcompra=" + idcompra + "]";
	}
	
	
}
