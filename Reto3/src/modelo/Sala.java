package modelo;

public class Sala {
	private int idSala = 0;
	private String nombreSala = null;
	private int idCine = 0;
	
	public Sala() {
		
	}
	
	public Sala(int idSala, String nombreSala, int idCine) {
		
		this.idSala = idSala;
		this.nombreSala = nombreSala;
		this.idCine = idCine;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nombreSala=" + nombreSala + ", idCine=" + idCine + "]";
	}
	
	
}
