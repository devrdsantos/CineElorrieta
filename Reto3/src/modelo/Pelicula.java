package modelo;

public class Pelicula {

	private String nombrePelicula, genero;
	private int duracionPelicula, idPelicula, precioPelicula;
	
	public Pelicula(String nombrePelicula, String genero, int duracionPelicula, int idPelicula, int precioPelicula) {
		
		this.nombrePelicula = nombrePelicula;
		this.genero = genero;
		this.duracionPelicula = duracionPelicula;
		this.idPelicula = idPelicula;
		this.precioPelicula = precioPelicula;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracionPelicula() {
		return duracionPelicula;
	}

	public void setDuracionPelicula(int duracionPelicula) {
		this.duracionPelicula = duracionPelicula;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public int getPrecioPelicula() {
		return precioPelicula;
	}

	public void setPrecioPelicula(int precioPelicula) {
		this.precioPelicula = precioPelicula;
	}

	@Override
	public String toString() {
		return "Pelicula [nombrePelicula=" + nombrePelicula + ", genero=" + genero + ", duracionPelicula="
				+ duracionPelicula + ", idPelicula=" + idPelicula + ", precioPelicula=" + precioPelicula + "]";
	}
	
	
	
}
