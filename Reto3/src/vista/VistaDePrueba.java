package vista;

import javax.swing.JFrame;

import paneles.PanelBienvenida;

public class VistaDePrueba extends JFrame {

	VistaDePrueba(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 720);
		setVisible(true);
		setTitle("Cines ESA");
		setResizable(false);	
	}
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0: {
			//setContentPane(new PanelBienvenida(this));
			break;

		}

		}	
	}
	public static void main(String[] args) {
		VistaDePrueba v = new VistaDePrueba();
		v.cambiarDePanel(0);
		

	}

}
