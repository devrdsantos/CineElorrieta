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
	}

	/*
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

	public ArrayList<Cine> almacenarCines() {
		ArrayList<Cine> cines = gestionBD.sacarCines();
		return cines;
	}

	public String encriptar(String mensaje) throws Exception {
		Key claveAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, claveAES);

		byte[] mensajeEncriptado = cipher.doFinal(mensaje.getBytes());

		return Base64.getEncoder().encodeToString(mensajeEncriptado);
	}

	public String desencriptar(String mensajeEncriptado) throws Exception {

		byte[] mensajeBytes = Base64.getDecoder().decode(mensajeEncriptado);

		Key ClaveaAES = new SecretKeySpec(CLAVE_ENCRIPTADA.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.DECRYPT_MODE, ClaveaAES);

		String desencriptado = new String(cipher.doFinal(mensajeBytes));

		return desencriptado;
	}

	/*
	 * DIRIA QUE NO ES NECESARIO PASAR DE UN METODO A OTRO!!
	 */

	public void recogerCineSeleccionado(String cineSeleccionado) {

		cine.setNombreCine(cineSeleccionado);
	}

	public String pasarNombreCine() {
		String nombreCine = cine.getNombreCine();
		return nombreCine;
	}

	public void recogerPeliculaSeleccionada(String peliculaSeleccionada) {

		pelicula.setNombrePelicula(peliculaSeleccionada);
	}

	public String pasarNombrePelicula() {
		String nombrePelicula = pelicula.getNombrePelicula();
		return nombrePelicula;
	}

	public void recogerIdPeliculaSeleccionada(int idPelicula) {
		pelicula.setIdPelicula(idPelicula);
	}

	public int pasarIdPeliculaSeleccionada() {
		int idPelicula = pelicula.getIdPelicula();
		return idPelicula;
	}

	public ArrayList<Pelicula> almacenarPeliculas() {
		ArrayList<Pelicula> peliculas = gestionBD.sacarPeliculasDependiendoDelCineSeleccionado(pasarNombreCine());
		return peliculas;
	}

	public ArrayList<Funcion> almacenarFunciones(int idPelicula, String nombreCine) {
		ArrayList<Funcion> funciones = gestionBD.sacarInformacionDeUnaPeliculaDelCineSeleccionado(idPelicula,
				nombreCine);
		return funciones;
	}

	// Metodo para crear el idEntrada
	
	
	
	public void recogerFechaSeleccionada(String fecha) {
		funcion.setFechafuncion(fecha);
	}

	public String pasarFechaSeleccionada() {
		String fecha = funcion.getFechafuncion();
		return fecha;
	}
	
	public void recogerHoraSeleccionada(String hora) {
		funcion.setHorafuncion(hora);
	}
	
	public String pasarHoraSeleccionada() {
		String hora = funcion.getHorafuncion();
		return hora;
	}
	
	public void recogerIdSalaSeleccionada(int idSala) {
		sala.setIdSala(idSala);
	}
	
	public int pasarIdSalaSeleccionada() {
		int idSala = sala.getIdSala();
		return idSala;
	}
	
	public void recogerPrecio(double precio) {
		funcion.setPrecio(precio);
	}

	public double pasarPrecio() {
		double precio = funcion.getPrecio();
		return precio;
	}
	
	public void crearEntrada(String fecha, String nombrePelicula, String horario, int sala,
			double precio, String cine, int cantidad) {
		
		entrada = new Entrada(fecha, nombrePelicula, horario, sala, precio, cine, cantidad);
		System.out.println(entrada);
		añadirEntradas(entrada);
	}

	public void añadirEntradas(Entrada entrada) {
		entradas.add(entrada);
	}
	
	public ArrayList<Entrada> enseñarEntradas() {
		return entradas;
	}
	
	public void convertirAIntCantidad(String cantidadSeleccionada) {
		int cantidad = Integer.parseInt(cantidadSeleccionada);
		recogerCantidadSeleccionada(cantidad);
	}

	public void recogerCantidadSeleccionada(int cantidad) {
		entrada.setCantidad(cantidad);
	}
	
	public int pasarCantidadSeleccionada() {
		int cantidad = entrada.getCantidad();
		return cantidad;
	}
	
	public String pasarFuncionSeleccionada() {
		String horaSeleccionada = pasarHoraSeleccionada();
		int salaSeleccionada = pasarIdSalaSeleccionada();;
		String horaYFecha = horaSeleccionada + "- Sala " + salaSeleccionada;
		return horaYFecha;
	}
	
	public void convertirADouble(String convertir) {
		double precio = Double.parseDouble(convertir);
		recogerPrecio(precio);
	}

	public void convertirAIntSala(String sala) {
		int idSala = Integer.parseInt(sala);
		recogerIdSalaSeleccionada(idSala);
		
	}
	
	public void separarFuncionSeleccionada(String funcionSeleccionada) {
		String horaSeleccionada = funcionSeleccionada.split("-")[0];
		String sala = funcionSeleccionada.split("a ")[1];
		convertirAIntSala(sala);
//		recogerFuncionSeleccionada(horaSeleccionada, salaSeleccionada);
		recogerHoraSeleccionada(horaSeleccionada);
		
	}
	
	public double descuento(double precioReal, int cantidad) {
		double precioConDescuento = 0;
		int numero = entradas.size();
		if(numero == 2) {
			precioConDescuento = ((precioReal * cantidad)* 20)/100;
			return precioConDescuento;
		} else if (numero >= 3) {
			precioConDescuento = ((precioReal * cantidad)* 30)/100;
			return precioConDescuento;
		}
		return precioConDescuento;
	}		
	
	public boolean verificarPasoDePanel() {
		boolean verificar = false;
		if(entradas.isEmpty()) {
			verificar = true;
			return verificar;
		} else {
			return verificar;
		}
	}
	
	public int cantidadTotalDeEntradas() {
		int cantidadTotal = 0;
		for (int i = 0; i < entradas.size(); i++) {
			cantidadTotal = cantidadTotal + pasarCantidadSeleccionada();
		}
		return cantidadTotal;
	}
	
	//---------------------------------------------------------------------------
	
	
//	// [GET] - - RECOGE SALA Y HORA
//		public void recogerFuncionSeleccionada(String horaSeleccionada, int salaSeleccionada) {
//			funcion.setHorafuncion(horaSeleccionada);
//			funcion.setIdsala(salaSeleccionada);
//		}
	
	

}
