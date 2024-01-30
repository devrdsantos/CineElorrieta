package modelo;

public class Pelicula {

	private int idPelicula;
	private String NombrePelicula;
	private int duracion;
	private String genero;
	private String sinopsis;
	
	public Pelicula() {
		
	}
	
	public Pelicula(int idPelicula, String nombrePelicula, int duracion, String genero, String sinopsis) {
		this.idPelicula = idPelicula;
		this.NombrePelicula = nombrePelicula;
		this.duracion = duracion;
		this.genero = genero;
		this.sinopsis = sinopsis;
	}



	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombrePelicula() {
		return NombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.NombrePelicula = nombrePelicula;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", NombrePelicula=" + NombrePelicula + ", duracion=" + duracion
				+ ", genero=" + genero + ", sinopsis=" + sinopsis + "]";
	}
	
}
