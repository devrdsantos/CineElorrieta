package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionBD;
import modelo.Cine;
import modelo.Funcion;
import modelo.Pelicula;
import vista.VentanaPrincipal;

public class TestGestorBD {

	static GestionBD gestion;
	//test Cines disponibles
	static Cine primerCine;
	static Cine ultimoCine;
	//test peliculas del cine seleccionado
	static ArrayList<Pelicula> testPeliculas;
	//test sacar peliculas ordenadas
	static ArrayList<Pelicula> testPeliculasOrdenadas;
	//test fechas de una pelicula dependiendo del cine y pelicula
	static ArrayList<String> fechasDeUnaPelicula;
	//test sesiones de una pelicula dependiendo del cine y pelicula
	static ArrayList<Integer> funcionesDeUnaPelicula;
	//test precio de una pelicula dependiendo del cine y pelicula
	static double precioPeliculaEsperada;
	//test sala de una pelicula dependiendo del cine y pelicula
	static int salaEsperada;
	static int salaEsperada1;
	

	@BeforeClass
	public static void BeforeClass() {
		gestion = new GestionBD();
		
		//test Cines disponibles
		primerCine = new Cine(1, "Cine Zubiarte", "Deusto", "Cerca del guggenheim");
		ultimoCine = new Cine(3, "Cine Elorrieta", "San Ignacio", "Al lado de elorrieta-errekamari");
		
		// test peliculas de un cine
		testPeliculas = new ArrayList<Pelicula>();
		testPeliculas.add(new Pelicula(1, "Inception", "148", "Ciencia ficción/Acción",
				"Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños, se le da la tarea inversa de plantar una idea en la mente de un CEO."));
		testPeliculas.add(new Pelicula(2, "Parasite", "132", "Drama/Thriller",
				"Una familia empobrecida se infiltra en la casa de una familia rica, lo que lleva a eventos inesperadamente oscuros."));
		testPeliculas.add(new Pelicula(3, "Gladiator", "155", "Acción/Drama histórico",
				"Un general romano traicionado se convierte en gladiador y lucha por venganza contra el corrupto emperador que asesinó a su familia y lo envió al exilio."));
		testPeliculas.add(new Pelicula(5, "El Gran Hotel Budapest", "99", "Comedia/Drama",
				"El conserje de un famoso hotel europeo entre guerras se alía con uno de sus empleados para demostrar su inocencia después de ser acusado de asesinato."));
		testPeliculas.add(new Pelicula(6, "Coco", "105", "Animación/Fantasía",
				"Un joven músico entra en la Tierra de los Muertos para encontrar a su bisabuelo, un legendario cantante, y revertir la prohibición de su familia sobre la música."));
		testPeliculas.add(new Pelicula(7, "El Señor de los Anillos", "178", "Fantasía/Aventura",
				"Un joven hobbit, Frodo, se embarca en una peligrosa misión para destruir un anillo antiguo que es buscado por el malvado Sauron."));
		
		// Test peliculas ordenadas
		testPeliculasOrdenadas = new ArrayList<Pelicula>();
		testPeliculasOrdenadas.add(new Pelicula(1, "Inception", "148", "Ciencia ficción/Acción",
				"Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños, se le da la tarea inversa de plantar una idea en la mente de un CEO."));
		testPeliculasOrdenadas.add(new Pelicula(2, "Parasite", "132", "Drama/Thriller",
				"Una familia empobrecida se infiltra en la casa de una familia rica, lo que lleva a eventos inesperadamente oscuros."));
		testPeliculasOrdenadas.add(new Pelicula(3, "Gladiator", "155", "Acción/Drama histórico",
				"Un general romano traicionado se convierte en gladiador y lucha por venganza contra el corrupto emperador que asesinó a su familia y lo envió al exilio."));
		testPeliculasOrdenadas.add(new Pelicula(5, "El Gran Hotel Budapest", "99", "Comedia/Drama",
				"El conserje de un famoso hotel europeo entre guerras se alía con uno de sus empleados para demostrar su inocencia después de ser acusado de asesinato."));
		testPeliculasOrdenadas.add(new Pelicula(6, "Coco", "105", "Animación/Fantasía",
				"Un joven músico entra en la Tierra de los Muertos para encontrar a su bisabuelo, un legendario cantante, y revertir la prohibición de su familia sobre la música."));
		testPeliculasOrdenadas.add(new Pelicula(7, "El Señor de los Anillos", "178", "Fantasía/Aventura",
				"Un joven hobbit, Frodo, se embarca en una peligrosa misión para destruir un anillo antiguo que es buscado por el malvado Sauron."));
		
		// Test fechas de una pelicula
		fechasDeUnaPelicula = new ArrayList<String>();
		fechasDeUnaPelicula.add("28-02-2024");
		fechasDeUnaPelicula.add("01-03-2024");
		
		//test sesiones de una pelicula
		 funcionesDeUnaPelicula = new ArrayList<Integer>();
		 funcionesDeUnaPelicula.add(1);
		 funcionesDeUnaPelicula.add(3);
		 
		//test precioPelicula
		 precioPeliculaEsperada = 10.00;
		 
		//test sala de una pelicula dependiendo del cine y pelicula
		 salaEsperada = 1;
		 salaEsperada1 = 2; 
		
	}

