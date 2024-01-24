package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
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
//	public void cambiarDePanel(int i) {
//
//		switch (i) {
//		case 0: {
//			setContentPane(new PanelBienvenida(this));
//			break;
//
//		}
//
//		case 1: {
//			setContentPane(new PanelLogin(this));
//			break;
//		}
//
//		case 2: {
//			setContentPane(new PanelMenuInicialUsuario(this, TiempoSabado, TiempoDomingo));
//			break;
//		}
//		}	
//	}

	public static void main(String[] args) {

		VentanaPrincipal v = new VentanaPrincipal();

	}

}
