package modelo;

public class Compra {

	private int idCompra = 0;
	private String dni = null;
	private String descuento = null;
	private String fechaCompra = null;
	private String horaCompra = null;

	public Compra() {
		
	}
	
	public Compra(int idCompra, String dni, String descuento, String fechaCompra, String horaCompra) {

		this.idCompra = idCompra;
		this.dni = dni;
		this.descuento = descuento;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
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

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", dni=" + dni + ", descuento=" + descuento + ", fechaCompra="
				+ fechaCompra + ", horaCompra=" + horaCompra + "]";
	}

}
