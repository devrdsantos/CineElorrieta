package controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.Cine;
import modelo.Entrada;

public class GestionDeFicheros {

	
	public GestionDeFicheros() {
		
	}
	
	public void escribirFichero(ArrayList<Entrada> entradas, ArrayList<Cine> cines) {
		try {
			BufferedWriter escribirFichero = new BufferedWriter(new FileWriter("ficheros/Recibo.txt"));
			for (int i = 0; i < entradas.size(); i++) {
				escribirFichero.write("TU COMPRA:\n");
				escribirFichero.write(entradas.get(i).toString());
				escribirFichero.write("\n----------------------------------------");
				escribirFichero.write("\nFecha de la compra: " + LocalDate.now());
				escribirFichero.write("\n----------------------------------------");
				escribirFichero.write("\nHora de la compra: " + LocalTime.now());
				escribirFichero.write("\n----------------------------------------");
				escribirFichero.newLine();
				escribirFichero.write("*******************************************************");
				escribirFichero.newLine();
			}
			escribirFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}