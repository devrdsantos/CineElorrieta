package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Pelicula;
import vista.VentanaPrincipal;

public class GestionBD {
	private Connection conexion;
	// private VentanaPrincipal ventana = new VentanaPrincipal();
//	private GestionDeLaInformacion gestionINF;

	public GestionBD() {
		iniciarconexion();

	}

	/*
	 * metodo iniciar conexion Se utiliza para conectarse a la base de datos este
	 * metodo se utiliza cada vez que cambiamos de panel ya que lo incluimos en el
	 * constructor vacio de GestionBD
	 * 
	 * Si la conexion es correcta se mostrara en consola "Conexion iniciada" Si la
	 * conexion es incorrecta hay dos opciones: 1. Que no se haya encontrado la
	 * libreria 2. Que no se haya encontrado la base de datos Ambos tienen mensajes
	 * de aviso para cada caso
	 */
	public void iniciarconexion() {
		// System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");


			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3", "root", "");


		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("No se ha encotrado la base de datos");
		}
		// System.out.println("Conexion iniciada");
	}

	/*
	 * metodo cerrarConexion se utiliza para cerrar la conexion con la base de datos
	 * muestra un mensaje "Conexion cerrada"
	 */
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

	/*
	 * metodo verificarLogin param dni = este parametro tomara el valor del dni que
	 * traiga de la bdd param pass = este parametro tomara el valor del password que
	 * traiga de la bdd param ventanaPrincipal = le pasamos como parametro la
	 * ventanaPrincipal para poder utilizar el metodo cambiarDePanel Este metodo
	 * hace una consulta a la base de datos
	 * 
	 * consulta: SELECT DNI, password FROM usuario WHERE DNI = ? AND password = ?
	 * 
	 * donde el primer ? sera el dni que el usuario coloque en el Textbox del login
	 * y el segundo ? sera la password que el usuario coloque en el Textbox del
	 * login
	 * 
	 * Si el resultado de la consulta es igual a lo que ingreso en el login el
	 * usuario aparecera un mensaje diciendo "Se ha iniciado sesion" y te cambiara
	 * al panel de seleccion de cine Si el resultado de la consulta es distinto a lo
	 * que ingresa el usuario en el login se le mostrara un mensaje
	 * "Los valores ingresados no son correctos" y se reiniciaran los campos.
	 * 
	 */
	public void verificarLogin(String dni, String pass, VentanaPrincipal v) {
		try {
			System.out.println("Iniciando consulta...");
			String query = "SELECT DNI, password FROM usuario WHERE DNI = ? AND password = ?";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, dni);
			consultaPreparada.setNString(2, pass);

			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			if (resultadoConsulta.next() && dni.equals(resultadoConsulta.getString(1))
					&& pass.equals(resultadoConsulta.getString(2))) {
				JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión");
				v.cambiarDePanel(3);
			} else {
				JOptionPane.showMessageDialog(null, "Los valores ingresados no son correctos");
			}

			System.out.println("Cerrando consulta...");
			consultaPreparada.close();
		} catch (SQLException e) {
			System.out.println("Conexion incorrecta con la base de datos");

		}
	}

	/*
	 * metodo insertUsuario este metodo permite ingresar un nuevo usuario a la base
	 * de datos.
	 * 
	 * param datosUsuario: es un ArrayList de tipo String con el que guardamos los
	 * datos ingresados en el formulario para luego ingresarlos en orden a la base
	 * de datos
	 * 
	 * hacemos un insert: INSERT INTO usuario VALUES
	 * ('" + datosUsuario.get(0) + "','" + datosUsuario.get(1) + "','" +
	 * datosUsuario.get(2) + "','" + datosUsuario.get(3) + "', '" +
	 * datosUsuario.get(4) + "')
	 * 
	 * para ingresar los datos a la base de datos, si todo ha funcionado
	 * correctamente se nos mostrara un mensaje "Usuario creado correctamente" y nos
	 * cambiara al panel de login En caso de que algun campo no se haya rellenado
	 * correctamente nos mostrara un mensaje "Campos Invalidos"
	 */
	public void insertUsuario(ArrayList<String> datosUsuario, VentanaPrincipal v) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO usuario VALUES ('" + datosUsuario.get(0) + "','" + datosUsuario.get(1) + "','"
					+ datosUsuario.get(2) + "','" + datosUsuario.get(3) + "', '" + datosUsuario.get(4) + "')";

			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			v.cambiarDePanel(1);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			v.cambiarDePanel(2);
		}
	}


	public ArrayList<String> sacarCines() {
		ArrayList<String> cines = new ArrayList<String>();
		;
		try {
			// System.out.println("Iniciando consulta..");
			String query = "SELECT NombreCine FROM cine";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);

			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				cines.add(resultadoConsulta.getString(1));
			}
			// System.out.println("Cerrando Consulta cine..");
			consultaPreparada.close();
		} catch (SQLException e) {
			System.out.println("Conexion incorrecta cine");
			e.printStackTrace();
		}
		return cines;
	}

	public ArrayList<Pelicula> sacarInformacionPeliculas() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		;
		try {
			// System.out.println("Iniciando consulta..");
			String query = "SELECT * FROM `pelicula`";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);

			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				peliculas.add(new Pelicula(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
			}
			// System.out.println("Cerrando Consulta cine..");
			consultaPreparada.close();
		} catch (SQLException e) {
			System.out.println("Conexion incorrecta cine");
			e.printStackTrace();
		}
		//System.out.println(peliculas.get(0));
		return peliculas;
	}

}
