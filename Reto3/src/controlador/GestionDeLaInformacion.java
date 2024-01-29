package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.Cine;
import vista.VentanaPrincipal;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private ArrayList<String> DatosUsuario;
	

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		DatosUsuario = new ArrayList<String>();
		
	}

	//NO ES NECESARIO ESTE METODO
	public void verificarLogin(String dni, String pass, String dniBD, String passBD, VentanaPrincipal v) {
//		 if (resultadoConsulta.next() && dni.equals(resultadoConsulta.getString(1)) && pass.equals(resultadoConsulta.getString(2))) {
//         	JOptionPane.showMessageDialog(null,"\nInicio correcto!!");
//	        	v.cambiarDePanel(3);
//	        } else {
//	        	JOptionPane.showMessageDialog(null, "Sentencias incorrectas!!");
//	        }
	}

	public void recojerInformacionFormulario(String dniFormulario, String passFormulario, String nombreFormulario,
			String apellidoFormulario, String sexoFormulario, VentanaPrincipal v) {

		String textoDNI = dniFormulario;
		Pattern patron = Pattern.compile("^[0-9]{8}[A-Z]$", Pattern.CASE_INSENSITIVE);
		Matcher dni = patron.matcher(textoDNI);

		if (!dni.find()) {
			JOptionPane.showMessageDialog(null, "DNI no valido");
		} else {
			DatosUsuario.add(dni.group());
		}

		String textoPass = passFormulario;
		Pattern patron1 = Pattern.compile("^[\\S]{6,14}+$", Pattern.CASE_INSENSITIVE);
		Matcher pass = patron1.matcher(textoPass);

		if (!pass.find()) {
			JOptionPane.showMessageDialog(null, "Contraseña no valido");
		} else {
			DatosUsuario.add(pass.group());
		}

		String textoNombre = nombreFormulario;
		Pattern patron2 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher nombre = patron2.matcher(textoNombre);

		if (!nombre.find()) {
			JOptionPane.showMessageDialog(null, "Nombre no valido");
		} else {
			DatosUsuario.add(nombre.group());
		}

		String textoApellido = apellidoFormulario;
		Pattern patron3 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher apellido = patron3.matcher(textoApellido);
		
		if (!apellido.find()) {
			JOptionPane.showMessageDialog(null, "Apellido no valido");
		} else {
			DatosUsuario.add(apellido.group());
		}
		
		DatosUsuario.add(sexoFormulario);

		gestionBD.insertUsuario(DatosUsuario, v);
	}
	
	public ArrayList<String> almacenarCines() {		
		ArrayList<String> cines = gestionBD.sacarCines();
		return cines;
	}
//		try {
//			cines.add(resultado.getString(1));
//			System.out.println(cines.get(0));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
