package modelo;

public class Usuario {
	
	

	private String dni, password, nombre, apellido;
	private enum sexo {Masculino, Femenino}
	
	public Usuario() {
		
	};
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
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	};
	
	
}
