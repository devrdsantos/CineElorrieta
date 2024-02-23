package controlador;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import modelo.Cine;
import modelo.Compra;
import modelo.Entrada;
import modelo.Funcion;
import modelo.Pelicula;
import modelo.Sala;
import vista.VentanaPrincipal;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private ArrayList<String> datosUsuario;
	private Cine cine;
	private Pelicula pelicula;
	private Entrada entrada;
	private Funcion funcion;
	private Sala sala;
	private ArrayList<Entrada> entradas;
	private ArrayList<Compra> compras;
	private GestionDeFicheros ficheros;
	private Compra compra;
	private final String CLAVE_ENCRIPTADA = "clavecompartidanorevelarnuncamas";

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		datosUsuario = new ArrayList<String>();
		pelicula = new Pelicula();
		cine = new Cine();
		funcion = new Funcion();
		sala = new Sala();
		entrada = new Entrada();
		entradas = new ArrayList<Entrada>();
		ficheros = new GestionDeFicheros();
		compra = new Compra();
		compras = new ArrayList<Compra>();
	}

	/**
	 * metodo recojerInformacionFormulario param dniFormulario param passFormulario
	 * param apellidoFormulario param sexoFormulario param VentanaPrincipal
	 * 
	 * Le pasamos como parametro los datos que obtenemos en el panel de Formulario y
	 * le pasamos la VentanaPrincipal para utilizar el metodo cambiarDePanel
	 * 
	 * Este metodo comprueba que la informacion ingresada en el formulario sea
	 * correcta y cumpla con los patrones correspondientes de cada campo
	 * 
	 * Para el caso del dni: 8 numeros y 1 letra | Caso negativo "DNI no valido"
	 * Para el caso de la password: mas de 6 caracteres menos de 14 º Caso negativo
	 * "Contraseña no valida" Para el caso del nombre: solo letras | Caso negativo
	 * "Nombre no valido" Para el caso del apellido: solo letras | Caso negativo
	 * "Apellido no valido"
	 */

	public void validarInformacionFormulario(String dniFormulario, String passFormulario, String nombreFormulario,
			String apellidoFormulario, String sexoFormulario, VentanaPrincipal v) {

		String textoDNI = dniFormulario;
		Pattern patron = Pattern.compile("^[0-9]{8}[A-Z]$", Pattern.CASE_INSENSITIVE);
		Matcher dni = patron.matcher(textoDNI);

		if (!dni.find()) {
			JOptionPane.showMessageDialog(null, "DNI no valido");
		} else {
			datosUsuario.add(dni.group());
		}

		String textoPass = passFormulario;
		Pattern patron1 = Pattern.compile("^[\\S]{6,14}+$", Pattern.CASE_INSENSITIVE);
		Matcher pass = patron1.matcher(textoPass);

		if (!pass.find()) {
			JOptionPane.showMessageDialog(null, "Contraseña no valida");
		} else {
			datosUsuario.add(pass.group());
		}

		String textoNombre = nombreFormulario;
		Pattern patron2 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher nombre = patron2.matcher(textoNombre);

		if (!nombre.find()) {
			JOptionPane.showMessageDialog(null, "Nombre no valido");
		} else {
			datosUsuario.add(nombre.group());
		}

		String textoApellido = apellidoFormulario;
		Pattern patron3 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher apellido = patron3.matcher(textoApellido);

		if (!apellido.find()) {
			JOptionPane.showMessageDialog(null, "Apellido no valido");
		} else {
			datosUsuario.add(apellido.group());
		}

		datosUsuario.add(sexoFormulario);

		gestionBD.insertUsuario(datosUsuario, v);
	}

	/**
	 * almacena los cines en un arraylist de tipo Cine, utilizando el metodo
	 * sacarCines de GestionBD
	 * 
	 * @return cines
	 */
	public ArrayList<Cine> almacenarCines() {
		ArrayList<Cine> cines = gestionBD.sacarCines();
		return cines;
	}

	/**
	 * metodo que funciona para encriptar la contraseña
	 * 
	 * @param mensaje
	 * @return devuelve la contraseña encriptada en formato string
	 * @throws Exception
	 */
	public String encriptar(String mensaje) throws Exception {
		Key claveAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, claveAES);

		byte[] mensajeEncriptado = cipher.doFinal(mensaje.getBytes());

		return Base64.getEncoder().encodeToString(mensajeEncriptado);
	}

	/**
	 * metodo que funciona para desencriptar la contraseña
	 * 
	 * @param mensajeEncriptado
	 * @return devuelve la contraseña desencriptada
	 * @throws Exception
	 */
	public String desencriptar(String mensajeEncriptado) throws Exception {

		byte[] mensajeBytes = Base64.getDecoder().decode(mensajeEncriptado);

		Key ClaveaAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.DECRYPT_MODE, ClaveaAES);

		String desencriptado = new String(cipher.doFinal(mensajeBytes));

		return desencriptado;
	}

	/**
	 * Metodo que sirve para colocarle el nombre al cine
	 * 
	 * @param cineSeleccionado
	 */
	public void recogerCineSeleccionado(String cineSeleccionado) {

		cine.setNombreCine(cineSeleccionado);
	}

	/**
	 * Metodo que sirve para pasar el nombre del cine
	 * 
	 * @return
	 */

	public String pasarNombreCine() {
		String nombreCine = cine.getNombreCine();
		return nombreCine;
	}

	/**
	 * metodo que sirve para colocarle el nombre a la pelicula
	 * 
	 * @param peliculaSeleccionada
	 */
	public void recogerPeliculaSeleccionada(String peliculaSeleccionada) {

		pelicula.setNombrePelicula(peliculaSeleccionada);
	}

	/**
	 * Metodo que sirve para pasar el nombre de la pelicula
	 * 
	 * @return
	 */
	public String pasarNombrePelicula() {
		String nombrePelicula = pelicula.getNombrePelicula();
		return nombrePelicula;
	}

	/**
	 * metodo que sirve para colocarle la id a la pelicula
	 * 
	 * @param idPelicula
	 */
	public void recogerIdPeliculaSeleccionada(int idPelicula) {
		pelicula.setIdPelicula(idPelicula);
	}

	/**
	 * metodo que sirve para pasar el id de la pelicula
	 * 
	 * @return idPelicula
	 */
	public int pasarIdPeliculaSeleccionada() {
		int idPelicula = pelicula.getIdPelicula();
		return idPelicula;
	}

	/**
	 * metodo que sirve para almacenar las peliculas que sacamos de la base de datos
	 * en un arraylist llamado peliculas
	 * 
	 * @return arraylist peliculas
	 */
	public ArrayList<Pelicula> almacenarPeliculas() {
		ArrayList<Pelicula> peliculas = gestionBD.sacarPeliculasDependiendoDelCineSeleccionado(pasarNombreCine());
		return peliculas;
	}

	/**
	 * metodo que sirve para sacar las funciones de un cine y una pelicula
	 * determinada
	 * 
	 * @param idPelicula
	 * @param nombreCine
	 * @return arraylist funciones
	 */
	public ArrayList<Funcion> almacenarFunciones(int idPelicula, String nombreCine) {
		ArrayList<Funcion> funciones = gestionBD.sacarInformacionDeUnaPeliculaDelCineSeleccionado(idPelicula,
				nombreCine);
		return funciones;
	}

	/**
	 * Metodo para recoger la fecha de la funcion seleccionada
	 * 
	 * @param fecha
	 */

	public void recogerFechaSeleccionada(String fecha) {
		funcion.setFechafuncion(fecha);
	}

	/**
	 * metodo para pasar la fecha de la funcion seleccionada
	 * 
	 * @return fecha
	 */
	public String pasarFechaSeleccionada() {
		String fecha = funcion.getFechafuncion();
		return fecha;
	}

	/**
	 * metodo que recoge la fecha de la funcion seleccionada
	 * 
	 * @param hora
	 */
	public void recogerHoraSeleccionada(String hora) {
		funcion.setHorafuncion(hora);
	}

	/**
	 * metodo que pasa la fecha de la funcion seleccionada
	 * 
	 * @return hora
	 */
	public String pasarHoraSeleccionada() {
		String hora = funcion.getHorafuncion();
		return hora;
	}

	/**
	 * metodo que asigna la id de la sala asignada (que le pasamos como parametro)
	 * al objeto Sala
	 * 
	 * @param idSala
	 */
	public void recogerIdSalaSeleccionada(int idSala) {
		sala.setIdSala(idSala);
	}

	/**
	 * metodo que pasa la id de la sala asignada
	 * 
	 * @return idSala
	 */
	public int pasarIdSalaSeleccionada() {
		int idSala = sala.getIdSala();
		return idSala;
	}

	/**
	 * metodo que recoge el precio de la funcion seleccionada
	 * 
	 * @param precio
	 */
	public void recogerPrecio(double precio) {
		funcion.setPrecio(precio);
	}

	/**
	 * metodo para pasar el precio de la funcion seleccionada
	 */
	public double pasarPrecio() {
		double precio = funcion.getPrecio();
		return precio;
	}

	/**
	 * metodo para crear la entrada, utilizamos de base el objeto Entrada que tiene
	 * los siguientes parametros:
	 * 
	 * @param idEntrada
	 * @param fecha
	 * @param nombrePelicula
	 * @param horario
	 * @param sala
	 * @param precio
	 * @param cine
	 * @param cantidad
	 * @param idCompra
	 */
	public void crearEntrada(int idEntrada, String fecha, String nombrePelicula, String horario, int sala,
			double precio, String cine, int cantidad, int idCompra) {

		entrada = new Entrada(idEntrada, fecha, nombrePelicula, horario, sala, precio, cine, cantidad, idCompra);
		System.out.println(entrada);
		añadirEntradas(entrada);
	}

	/**
	 * metodo que sirve para añadir la entrada al arraylist entradas(le pasamos como
	 * parametro la entrada)
	 * 
	 * @param entrada
	 */
	public void añadirEntradas(Entrada entrada) {
		entradas.add(entrada);
	}

	/**
	 * metodo que devuelve el arraylist entradas
	 * 
	 * @return
	 */
	public ArrayList<Entrada> enseñarEntradas() {
		return entradas;
	}

	/**
	 * metodo que convierte la cantidad seleccionada como String a Int
	 * 
	 * @param cantidadSeleccionada
	 */
	public void convertirAIntCantidad(String cantidadSeleccionada) {
		int cantidad = Integer.parseInt(cantidadSeleccionada);
		recogerCantidadSeleccionada(cantidad);
	}

	/**
	 * metodo que recoge la cantidad de entradas que seleccionamos y se la setea a
	 * el objeto entrada
	 * 
	 * @param cantidad
	 */
	public void recogerCantidadSeleccionada(int cantidad) {
		entrada.setCantidad(cantidad);
	}

	/**
	 * metodo para pasar la cantidad de entradas seleccionadas
	 * 
	 * @return
	 */
	public int pasarCantidadSeleccionada() {
		int cantidad = entrada.getCantidad();
		return cantidad;
	}

	/**
	 * Metodo para pasar la funcion seleccionada, llama a el metodo
	 * pasarHoraSeleccionada y pasarIdSalaSeleccionada para luego crear una variable
	 * en la cual concatena ambos resultados y devuelve la variable
	 * 
	 * @return horayFecha
	 */
	public String pasarFuncionSeleccionada() {
		String horaSeleccionada = pasarHoraSeleccionada();
		int salaSeleccionada = pasarIdSalaSeleccionada();
		String horaYFecha = horaSeleccionada + "- Sala " + salaSeleccionada;
		return horaYFecha;
	}

	/**
	 * metodo que convierte un String a double
	 * 
	 * @param convertir
	 */
	public void convertirADouble(String convertir) {
		double precio = Double.parseDouble(convertir);
		recogerPrecio(precio);
	}

	/**
	 * metodo que convierte un String en int, le pasamos como parametro un string
	 * "sala"
	 * 
	 * @param sala
	 */
	public void convertirAIntSala(String sala) {
		int idSala = Integer.parseInt(sala);
		recogerIdSalaSeleccionada(idSala);

	}

	/**
	 * metodo que separa la funcion seleccionada con un split para mostrarla
	 * correctamente
	 * 
	 * @param funcionSeleccionada
	 */

	public void separarFuncionSeleccionada(String funcionSeleccionada) {
		String horaSeleccionada = funcionSeleccionada.split("-")[0];
		String sala = funcionSeleccionada.split("a ")[1];
		convertirAIntSala(sala);
//		recogerFuncionSeleccionada(horaSeleccionada, salaSeleccionada);
		recogerHoraSeleccionada(horaSeleccionada);

	}

	/**
	 * metodo que calcula el descuento en el resumen de compra
	 * 
	 * @param precioReal
	 * @param cantidad
	 * @return
	 */
	public double descuento(double precioReal, int cantidad) {
		double precioConDescuento = 0;
//		int numero = entradas.size();
		if (entradas.size() == 2) {
			precioConDescuento = ((precioReal * cantidad) * 20) / 100;
			return precioConDescuento;
		} else if (entradas.size() >= 3) {
			precioConDescuento = ((precioReal * cantidad) * 30) / 100;
			return precioConDescuento;
		}
		return precioConDescuento;
	}

	/**
	 * metodo que recoge el descuento y lo setea en el objeto Compra
	 */
	public void recogerDescuento() {
		String descuento = null;
		if (entradas.size() == 2) {
			descuento = "20%";
			compra.setDescuento(descuento);
		} else if (entradas.size() >= 3) {
			descuento = "30%";
			compra.setDescuento(descuento);
		} else {
			compra.setDescuento(descuento);
		}

	}

	/**
	 * metodo que pasa el descuento, lo saca del objeto compra
	 * 
	 * @return descuento
	 */
	public String pasarDescuento() {
		String descuento = compra.getDescuento();
		System.out.println(descuento);
		return descuento;
	}

	/**
	 * metodo que setea el dni en el objeto compra
	 * 
	 * @param dni
	 */
	public void recogerDNI(String dni) {
		compra.setDni(dni);
	}

	/**
	 * metodo que pasa el dni de la compra
	 * 
	 * @return
	 */
	public String pasarDNI() {
		String dni = compra.getDni();
		return dni;
	}

	/**
	 * metodo para crear la compra, recibe como parametro los atributos del objeto
	 * Compra
	 * 
	 * @param idCompra
	 * @param dni
	 * @param descuento
	 * @param fecha
	 * @param hora
	 */
	public void crearCompra(int idCompra, String dni, String descuento, String fecha, String hora) {
		compra = new Compra(idCompra, dni, descuento, fecha, hora);
		System.out.println(compra);
		añadirCompra(compra);
	}

	/**
	 * metodo que añade el objeto compra al arraylist compras
	 * 
	 * @param compra
	 */
	public void añadirCompra(Compra compra) {
		compras.add(compra);
	}

	/**
	 * metodo que muestra las compras...
	 * 
	 * @return arraylist compras
	 */
	public ArrayList<Compra> enseñarCompras() {
		return compras;
	}

	/**
	 * metodo que setea la fecha de la compra en el objeto compra
	 * 
	 * @param fechaCompra
	 */
	public void recogerFechaCompra(String fechaCompra) {

		compra.setFechaCompra(fechaCompra);
	}

	/**
	 * metodo que pasa la fecha de la compra
	 * 
	 * @return fechaCompra
	 */
	public String pasarFechaCompra() {
		String fechaCompra = compra.getFechaCompra();
		// System.out.println(fechaCompra);
		return fechaCompra;
	}

	/**
	 * metodo que setea la hora compra al objeto compra
	 * 
	 * @param horaCompra
	 */
	public void recogerHoraCompra(String horaCompra) {

		compra.setHoraCompra(horaCompra);
	}

	/**
	 * metodo que pasa la horaCompra, la saca del objeto compra
	 * 
	 * @return
	 */
	public String pasarHoraCompra() {
		String horaCompra = compra.getHoraCompra();
		// System.out.println(horaCompra);
		return horaCompra;
	}

	/**
	 * metodo que verifica si debe cambiar el panel en el panel de seleccion de cine
	 * al apretar el boton finalizar o si debe llevarte al resumen de compra,
	 * comprueba si hay entradas seleccionadas, si no hay entradas te cierra la
	 * aplicacion, si hay entradas te lleva al resumen de compra
	 * 
	 * @return verificar
	 */
	public boolean verificarPasoDePanel() {
		boolean verificar = false;
		if (entradas.isEmpty()) {
			verificar = true;
			return verificar;
		} else {
			return verificar;
		}
	}

	/**
	 * metodo que calcula la cantidad total de entradas
	 * 
	 * @return
	 */
	public int cantidadTotalDeEntradas() {
		int cantidadTotal = 0;
		for (int i = 0; i < entradas.size(); i++) {
			cantidadTotal = cantidadTotal + pasarCantidadSeleccionada();
		}
		return cantidadTotal;
	}

	/**
	 * metodo que te muestra un mensaje si quieres una copia del recibo, si la
	 * respuesta es si te sobreescribe el fichero Recibo.txt con los datos de la
	 * compra, si respondes que no, no se escribe el fichero
	 * 
	 * @param v
	 */
	public void mensajeDeRecibo(VentanaPrincipal v) {
		int resp = JOptionPane.showConfirmDialog(null, "Quiere una copia del recibo? ", "Recibo",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		switch (resp) {

		case 0:
			ficheros.escribirFichero(entradas);
			gestionBD.insertarEntrada(entradas);
			gestionBD.insertarCompra(compras);
			mensajeVolverAlInicio(v);
			break;
		case 1:
			gestionBD.insertarEntrada(entradas);
			gestionBD.insertarCompra(compras);
			mensajeVolverAlInicio(v);
			break;
		}
	}

	/**
	 * metodo que pregunta por si quieres volver al inicio, si la respuesta es si te
	 * manda al login, si es no te cierra el programa
	 * 
	 * @param v
	 */
	public void mensajeVolverAlInicio(VentanaPrincipal v) {
		int resp = JOptionPane.showConfirmDialog(null, "Quiere volver a la pantalla de inicio? ", "Pantalla de inicio",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		switch (resp) {

		case 0:
			v.cambiarDePanel(1);
			break;
		case 1:
			System.exit(0);
			break;
		}
	}

	public void generarIdCompra() {
		ArrayList<Compra> compras = gestionBD.sacarIdCompra();
		int idCompra = 1;
		if (compras.isEmpty()) {
			compra.setIdCompra(idCompra);
			System.out.println(idCompra);
		} else {
			idCompra = compras.get(0).getIdCompra();
			idCompra++;
			compra.setIdCompra(idCompra);
			System.out.println(idCompra);
		}
	}

	public int pasarIdCompra() {
		int idCompra = compra.getIdCompra();
		return idCompra;
	}

	public double precioReal() {
		double precioReal = 0;
		for (int j = 0; j < entradas.size(); j++) {
			precioReal = precioReal + (entradas.get(j).getPrecio() * cantidadTotalDeEntradas());
		}
		return precioReal;
	}

	// ---------------------------------------------------------------------------

//	// [GET] - - RECOGE SALA Y HORA
//		public void recogerFuncionSeleccionada(String horaSeleccionada, int salaSeleccionada) {
//			funcion.setHorafuncion(horaSeleccionada);
//			funcion.setIdsala(salaSeleccionada);
//		}

}
