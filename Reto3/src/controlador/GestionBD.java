package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.Cine;
import modelo.Compra;
import modelo.Entrada;
import modelo.Funcion;
import modelo.Pelicula;
import vista.VentanaPrincipal;

public class GestionBD {
	/**
	 * Declaración de objetos CONEXION Y GESTIONINF
	 */
	private Connection conexion;
	private GestionDeLaInformacion gestionINF;
	// private VentanaPrincipal ventana = new VentanaPrincipal();

	/**
	 * Constructor vacío Ejecuta el método iniciarConexion()
	 */
	public GestionBD() {
		iniciarconexion();

	}

	/*********************
	 ***** Métodos *******
	 ********************/
	/*
	 * [MÉTODO] iniciarConexion() - - - - - - - - - - - - - - Se utiliza para
	 * conectarse a la BD. Este método se utiliza cada vez que cambiamos de panel ya
	 * que lo incluimos en el constructor vacío de GestionBD
	 * 
	 * Si la conexion es correcta se mostrara en consola "Conexion iniciada" Si es
	 * incorrecta hay dos opciones: 1. Que no se haya encontrado la libreria o 2.
	 * Que no se haya encontrado la base de datos Ambos tienen mensajes de aviso
	 * para cada caso
	 */
	public void iniciarconexion() {
		// System.out.println("Conectando...");
		try {
			// Librería JDBC
			Class.forName("com.mysql.jdbc.Driver");
			// Se inicializa el objeto CONEXION que conecta y hace referencia a dónde está
			// ubicada la BD a través del usuario ROOT
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto3", "root", "");
		} catch (ClassNotFoundException e) {
			// System.out.println("No se ha encontrado la Libreria.");
		} catch (SQLException e) {
			// System.out.println("No se ha encontrado la BD.");
		}
		// System.out.println("Conexion iniciada");
	}

	/*
	 * [MÉTODO] cerrarConexion() - - - - - - - - - - - - - - Se utiliza para cerrar
	 * la conexion con la BD Muestra un mensaje "Conexion cerrada"
	 */
	public void cerrarConexion() {
		// System.out.println("Cerrando...");
		try {
			// Si la conexión NO está cerrada, la cierra.
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Conexión cerrada.");
	}

	/*
	 * [MÉTODO] verificarLogin() - - - - - - - - - - - - - - Éste método hace una
	 * consulta a la BD y recibe tres parámetros: - String dni, - String pass - Y el
	 * objeto VentanaPrincipal
	 * 
	 * param dni tomará el valor del dni que traiga de la bdd param pass tomará el
	 * valor del password que traiga de la bdd param ventanaPrincipal es necesario
	 * para poder utilizar el metodo cambiarDePanel
	 * 
	 */
	public void verificarLogin(String dni, String pass, VentanaPrincipal v) throws Exception {
		// Se inicializa el objeto gestionINF

		try {
			// System.out.println("Iniciando consulta...");
			// QUERY para verificar el LOGIN, el ? representa el DNI que deberá pasarse por
			// parámetros
			String query = "SELECT DNI, password FROM usuario WHERE DNI = ?";

			// Prepara la consulta para mandarla a la BD, en este caso está verificando el
			// DNI
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, dni);

			// Variable que ejecuta la QUERY
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			// Variable que ejecuta sacarPasswordEncriptada pasándole como parámetro el DNI
			// ingresado
			String passDesencriptada = sacarPasswordEncriptada(dni);

			// Si el DNI y la contraseña desencriptada se corresponden con los datos de la
			// BD se iniciará sesión y se cambiará al siguiente panel (PanelSeleccionCine)
			if (resultadoConsulta.next() && dni.equals(resultadoConsulta.getString(1))
					&& pass.equals(passDesencriptada)) {
				JOptionPane.showMessageDialog(null, "\nSe ha iniciado sesión");
				v.cambiarDePanel(3);
			} else {
				JOptionPane.showMessageDialog(null, "Los valores ingresados no son correctos");
			}
			// Una vez que ejecuta la consulta la cierra.
			// System.out.println("Cerrando consulta...");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la base de datos");
		}
	}

	/*
	 * [MÉTODO] insertUsuario() - - - - - - - - - - Éste método permite ingresar un
	 * nuevo usuario a la base de datos.
	 * 
	 * param datosUsuario: es un ArrayList de tipo String donde se guardan los datos
	 * ingresados en el formulario para luego ingresarlos en orden a BD
	 */
	public void insertUsuario(ArrayList<String> datosUsuario, VentanaPrincipal v) {
		gestionINF = new GestionDeLaInformacion();
		try {
			Statement consulta = conexion.createStatement();
			// Toma la contraseña y la encripta a través del método
			String passEncriptada = gestionINF.encriptar(datosUsuario.get(1));

			// QUERY que inserta datos a la tabla
			// 0 -> DNI
			// 2 -> Nombre
			// 3 -> Apellido
			// 4 -> Sexo
			String insert = "INSERT INTO usuario VALUES ('" + datosUsuario.get(0) + "','" + passEncriptada + "','"
					+ datosUsuario.get(2) + "','" + datosUsuario.get(3) + "', '" + datosUsuario.get(4) + "')";

			// Ejecución del INSERT
			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			// Cambia al Panel para iniciar sesión
			v.cambiarDePanel(1);
			// Cierra la consulta
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			v.cambiarDePanel(2);
		}
	}

