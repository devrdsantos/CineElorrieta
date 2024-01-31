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
	
	
}
