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

	public void traerDNIyContraseña(String dni) {
		try {
			System.out.println("Iniciando consulta..");
			String query = "SELECT * FROM usuario WHERE DNi = ?";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, dni);
//			consultaPreparada.setString(2,contraseña);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery(query);
			while (resultadoConsulta.next()) {
				System.out.println(resultadoConsulta.getString(1) + "\t" + resultadoConsulta.getString(2) + "\t"
						+ resultadoConsulta.getString(3) + "\t" + resultadoConsulta.getString(4) + "\t"
						+ resultadoConsulta.getString(5));
			}
			System.out.println("Cerrando Consulta..");
			consultaPreparada.close();
		} catch (SQLException e) {
			System.out.println("Conexion incorrecta");
		}
	}
}