	// [MÉTODO] sacarCines() trabaja con un ArrayList de objetos de tipo Cine - - -
	// - - - - - - - - - - - - - -
	public ArrayList<Cine> sacarCines() {
		// Crea el ArrayList
		ArrayList<Cine> cines = new ArrayList<Cine>();
		try {
			// System.out.println("Iniciando consulta..");
			// QUERY que selecciona todo de la tabla CINE
			String query = "SELECT * FROM cine";
			// Prepara la consulta para mandarla a la BD
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			// Ejecuta la consulta
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			// Agrega los cines de la BD al ArrayList cines donde
			// 1 -> IDCine
			// 2 -> nombreCine
			// 3 -> Localidad
			// 4 -> Dirección
			while (resultadoConsulta.next()) {
				cines.add(new Cine(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4)));
			}
			// System.out.println("Cerrando Consulta cine..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la tabla Cine");
			e.printStackTrace();
		}
		// Devuelve los cines
		return cines;
	}

	public String sacarPasswordEncriptada(String dni) throws Exception {
		gestionINF = new GestionDeLaInformacion();
		String passDesencriptada = "";
		try {
			// System.out.println("Iniciando consulta sacarPasswordEncriptada...");
			String query = "SELECT password FROM usuario WHERE DNI = ?";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, dni);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();
			if (resultadoConsulta.next()) {
				passDesencriptada = gestionINF.desencriptar(resultadoConsulta.getString(1));
			}
//			System.out.println("Cerrando consulta...");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta con la Base de Datos");
		}
		return passDesencriptada;
	}

	public ArrayList<Funcion> sacarInformacionDeUnaPeliculaDelCineSeleccionado(int idPelicula, String nombreCine) {
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		try {
			// System.out.println("Iniciando consulta..");
			String query = "SELECT F.idfuncion, F.hora, f.fecha, f.precio, f.idsala, f.idpelicula FROM `funcion` F JOIN sala S ON F.idsala = S.idsala JOIN cine C on S.idcine = C.idcine WHERE idpelicula = ? and C.nombrecine = ? ";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setInt(1, idPelicula);
			consultaPreparada.setString(2, nombreCine);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				funciones.add(new Funcion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getDouble(4), resultadoConsulta.getInt(5),
						resultadoConsulta.getInt(6)));
			}
			// System.out.println("Cerrando Consulta funcion..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta funcion");
			e.printStackTrace();
		}
		return funciones;
	}

	public ArrayList<Pelicula> sacarPeliculasDependiendoDelCineSeleccionado(String cineSeleccionado) {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			// System.out.println("Iniciando consulta..");
			String query = "SELECT DISTINCT P.idpelicula, P.nombrepelicula, P.duracion, P.genero, P.sinopsis FROM `cine` C join sala S on C.idcine = S.idcine join funcion F on S.idsala = F.idsala join pelicula P on F.idpelicula = P.idpelicula WHERE C.nombrecine = ? ORDER BY P.idpelicula";
			PreparedStatement consultaPreparada = conexion.prepareStatement(query);
			consultaPreparada.setString(1, cineSeleccionado);
			ResultSet resultadoConsulta = consultaPreparada.executeQuery();
			while (resultadoConsulta.next()) {
				peliculas.add(new Pelicula(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4),
						resultadoConsulta.getString(5)));
			}
			// System.out.println("Cerrando Consulta cine..");
			consultaPreparada.close();
		} catch (SQLException e) {
			// System.out.println("Conexion incorrecta cine");
			e.printStackTrace();
		}
		// System.out.println(peliculas.get(0));
		return peliculas;
	}

	public void insertarEntrada(ArrayList<Entrada> entradas) {
		try {
			Statement consulta = conexion.createStatement();
			for (int i = 0; i < entradas.size(); i++) {
				String insert = "INSERT INTO entrada (`fecha`, `nombrepelicula`, `horario`, `idsala`, `precio`, `cine`, `cantidad`, `idcompra`) VALUES ('"
						+ entradas.get(i).getFecha() + "','" + entradas.get(i).getNombrePelicula() + "','"
						+ entradas.get(i).getHorario() + "', '" + entradas.get(i).getIdsala() + "','"
						+ entradas.get(i).getPrecio() + "','" + entradas.get(i).getCine() + "','"
						+ entradas.get(i).getCantidad() + "','" + entradas.get(i).getIdCompra() + "')";
				consulta.executeUpdate(insert);
			}

			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

	public ArrayList<Entrada> sacarIdEntrada() {
		ArrayList<Entrada> idEntrada = new ArrayList<Entrada>();
		try {

			String query = "SELECT * FROM entrada ORDER BY identrada DESC";

			PreparedStatement consultaPreparada = conexion.prepareStatement(query);

			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				idEntrada.add(new Entrada(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getInt(5),
						resultadoConsulta.getDouble(6), resultadoConsulta.getString(7), resultadoConsulta.getInt(8),
						resultadoConsulta.getInt(9)));
			}
			consultaPreparada.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idEntrada;
	}

	public ArrayList<Compra> sacarIdCompra() {
		ArrayList<Compra> idCompra = new ArrayList<Compra>();
		try {

			String query = "SELECT * FROM compra ORDER BY idcompra DESC";

			PreparedStatement consultaPreparada = conexion.prepareStatement(query);

			ResultSet resultadoConsulta = consultaPreparada.executeQuery();

			while (resultadoConsulta.next()) {
				idCompra.add(new Compra(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5)));
			}
			consultaPreparada.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idCompra;
	}

	public void insertarCompra(ArrayList<Compra> compras) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO compra VALUES ('" + compras.get(0).getIdCompra() + "','"
					+ compras.get(0).getDni() + "','" + compras.get(0).getDescuento() + "','" + compras.get(0).getFechaCompra() + "','" + compras.get(0).getHoraCompra() + "')";
			consulta.executeUpdate(insert);

			consulta.close();

		} catch (Exception e) {
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, "Campos inválidos");
		}
	}

}
