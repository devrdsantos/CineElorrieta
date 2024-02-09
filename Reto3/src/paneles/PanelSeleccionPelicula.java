package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionDeLaInformacion;
import modelo.Pelicula;
import vista.VentanaPrincipal;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

public class PanelSeleccionPelicula extends JPanel {

	private int peliActual;

	public PanelSeleccionPelicula(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		ArrayList<Pelicula> peli = gestionINF.almacenarPeliculas();
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
		ImageIcon icono = new ImageIcon("multimedia/"+ peli.get(peliActual).getIdPelicula()+".png");
		lblFotoPortadaPelicula.setIcon(icono);
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
		JLabel lblDuracionPeliculaBD = new JLabel();
		lblDuracionPeliculaBD.setText(peli.get(peliActual).getDuracion());
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
				gestionINF.recogerPeliculaSeleccionada(peli.get(peliActual).getNombrePelicula());
				gestionINF.recogerIdPeliculaSeleccionada(peli.get(peliActual).getIdPelicula());
				
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
					JOptionPane.showMessageDialog(null, "No hay más elementos");
//					btnAnterior.setFocusable(false);
//					btnAnterior.setEnabled(false);
				} else {
					peliActual = peliActual - 1;
					lblTituloPelicula.setText(peli.get(peliActual).getNombrePelicula());
					lblDuracionPeliculaBD.setText(peli.get(peliActual).getDuracion());
					txtSinopsisBD.setText(peli.get(peliActual).getSinopsis());
//					btnAnterior.setFocusable(true);
//					btnAnterior.setEnabled(true);
					ImageIcon icono = new ImageIcon("multimedia/"+ peli.get(peliActual).getIdPelicula()+".png");
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
				} else {
					peliActual = peliActual + 1;
					lblTituloPelicula.setText(peli.get(peliActual).getNombrePelicula());
					lblDuracionPeliculaBD.setText(peli.get(peliActual).getDuracion());
					txtSinopsisBD.setText(peli.get(peliActual).getSinopsis());
					ImageIcon icono = new ImageIcon("multimedia/"+ peli.get(peliActual).getIdPelicula()+".png");
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