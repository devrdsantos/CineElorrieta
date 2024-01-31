package modelo;

public class Pelicula {

	private int idPelicula;
	private String NombrePelicula;
	private String duracion;
	private String genero;
	private String sinopsis;
	
	public Pelicula() {
		
	}
	
	public Pelicula(int idPelicula, String nombrePelicula, String duracion, String genero, String sinopsis) {
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
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
		return "IdPelicula:" + idPelicula + ", NombrePelicula:" + NombrePelicula + ", Duracion:" + duracion
				+ ", Genero:" + genero+ ", Sinopsis:" + sinopsis;
	}
	
}
