package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionBD;
import modelo.Cine;
import modelo.Pelicula;

public class TestGestorBD {

	static GestionBD gestion;

	@BeforeClass
	public static void BeforeClass() {
		gestion = new GestionBD();
	}

	@Test
	public void testSacarCines1() {
		ArrayList<Cine> sacarCine = gestion.sacarCines();
		Cine primerCine = sacarCine.get(0);
		Cine expected = new Cine(1, "Cine Zubiarte", "Deusto", "Cerca del guggenheim");

		assertEquals(expected, primerCine);
	}

	@Test
	public void testSacarCines2() {
		ArrayList<Cine> sacarCine = gestion.sacarCines();
		Cine ultimoCine = sacarCine.get(2);
		Cine expected = new Cine(3, "Cine Elorrieta", "San Ignacio", "Al lado de elorrieta-errekamari");

		assertEquals(expected, ultimoCine);
	}

	@Test
	public void testSacarPeliculasDelCineSeleccionado() {
		ArrayList<Pelicula> peliculas =  gestion.sacarPeliculasDependiendoDelCineSeleccionado("Cine Zubiarte");
		ArrayList<Pelicula> testPeliculas = new ArrayList<Pelicula>();
		testPeliculas.add(new Pelicula(1, "Inception", "148", "Ciencia ficción/Acción", "Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños, se le da la tarea inversa de plantar una idea en la mente de un CEO."));
		testPeliculas.add(new Pelicula(2, "Parasite", "132", "Drama/Thriller", "Una familia empobrecida se infiltra en la casa de una familia rica, lo que lleva a eventos inesperadamente oscuros."));
		testPeliculas.add(new Pelicula(3, "Gladiator", "155", "Acción/Drama histórico", "Un general romano traicionado se convierte en gladiador y lucha por venganza contra el corrupto emperador que asesinó a su familia y lo envió al exilio."));
		testPeliculas.add(new Pelicula(5, "El Gran Hotel Budapest", "99", "Comedia/Drama", "El conserje de un famoso hotel europeo entre guerras se alía con uno de sus empleados para demostrar su inocencia después de ser acusado de asesinato."));
		testPeliculas.add(new Pelicula(6, "Coco", "105", "Animación/Fantasía", "Un joven músico entra en la Tierra de los Muertos para encontrar a su bisabuelo, un legendario cantante, y revertir la prohibición de su familia sobre la música."));
		testPeliculas.add(new Pelicula(7, "El Señor de los Anillos", "178", "Fantasía/Aventura", "Un joven hobbit, Frodo, se embarca en una peligrosa misión para destruir un anillo antiguo que es buscado por el malvado Sauron."));
		
		
		assertEquals(testPeliculas, peliculas);
	 
		
		
	}

}