	@Test
	public void testSacarCines1() {
		ArrayList<Cine> sacarCine = gestion.sacarCines();

		assertEquals(primerCine, sacarCine.get(0));
		assertEquals(ultimoCine, sacarCine.get(2));
	}

	

	@Test
	public void testSacarPeliculasDelCineSeleccionado() {
		ArrayList<Pelicula> peliculas = gestion.sacarPeliculasDependiendoDelCineSeleccionado("Cine Zubiarte");
		assertEquals(testPeliculas, peliculas);

	}


	@Test
	public void testSacarPeliculasOrdenadas() {
		ArrayList<Pelicula> peliculas = gestion.sacarPeliculasDependiendoDelCineSeleccionado("Cine Zubiarte");
		
		
		assertEquals(peliculas.get(0), testPeliculasOrdenadas.get(0));
		assertEquals(peliculas.get(5), testPeliculasOrdenadas.get(5));
	}
	
	
	@Test
	public void testFechasDeUnaPelicula() {
		
		ArrayList<String> fechasDeUnaPelicula2 = new ArrayList<String>();
		for (int i = 0; i < gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").size(); i++) {
			fechasDeUnaPelicula2.add(gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").get(i)
					.getFechafuncion());
		}
		assertEquals(fechasDeUnaPelicula, fechasDeUnaPelicula2);
	}
	
	@Test
	public void testFuncionesDeUnaPeliculaEnUnaFecha() {
		ArrayList<Integer> funciones = new ArrayList<Integer>();
		for (int i = 0; i < gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").size(); i++) {
			funciones.add(gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").get(i)
					.getIdfuncion());
		}
		
		assertEquals(funcionesDeUnaPelicula, funciones);
		
		
	}
	
	@Test
	public void precioDeUnaFuncionDependiendoDelCineYPelicula() {
		
		double precioPelicula = gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").get(0).getPrecio();
		
		assertEquals(precioPeliculaEsperada, precioPelicula, precioPeliculaEsperada);
	}
	
	@Test
	public void salaDeUnaPeliculaDependiendoDelCineYPelicula() {
		int salaPelicula = gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").get(0).getIdsala();
		int salaPelicula1 = gestion.sacarInformacionDeUnaPeliculaDelCineSeleccionado(1, "Cine Zubiarte").get(1).getIdsala();
		assertEquals(salaEsperada, salaPelicula);
		assertEquals(salaEsperada1, salaPelicula1);
	}
	
	@Test
	public void verificarLogin() throws Exception  {
		
			assertTrue(gestion.verificarLogin("12345678A", "123456", new VentanaPrincipal()));
			assertTrue(gestion.verificarLogin("23456789A", "123456", new VentanaPrincipal()));
			assertTrue(gestion.verificarLogin("12345678K", "123456", new VentanaPrincipal()));
			
		
		
		
	}
	
	
	
	
	
	

}
