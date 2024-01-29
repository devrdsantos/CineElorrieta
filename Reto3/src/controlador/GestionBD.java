package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import vista.VentanaPrincipal;

public class GestionBD {
	private Connection conexion;
	//private VentanaPrincipal ventana = new VentanaPrincipal();
//	private GestionDeLaInformacion gestionINF;

	public GestionBD() {
		iniciarconexion();
//		gestionINF = new GestionDeLaInformacion();
	}

	public void iniciarconexion() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");

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
		System.out.println("Conexión cerrada");
	}

	public void verificarLogin(String dni, String pass, VentanaPrincipal v) {
	    try {
	        System.out.println("Iniciando consulta...");
	        String query = "SELECT DNI, password FROM usuario WHERE DNI = ? AND password = ?";
	        PreparedStatement consultaPreparada = conexion.prepareStatement(query);
	        consultaPreparada.setString(1, dni);
	        consultaPreparada.setNString(2, pass);

	        ResultSet resultadoConsulta = consultaPreparada.executeQuery(); 
	        
	        if (resultadoConsulta.next() && dni.equals(resultadoConsulta.getString(1)) && pass.equals(resultadoConsulta.getString(2))) {
	         	JOptionPane.showMessageDialog(null,"\nSe ha iniciado sesión");
		        	v.cambiarDePanel(3);
		        } else {
		        	JOptionPane.showMessageDialog(null, "Los valores ingresados no son correctos");
		        }
	        
//	        while (resultadoConsulta.next()) {
//	            System.out.println("DNI: " + resultadoConsulta.getString(1));
//	            System.out.println("Contraseña: " + resultadoConsulta.getString(2));
//	            
//	            
//	        }
	        
	        System.out.println("Cerrando consulta...");
	        consultaPreparada.close();
	    } catch (SQLException e) {
	        System.out.println("Conexion incorrecta con la base de datos");
	       
	    }
	}

	public void insertUsuario(ArrayList<String> datosUsuario, VentanaPrincipal v) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO usuario VALUES ('"+datosUsuario.get(0)+"','"+datosUsuario.get(1)+"','"+datosUsuario.get(2)+"','"+datosUsuario.get(3)+"', '"+datosUsuario.get(4)+"')";
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			v.cambiarDePanel(1);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			v.cambiarDePanel(2);
		}
	}
	
//	public void sacarCines() {
//		try {
//	        System.out.println("Iniciando consulta..");
//	        String query = "SELECT NombreCine FROM 'cines'";
//	        PreparedStatement consultaPreparada = conexion.prepareStatement(query);
//
//	        ResultSet resultadoConsulta = consultaPreparada.executeQuery(); 
//	       
//	        gestionINF.añadirCinesAlArray(resultadoConsulta);
//	        
//	        System.out.println("Cerrando Consulta..");
//	        consultaPreparada.close();
//	    } catch (SQLException e) {
//	        System.out.println("Conexion incorrecta");
//	     
//	    }
//		  
//	}
	
}
