package paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelDePrueba extends JPanel{
	
	PanelDePrueba(){
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#0f4c5c"));
		JLabel mensajeBienvenida = new JLabel("Bienvenido/a al Cine Elorrieta.");
		mensajeBienvenida.setForeground(Color.decode("#ffffff"));
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		mensajeBienvenida.setBounds(143, 246, 502, 39);
	}

}
