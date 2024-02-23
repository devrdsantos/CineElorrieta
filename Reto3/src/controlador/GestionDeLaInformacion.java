package controlador;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Locale;
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

	public void crearEntrada(int idEntrada, String fecha, String nombrePelicula, String horario, int sala,
			double precio, String cine, int cantidad, int idCompra) {

//		System.out.println(cantidad);
		entrada = new Entrada(idEntrada, fecha, nombrePelicula, horario, sala, precio, cine, cantidad, idCompra);
//		System.out.println(entrada);
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
		int salaSeleccionada = pasarIdSalaSeleccionada();
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

	public void recogerDescuento() {
		String descuento = "";
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

	public String pasarDescuento() {
		String descuento = compra.getDescuento();
//		System.out.println(descuento);
		return descuento;
	}

	public void recogerDNI(String dni) {
		compra.setDni(dni);
	}

	public String pasarDNI() {
		String dni = compra.getDni();
		return dni;
	}

	public void crearCompra(int idCompra, String dni, String descuento, String fecha, String hora) {
		compra = new Compra(idCompra, dni, descuento, fecha, hora);
//		System.out.println(compra);
		añadirCompra(compra);
	}

	public void añadirCompra(Compra compra) {
		compras.add(compra);
	}

	public ArrayList<Compra> enseñarCompras() {
		return compras;
	}

	public void recogerFechaCompra(String fechaCompra) {
		compra.setFechaCompra(fechaCompra);
	}

	public String pasarFechaCompra() {
		String fechaCompra = compra.getFechaCompra();
//		System.out.println(fechaCompra);
		return fechaCompra;
	}

	public void recogerHoraCompra(String horaCompra) {
		compra.setHoraCompra(horaCompra);
	}

	public String pasarHoraCompra() {
		String horaCompra = compra.getHoraCompra();
//		System.out.println(horaCompra);
		return horaCompra;
	}

	public boolean verificarPasoDePanel() {
		boolean verificar = false;
		if (entradas.isEmpty()) {
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

	// Inecesario este metodo si pones un boton de salir de la aplicacion en el
	// panelLogin
	public void mensajeVolverAlInicio(VentanaPrincipal v) {
		int resp = JOptionPane.showConfirmDialog(null, "Quiere volver a la pantalla de inicio? ", "Pantalla de inicio",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		switch (resp) {

		case 0:
			reinicio();
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
//			System.out.println(idCompra);
		} else {
			idCompra = compras.get(0).getIdCompra();
			idCompra++;
			compra.setIdCompra(idCompra);
//			System.out.println(idCompra);
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

	public void formatoParaFecha(LocalDate fechaSinFormato) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fecha = formato.format(fechaSinFormato);
		recogerFechaCompra(fecha);
	}

	public void formatoParaHora(LocalTime horaSinFormato) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm", Locale.US);
		String hora = formato.format(horaSinFormato);
		recogerHoraCompra(hora);
	}

	public void reinicio() {
		entradas.removeAll(entradas);
	}

	public void verPeliculasRepetidas(String nombrePelicula, VentanaPrincipal v, String nombreCine) {
		System.out.println(nombreCine);
		if (entradas.isEmpty()) {
			v.cambiarDePanel(5);
		} else {
			for (int i = 0; i < entradas.size(); i++) {
				if (entradas.get(i).getNombrePelicula().equals(nombrePelicula)
						&& entradas.get(i).getCine().equals(nombreCine)) {
					JOptionPane.showMessageDialog(null, "Ya has elegido " + entradas.get(i).getNombrePelicula()
							+ " para el " + entradas.get(i).getCine());
				} else {
					v.cambiarDePanel(5);
				}
			}
		}
	}

	// ---------------------------------------------------------------------------

//	// [GET] - - RECOGE SALA Y HORA
//		public void recogerFuncionSeleccionada(String horaSeleccionada, int salaSeleccionada) {
//			funcion.setHorafuncion(horaSeleccionada);
//			funcion.setIdsala(salaSeleccionada);
//		}

}
