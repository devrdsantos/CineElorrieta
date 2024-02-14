package modelo;

public class Entrada {

	private int idEntrada = 0;
	private int idfuncion = 0;
	private int idcompra = 0;
	
	public Entrada(int idEntrada, int idfuncion, int idcompra) {
		this.idEntrada = idEntrada;
		this.idfuncion = idfuncion;
		this.idcompra = idcompra;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
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
		return "Entrada [idEntrada=" + idEntrada + ", idfuncion=" + idfuncion + ", idcompra=" + idcompra + "]";
	}
	
}
