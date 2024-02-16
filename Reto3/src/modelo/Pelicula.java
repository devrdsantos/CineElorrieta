package modelo;

import java.util.Objects;

public class Pelicula {

	@Override
	public int hashCode() {
		return Objects.hash(duracion, genero, idPelicula, nombrePelicula, sinopsis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(duracion, other.duracion) && Objects.equals(genero, other.genero)
				&& idPelicula == other.idPelicula && Objects.equals(nombrePelicula, other.nombrePelicula)
				&& Objects.equals(sinopsis, other.sinopsis);
	}

	private int idPelicula = 0;
	private String nombrePelicula = null;
	private String duracion = null;
	private String genero = null;
	private String sinopsis = null;
	
	public Pelicula() {
		
	}
	
	public Pelicula(int idPelicula, String nombrePelicula, String duracion, String genero, String sinopsis) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
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
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
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
		return "IdPelicula:" + idPelicula + ", NombrePelicula:" + nombrePelicula + ", Duracion:" + duracion
				+ ", Genero:" + genero+ ", Sinopsis:" + sinopsis;
	}
	
}
