//<<<<<<< HEAD
//package paneles;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//import controlador.GestionBD;
//import controlador.GestionDeLaInformacion;
//import modelo.Cine;
//import modelo.Pelicula;
//import vista.VentanaPrincipal;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseAdapter;
//
//public class PanelSeleccionPelicula extends JPanel {
//
//	private String[] urlPeliculas = { "multimedia/Inception.png", "multimedia/Parasite.png", "multimedia/Gladiator.png",
//			"multimedia/Intocable.png", "multimedia/GHB.png","multimedia/Coco.png","multimedia/SDLA.png"};
//	private int peliActual;
//	private GestionBD gestion = new GestionBD();
////	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();
////	private Cine cine;
//	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();
//	
//
//	public PanelSeleccionPelicula(VentanaPrincipal v) {
//		setSize(1200, 720);
//		setVisible(true);
//		setLayout(null);
//		setFont(new Font("Tahoma", Font.BOLD, 11));
//		setBackground(Color.decode("#142850"));
//
//		// MSJ BIENVENIDA
//		JLabel seleccionaPelicula = new JLabel("Selecciona una película");
//		seleccionaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
//		seleccionaPelicula.setForeground(Color.decode("#ffffff"));
//		seleccionaPelicula.setFont(new Font("Verdana", Font.BOLD, 32));
//		seleccionaPelicula.setBounds(285, 38, 584, 59);
//		add(seleccionaPelicula);
//
//		// BOTÓN SECUNDARIO - - VOLVER ATRÁS
//		JButton btnSecundario = new JButton("<html><u>Volver a Seleccionar Cine<u><html>");
//		btnSecundario.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				v.cambiarDePanel(3);
//			}
//		});
//		btnSecundario.setFont(new Font("Verdana", Font.PLAIN, 16));
//		btnSecundario.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnSecundario.setOpaque(true);
//		btnSecundario.setContentAreaFilled(true);
//		btnSecundario.setForeground(Color.decode("#C67ACE"));
//		btnSecundario.setBorderPainted(false);
//		btnSecundario.setBackground(Color.decode("#142850"));
//		btnSecundario.setBounds(21, 23, 254, 39);
//		add(btnSecundario);
//
//		// LBL PELICULAS EN CARTELERA
//		JLabel lblPeliculasEnCartelera = new JLabel("Películas en cartelera para:");
//		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
//		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
//		lblPeliculasEnCartelera.setBounds(361, 91, 273, 49);
//		add(lblPeliculasEnCartelera);
//
//		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
//		JLabel lblCineSeleccionado = new JLabel();
//		lblCineSeleccionado.setText("xxxxxxxxxxx");
//		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
//		lblCineSeleccionado.setForeground(Color.decode("#C67ACE"));
//		lblCineSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
//		lblCineSeleccionado.setBounds(619, 91, 222, 49);
//		add(lblCineSeleccionado);
//
//		/* --- GRUPO --- 1 */
//		// LABEL TITULO PELICULA
//		peliActual = 0;
//		JLabel lblTituloPelicula1 = new JLabel(peli.get(peliActual).getNombrePelicula());
//		lblTituloPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
//		lblTituloPelicula1.setFont(new Font("Verdana", Font.BOLD, 18));
//		lblTituloPelicula1.setBounds(747, 151, 353, 83);
//		lblTituloPelicula1.setForeground(Color.decode("#86A7FC"));
//		add(lblTituloPelicula1);
//
//		// LABEL FOTO PELICULA
//		JLabel lblFoto1 = new JLabel("");
//		lblFoto1.setBounds(333, 151, 474, 450);
//		add(lblFoto1);
//		ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
//		lblFoto1.setIcon(icono);
//
//		// LABEL DURACIÓN PELICULA
//		JLabel lblDuracionPelicula1 = new JLabel("Duración: ");
//		lblDuracionPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
//		lblDuracionPelicula1.setForeground(Color.WHITE);
//		lblDuracionPelicula1.setFont(new Font("Verdana", Font.BOLD, 16));
//		lblDuracionPelicula1.setBounds(747, 234, 96, 34);
//		add(lblDuracionPelicula1);
//
//		// LABEL DURACIÓN PELICULA (TRAÍDO DE LA BD)
//		JLabel lblDuracionPelicula1BD = new JLabel(peli.get(peliActual).getDuracion());
//		lblDuracionPelicula1BD.setHorizontalAlignment(SwingConstants.LEFT);
//		lblDuracionPelicula1BD.setForeground(Color.WHITE);
//		lblDuracionPelicula1BD.setFont(new Font("Verdana", Font.PLAIN, 16));
//		lblDuracionPelicula1BD.setBounds(838, 233, 40, 34);
//		add(lblDuracionPelicula1BD);
//
//		// LABEL DURACIÓN PELICULA - MINUTOS
//		JLabel lblMinutos1 = new JLabel("minutos");
//		lblMinutos1.setHorizontalAlignment(SwingConstants.LEFT);
//		lblMinutos1.setForeground(Color.WHITE);
//		lblMinutos1.setFont(new Font("Verdana", Font.PLAIN, 16));
//		lblMinutos1.setBounds(876, 234, 66, 34);
//		add(lblMinutos1);
//
//		// BTN PRINCIPAL -- SELECCIONAR PELICULA
//		JButton btnSeleccionarPelicula1 = new JButton("Seleccionar película");
//		btnSeleccionarPelicula1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//				v.cambiarDePanel(6);
//			}}
//		);	
//		btnSeleccionarPelicula1.setOpaque(true);
//		btnSeleccionarPelicula1.setForeground(Color.WHITE);
//		btnSeleccionarPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnSeleccionarPelicula1.setContentAreaFilled(true);
//		btnSeleccionarPelicula1.setBorderPainted(false);
//		btnSeleccionarPelicula1.setBackground(new Color(198, 122, 206));
//		btnSeleccionarPelicula1.setBounds(747, 290, 195, 34);
//		add(btnSeleccionarPelicula1);
//
//		// BTN SIGUIENTEs
//		JButton btnSiguiente = new JButton("Siguiente");
//		btnSiguiente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (peliActual == peli.size() - 1) {
//					JOptionPane.showMessageDialog(null, "No hay más elementos");
////							btnSiguiente.setFocusable(false);
////							btnSiguiente.setEnabled(false);
//
//				} else {
//					peliActual = peliActual + 1;
//					lblTituloPelicula1.setText(peli.get(peliActual).getNombrePelicula());
//					lblDuracionPelicula1BD.setText(peli.get(peliActual).getDuracion());
////							btnSiguiente.setFocusable(true);
////							btnSiguiente.setEnabled(true);
//					ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
//					lblFoto1.setIcon(icono);
//				}
//			}
//		});
//		btnSiguiente.setOpaque(true);
//		btnSiguiente.setForeground(Color.WHITE);
//		btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnSiguiente.setContentAreaFilled(true);
//		btnSiguiente.setBorderPainted(false);
//		btnSiguiente.setBackground(new Color(134, 167, 252));
//		btnSiguiente.setBounds(596, 612, 125, 34);
//		add(btnSiguiente);
//
//		// BTN ANTERIOR
//		// CUANDO NO HAY ANTERIOR PERMANECERÁ CON ESTE ESTILO, QUE ES EL DISABLED, SINO
//		// CAMBIA Y ES IGUAL QUE EL BTN SIGUIENTE
//		JButton btnAnterior = new JButton("Anterior");
//		btnAnterior.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (peliActual == 0) {
//					JOptionPane.showMessageDialog(null, "No hay más");
////					btnAnterior.setFocusable(false);
////					btnAnterior.setEnabled(false);
//				} else {
//					peliActual = peliActual - 1;
//					lblTituloPelicula1.setText(peli.get(peliActual).getNombrePelicula());
//					lblDuracionPelicula1BD.setText(peli.get(peliActual).getDuracion());
////					btnAnterior.setFocusable(true);
////					btnAnterior.setEnabled(true);
//					ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
//					lblFoto1.setIcon(icono);
//				}
//
//			}
//		});
//		btnAnterior.setOpaque(true);
//		// btnAnterior.setForeground(Color.decode("#A9A9A9"));
//		btnAnterior.setForeground(Color.WHITE);
//		btnAnterior.setFont(new Font("Verdana", Font.BOLD, 14));
//		btnAnterior.setContentAreaFilled(true);
//		btnAnterior.setBorderPainted(false);
//		// btnAnterior.setBackground(Color.decode("#F3EEEA"));
//		btnAnterior.setBackground(new Color(134, 167, 252));
//		btnAnterior.setBounds(247, 612, 125, 34);
//		add(btnAnterior);
//
//	}
//=======
package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
import modelo.Cine;
import modelo.Pelicula;
import vista.VentanaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PanelSeleccionPelicula extends JPanel {

	private String[] urlPeliculas = { "multimedia/Inception.png", "multimedia/Parasite.png", "multimedia/Gladiator.png",
			"multimedia/Intocable.png", "multimedia/GHB.png", "multimedia/Coco.png", "multimedia/SDLA.png" };
	private int peliActual;
	private GestionBD gestion = new GestionBD();
	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();

	public PanelSeleccionPelicula(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
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
		JButton btnVoler = new JButton("<html><u>Volver a Seleccionar Cine<u><html>");
		btnVoler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnVoler.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVoler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoler.setOpaque(true);
		btnVoler.setContentAreaFilled(true);
		btnVoler.setForeground(Color.decode("#C67ACE"));
		btnVoler.setBorderPainted(false);
		btnVoler.setBackground(Color.decode("#142850"));
		btnVoler.setBounds(21, 23, 254, 39);
		add(btnVoler);

		// LBL PELICULAS EN CARTELERA
		JLabel lblPeliculasEnCartelera = new JLabel("Películas en cartelera para:");
		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPeliculasEnCartelera.setBounds(43, 91, 273, 49);
		add(lblPeliculasEnCartelera);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblCineSeleccionado = new JLabel();
		lblCineSeleccionado.setText(gestionINF.pasarNombreCine());
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblCineSeleccionado.setForeground(new Color(211, 213, 248));
		lblCineSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCineSeleccionado.setBounds(301, 91, 222, 49);
		add(lblCineSeleccionado);

		/* --- GRUPO --- 1 */
		// LABEL TITULO PELICULA
		peliActual = 0;
		JLabel lblTituloPelicula = new JLabel();
		lblTituloPelicula.setText(peli.get(peliActual).getNombrePelicula());
		lblTituloPelicula.setVerticalAlignment(SwingConstants.TOP);
		lblTituloPelicula.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula.setBounds(717, 151, 321, 59);
		lblTituloPelicula.setForeground(Color.decode("#86A7FC"));
		add(lblTituloPelicula);

		// LABEL FOTO PELICULA
		JLabel lblFotoPortadaPelicula = new JLabel();
		// lblFoto1.setOpaque(true);
		ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
		lblFotoPortadaPelicula.setIcon(icono);
		// lblFoto1.setBackground(Color.decode("#ffffff"));
		// lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		// lblFoto1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFotoPortadaPelicula.setBounds(381, 151, 323, 450);
		add(lblFotoPortadaPelicula);

		// LABEL DURACIÓN PELICULA
		JLabel lblDuracionPelicula = new JLabel("Duración: ");
		lblDuracionPelicula.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracionPelicula.setForeground(Color.WHITE);
		lblDuracionPelicula.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDuracionPelicula.setBounds(717, 204, 96, 34);
		add(lblDuracionPelicula);

		// LABEL DURACIÓN PELICULA (TRAÍDO DE LA BD)
		JLabel lblDuracionPeliculaBD = new JLabel(peli.get(peliActual).getDuracion());
		lblDuracionPeliculaBD.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracionPeliculaBD.setForeground(Color.WHITE);
		lblDuracionPeliculaBD.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblDuracionPeliculaBD.setBounds(717, 230, 40, 34);
		add(lblDuracionPeliculaBD);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos = new JLabel("minutos");
		lblMinutos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos.setForeground(Color.WHITE);
		lblMinutos.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblMinutos.setBounds(755, 231, 66, 34);
		add(lblMinutos);

		// BTN PRINCIPAL -- SELECCIONAR PELICULA
		JButton btnSeleccionarPelicula = new JButton("Seleccionar película");

		btnSeleccionarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(5);
			}
		});
		btnSeleccionarPelicula.setOpaque(true);
		btnSeleccionarPelicula.setForeground(Color.WHITE);
		btnSeleccionarPelicula.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSeleccionarPelicula.setContentAreaFilled(true);
		btnSeleccionarPelicula.setBorderPainted(false);
		btnSeleccionarPelicula.setBackground(new Color(198, 122, 206));
		btnSeleccionarPelicula.setBounds(717, 478, 195, 34);
		add(btnSeleccionarPelicula);

		// LABEL QUE TIENE QUE MOSTRAR LA SINOPSIS DE LA PELICULA
		JTextPane txtSinopsisBD = new JTextPane();
		txtSinopsisBD.setEditable(false);
		txtSinopsisBD.setText(peli.get(peliActual).getSinopsis());
		txtSinopsisBD.setForeground(Color.WHITE);
		txtSinopsisBD.setBackground(Color.decode("#142850"));
		txtSinopsisBD.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtSinopsisBD.setBounds(716, 297, 329, 174);
		add(txtSinopsisBD);

		// BTN ANTERIOR
		// CUANDO NO HAY ANTERIOR PERMANECERÁ CON ESTE ESTILO, QUE ES EL DISABLED, SINO
		// CAMBIA Y ES IGUAL QUE EL BTN SIGUIENTE
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peliActual == 0) {
					JOptionPane.showMessageDialog(null, "No hay más");
//					btnAnterior.setFocusable(false);
//					btnAnterior.setEnabled(false);
				} else {
					peliActual = peliActual - 1;
					lblTituloPelicula.setText(peli.get(peliActual).getNombrePelicula());
					lblDuracionPeliculaBD.setText(peli.get(peliActual).getDuracion());
					txtSinopsisBD.setText(peli.get(peliActual).getSinopsis());
//					btnAnterior.setFocusable(true);
//					btnAnterior.setEnabled(true);
					ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
					lblFotoPortadaPelicula.setIcon(icono);
				}
			}
		});
		btnAnterior.setOpaque(true);
		btnAnterior.setForeground(Color.WHITE);
		btnAnterior.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAnterior.setContentAreaFilled(true);
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBackground(new Color(134, 167, 252));
		btnAnterior.setBounds(371, 612, 125, 34);
		add(btnAnterior);

		// BTN SIGUIENTE
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peliActual == peli.size() - 1) {
					JOptionPane.showMessageDialog(null, "No hay más elementos");
//							btnSiguiente.setFocusable(false);
//							btnSiguiente.setEnabled(false);

				} else {
					peliActual = peliActual + 1;
					lblTituloPelicula.setText(peli.get(peliActual).getNombrePelicula());
					lblDuracionPeliculaBD.setText(peli.get(peliActual).getDuracion());
					txtSinopsisBD.setText(peli.get(peliActual).getSinopsis());
//							btnSiguiente.setFocusable(true);
//							btnSiguiente.setEnabled(true);
					ImageIcon icono = new ImageIcon(urlPeliculas[peliActual]);
					lblFotoPortadaPelicula.setIcon(icono);
				}
			}
		});
		btnSiguiente.setOpaque(true);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSiguiente.setContentAreaFilled(true);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setBackground(new Color(134, 167, 252));
		btnSiguiente.setBounds(570, 612, 125, 34);
		add(btnSiguiente);

		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinopsis.setForeground(Color.WHITE);
		lblSinopsis.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSinopsis.setBounds(717, 265, 96, 34);
		add(lblSinopsis);

	}
}