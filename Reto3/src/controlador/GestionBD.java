package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBD {
	private Connection conexion;

	public GestionBD() {
		iniciarconexion();
	}

	public void iniciarconexion() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuario", "root", "");

		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("No se ha encotrado la base de datos");
		}
		System.out.println("Conexion iniciada");
	}

	public void cerrarConexion() {
		System.out.println("Cerrando...");
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cerrado");
	}

	public void traerDNIyContraseña(String dni, String pass) {
	    try {
	        System.out.println("Iniciando consulta..");
	        String query = "SELECT DNI, password FROM usuario WHERE DNI = ? AND password = ?";
	        PreparedStatement consultaPreparada = conexion.prepareStatement(query);
	        consultaPreparada.setString(1, dni);
	        consultaPreparada.setNString(2, pass);

	        ResultSet resultadoConsulta = consultaPreparada.executeQuery();

	        while (resultadoConsulta.next()) {
	            System.out.println("DNI: " + resultadoConsulta.getString(1));
	            System.out.println("Contraseña: " + resultadoConsulta.getString(2));
	        }

	        System.out.println("Cerrando Consulta..");
	        consultaPreparada.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Conexion incorrecta");
	    }
	}
	
	
	
	
}
