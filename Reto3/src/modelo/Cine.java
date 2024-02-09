package modelo;

public class Cine {

	private int idCine;
	private String nombreCine;
	private String localidadCine;
	private String direccionCine;
		
	public Cine() {
		
	}
	
	public Cine(int idCine, String nombreCine, String localidadCine, String direccionCine) {
		this.idCine = idCine;
		this.nombreCine = nombreCine;
		this.localidadCine = localidadCine;
		this.direccionCine = direccionCine;
	}

	public int getIdCine() {
		return idCine;
	}

	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public String getLocalidadCine() {
		return localidadCine;
	}

	public void setLocalidadCine(String localidadCine) {
		this.localidadCine = localidadCine;
	}

	public String getDireccionCine() {
		return direccionCine;
	}

	public void setDireccionCine(String direccionCine) {
		this.direccionCine = direccionCine;
	}

	@Override
	public String toString() {
		return "IdCine:" + idCine + ", \nNombreCine:" + nombreCine + ", \nLocalidadCine:" + localidadCine
				+ ", \nDireccionCine:" + direccionCine;
	}
	
	
	
}
