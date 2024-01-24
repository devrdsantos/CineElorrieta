package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vista.VentanaPrincipal;

public class PanelBienvenida extends JPanel {

	public PanelBienvenida(VentanaPrincipal v) {
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
		add(mensajeBienvenida);

		/*
		 * Funcionalidad de la ventana
		 */
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * Este variable es el sustituto de thread sleep Indica que luego de presionar
				 * el click pasen 3 segundos y cambie de panel
				 */
				long tiempoDeActivacion = System.currentTimeMillis() + 3000;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				v.cambiarDePanel(1);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
