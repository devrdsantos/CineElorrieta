package modelo;

public class Usuario {
	
	private String dni = null;
	private String password = null;
	private String nombre = null;
	private String apellido = null;
	private String sexo = null; 
	
	public Usuario() {
		
	}
	
	public Usuario(String dni, String password, String nombre, String apellido) {
		
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", sexo=" + sexo + "]";
	}
	
}
