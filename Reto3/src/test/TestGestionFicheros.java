package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionDeFicheros;
import modelo.Entrada;

public class TestGestionFicheros {
	static GestionDeFicheros gestionFichero;
	static ArrayList<Entrada> entradas;
	
	@BeforeClass
	public static void BeforeClass() {
		gestionFichero = new GestionDeFicheros();
		entradas = new ArrayList<Entrada>();
		entradas.add(new Entrada(1, "01-01-2001", "Titanic", "18:00", 1, 10.00, "Cine Zubiarte", 1,1));
	}

	@Test
	public void seEscribeElFicheroCorrectamente() {
		assertTrue(gestionFichero.escribirFichero(entradas));
		
		
	}

}
