package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vista.VentanaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelSeleccionFuncion extends JPanel {

	public PanelSeleccionFuncion (VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaPelicula = new JLabel("Selecciona una película");
		seleccionaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaPelicula.setForeground(Color.decode("#ffffff"));
		seleccionaPelicula.setFont(new Font("Verdana", Font.BOLD, 32));
		seleccionaPelicula.setBounds(285, 38, 584, 59);
		add(seleccionaPelicula);

		// BOTÓN SECUNDARIO - - VOLVER ATRÁS
		JButton btnSecundario = new JButton("<html><u>Volver a Seleccionar Cine<u><html>");
		btnSecundario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnSecundario.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnSecundario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSecundario.setOpaque(true);
		btnSecundario.setContentAreaFilled(true);
		btnSecundario.setForeground(Color.decode("#C67ACE"));
		btnSecundario.setBorderPainted(false);
		btnSecundario.setBackground(Color.decode("#142850"));
		btnSecundario.setBounds(21, 23, 254, 39);
		add(btnSecundario);

		// LBL PELICULAS EN CARTELERA
		JLabel lblPeliculasEnCartelera = new JLabel("Películas en cartelera para:");
		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPeliculasEnCartelera.setBounds(361, 91, 273, 49);
		add(lblPeliculasEnCartelera);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblCineSeleccionado = new JLabel("CINE SELECCIONADO");
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblCineSeleccionado.setForeground(Color.decode("#C67ACE"));
		lblCineSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCineSeleccionado.setBounds(619, 91, 222, 49);
		add(lblCineSeleccionado);
		
		/* --- GRUPO --- 1 */
		// LABEL TITULO PELICULA
		JLabel lblTituloPelicula1 = new JLabel("<html>Título Película 1<br>Título Película 1 <br> Soy el título de una película</html>");
		lblTituloPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1.setBounds(747, 151, 353, 83);
		lblTituloPelicula1.setForeground(Color.decode("#86A7FC"));
		add(lblTituloPelicula1);

		// LABEL FOTO PELICULA
		JLabel lblFoto1 = new JLabel("Foto1");
		lblFoto1.setOpaque(true);
		lblFoto1.setBackground(Color.decode("#ffffff"));
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFoto1.setBounds(247, 151, 474, 450);
		add(lblFoto1);

		// LABEL DURACIÓN PELICULA
		JLabel lblDuracionPelicula1 = new JLabel("Duración: ");
		lblDuracionPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracionPelicula1.setForeground(Color.WHITE);
		lblDuracionPelicula1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDuracionPelicula1.setBounds(747, 234, 96, 34);
		add(lblDuracionPelicula1);

		// LABEL DURACIÓN PELICULA (TRAÍDO DE LA BD)
		JLabel lblDuracionPelicula1BD = new JLabel("160");
		lblDuracionPelicula1BD.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracionPelicula1BD.setForeground(Color.WHITE);
		lblDuracionPelicula1BD.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblDuracionPelicula1BD.setBounds(838, 233, 40, 34);
		add(lblDuracionPelicula1BD);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos1 = new JLabel("minutos");
		lblMinutos1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos1.setForeground(Color.WHITE);
		lblMinutos1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblMinutos1.setBounds(876, 234, 66, 34);
		add(lblMinutos1);
		
		// BTN PRINCIPAL -- SELECCIONAR PELICULA
		JButton btnSeleccionarPelicula1 = new JButton("Seleccionar película");
		btnSeleccionarPelicula1.setOpaque(true);
		btnSeleccionarPelicula1.setForeground(Color.WHITE);
		btnSeleccionarPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSeleccionarPelicula1.setContentAreaFilled(true);
		btnSeleccionarPelicula1.setBorderPainted(false);
		btnSeleccionarPelicula1.setBackground(new Color(198, 122, 206));
		btnSeleccionarPelicula1.setBounds(747, 290, 195, 34);
		add(btnSeleccionarPelicula1);
		
		// BTN ANTERIOR
		// CUANDO NO HAY ANTERIOR PERMANECERÁ CON ESTE ESTILO, QUE ES EL DISABLED, SINO CAMBIA Y ES IGUAL QUE EL BTN SIGUIENTE
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnterior.setOpaque(true);
		btnAnterior.setForeground(Color.decode("#A9A9A9"));
		btnAnterior.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAnterior.setContentAreaFilled(true);
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBackground(Color.decode("#F3EEEA"));
		btnAnterior.setBounds(247, 612, 125, 34);
		add(btnAnterior);
		
		
		// BTN SIGUIENTE
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setOpaque(true);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSiguiente.setContentAreaFilled(true);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setBackground(new Color(134, 167, 252));
		btnSiguiente.setBounds(596, 612, 125, 34);
		add(btnSiguiente);

		
	}
}