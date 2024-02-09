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
import modelo.Funcion;
import modelo.Pelicula;
import vista.VentanaPrincipal;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private ArrayList<String> DatosUsuario;
	private Cine cine;
	private Pelicula pelicula;
	private Funcion funcion;
	private final String CLAVE_ENCRIPTADA = "clavecompartidanorevelarnuncamas";

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		DatosUsuario = new ArrayList<String>();

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

	public void recogerInformacionFormulario(String dniFormulario, String passFormulario, String nombreFormulario,
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
			JOptionPane.showMessageDialog(null, "Contraseña no valida");
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
	
	public void recogerCineSeleccionado(String cineSeleccionado) {
		cine = new Cine();
		cine.setNombreCine(cineSeleccionado);
		pasarNombreCine();
	}

	public String pasarNombreCine() {
		String nombreCine = cine.getNombreCine();
		return nombreCine;
	}
	
	public void recogerPeliculaSeleccionada(String peliculaSeleccionada) {
		pelicula = new Pelicula();
		pelicula.setNombrePelicula(peliculaSeleccionada);
		pasarNombrePelicula();
	}
	
	public String pasarNombrePelicula() {
		String nombrePelicula = pelicula.getNombrePelicula();
		return nombrePelicula;
	}
	
	public void recogerIdPeliculaSeleccionada(int IdPelicula) {
		pelicula.setIdPelicula(IdPelicula);
		pasarIdPeliculaSeleccionada();
	}

	public int pasarIdPeliculaSeleccionada() {
		int IdPelicula = pelicula.getIdPelicula();
		return IdPelicula;
	}
	
	public ArrayList<Pelicula> almacenarPeliculas() {
		ArrayList<Pelicula> peliculas = gestionBD.sacarInformacionPeliculas();
		return peliculas;
	}
	
	public ArrayList<Funcion> almacenarFunciones(int IdPelicula) {
		ArrayList<Funcion> funciones = gestionBD.sacarInformacionDeUnaPelicula(IdPelicula);
		return funciones;
	}
	
	// [GET] - - RECOGE SALA Y HORA
    public void recogerFuncionSeleccionada(String funcionSeleccionada) {
        funcion = new Funcion();
        String horaSeleccionada =  funcionSeleccionada.split("-")[0];
        String sala = funcionSeleccionada.split("a ")[1];
        int salaSeleccionada = Integer.parseInt(sala);
        funcion.setHorafuncion(horaSeleccionada);
        funcion.setIdsala(salaSeleccionada);
        pasarFuncionSeleccionada();
    }
    
    // [SET] - - PASAR SALA Y HORA
    public String pasarFuncionSeleccionada() {
        String horaSeleccionada = funcion.getHorafuncion();
    	int salaSeleccionada = funcion.getIdsala();
    	String HoraYFecha =  horaSeleccionada + "- Sala " + salaSeleccionada;
        return HoraYFecha;
    }
	
}
