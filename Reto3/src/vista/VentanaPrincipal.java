package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
import paneles.PanelBienvenida;

import paneles.PanelFuncionEscogida;
import paneles.PanelLogin;
import paneles.PanelRegistro;
import paneles.PanelResumenCompra;
import paneles.PanelSeleccionCine;
import paneles.PanelSeleccionFuncion;
import paneles.PanelSeleccionPelicula;

public class VentanaPrincipal extends JFrame {

	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 720);
		setVisible(true);
		setTitle("Cines ESA");
		setResizable(false);

		/**
		 * Logo de la ventana
		 */
		String rutaLogo = "src\\ventanas\\logoProyecto.png";
		ImageIcon icono = new ImageIcon(rutaLogo);
		setIconImage(icono.getImage());
	}

	/**
	 * Cambio de paneles
	 * 
	 */
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0: {
			setContentPane(new PanelBienvenida(this)); // PanelBienvenida
			break;
		}
		case 1: {
			setContentPane(new PanelLogin(this));
			break;
		}
		case 2: {
			setContentPane(new PanelRegistro(this, this.gestionINF));
			break;
		}
		case 3: {
			setContentPane(new PanelSeleccionCine(this, this.gestionINF));
			break;
		}
		case 4: {
			setContentPane(new PanelSeleccionPelicula(this, this.gestionINF));
			break;
		}
		case 5: {
			setContentPane(new PanelSeleccionFuncion(this, this.gestionINF));
			break;
		}
		case 6: {
			setContentPane(new PanelFuncionEscogida(this));
			
			break;
		}
		
		}
	}

	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(true);
		v.cambiarDePanel(3);

	}
}
