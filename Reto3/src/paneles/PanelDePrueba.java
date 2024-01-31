package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Properties;

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
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import java.awt.Choice;
import java.awt.Canvas;
import java.awt.TextArea;
import javax.swing.JToggleButton;

public class PanelDePrueba extends JPanel {

	public PanelDePrueba (VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaPelicula = new JLabel("Selecciona una función");
		seleccionaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaPelicula.setForeground(Color.decode("#ffffff"));
		seleccionaPelicula.setFont(new Font("Verdana", Font.BOLD, 32));
		seleccionaPelicula.setBounds(285, 38, 584, 59);
		add(seleccionaPelicula);

		// BOTÓN SECUNDARIO - - VOLVER ATRÁS
		JButton btnSecundario = new JButton("<html><u>Volver a Seleccionar Película<u><html>");
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
		btnSecundario.setBounds(21, 23, 263, 39);
		add(btnSecundario);

		// LBL PELICULAS EN CARTELERA
		JLabel lblPeliculasEnCartelera = new JLabel("Estas son las funciones disponibles para la película");
		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPeliculasEnCartelera.setBounds(85, 95, 458, 49);
		add(lblPeliculasEnCartelera);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblCineSeleccionado = new JLabel("PELICULA SELECCIONADA");
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado.setForeground(Color.decode("#C67ACE"));
		lblCineSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCineSeleccionado.setBounds(156, 143, 889, 49);
		add(lblCineSeleccionado);

		// LABEL DURACIÓN PELICULA
		JLabel lblDuracionPelicula1 = new JLabel("lunes 29/01");
		lblDuracionPelicula1.setOpaque(true);
		lblDuracionPelicula1.setBackground(new Color(37, 72, 150));
		lblDuracionPelicula1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracionPelicula1.setForeground(Color.WHITE);
		lblDuracionPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDuracionPelicula1.setBounds(48, 190, 144, 34);
		add(lblDuracionPelicula1);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos1 = new JLabel("martes 30/01");
		lblMinutos1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos1.setForeground(Color.WHITE);
		lblMinutos1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMinutos1.setBounds(193, 190, 144, 34);
		add(lblMinutos1);
		
		// BTN PRINCIPAL -- SELECCIONAR PELICULA
		JButton btnSeleccionarPelicula1 = new JButton("Seleccionar película");
		btnSeleccionarPelicula1.setOpaque(true);
		btnSeleccionarPelicula1.setForeground(Color.WHITE);
		btnSeleccionarPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSeleccionarPelicula1.setContentAreaFilled(true);
		btnSeleccionarPelicula1.setBorderPainted(false);
		btnSeleccionarPelicula1.setBackground(new Color(198, 122, 206));
		btnSeleccionarPelicula1.setBounds(364, 675, 195, 34);
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
		
		JLabel lblMircoles = new JLabel("miércoles 30/01");
		lblMircoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMircoles.setForeground(Color.WHITE);
		lblMircoles.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMircoles.setBounds(343, 189, 144, 34);
		add(lblMircoles);
		
		JLabel lblJueves = new JLabel("jueves 30/01");
		lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
		lblJueves.setForeground(Color.WHITE);
		lblJueves.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblJueves.setBounds(499, 192, 144, 34);
		add(lblJueves);
		
		JLabel lblViernes = new JLabel("viernes 30/01");
		lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViernes.setForeground(Color.WHITE);
		lblViernes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblViernes.setBounds(658, 192, 144, 34);
		add(lblViernes);
		
		JLabel lblSbado = new JLabel("sábado 30/01");
		lblSbado.setHorizontalAlignment(SwingConstants.CENTER);
		lblSbado.setForeground(Color.WHITE);
		lblSbado.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSbado.setBounds(818, 192, 144, 34);
		add(lblSbado);
		
		JLabel lblDomingo = new JLabel("domingo 30/01");
		lblDomingo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomingo.setForeground(Color.WHITE);
		lblDomingo.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDomingo.setBounds(986, 193, 144, 34);
		add(lblDomingo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 223, 144, 8);
		add(separator);
		
		JPanel panelBotonFuncion = new JPanel();
		panelBotonFuncion.setBackground(new Color(27, 73, 150));
		panelBotonFuncion.setBounds(48, 269, 168, 165);
		add(panelBotonFuncion);
		panelBotonFuncion.setLayout(null);
		// LABEL TITULO PELICULA
		JLabel lblTituloPelicula1 = new JLabel("19:30");
		lblTituloPelicula1.setBounds(33, 11, 59, 23);
		panelBotonFuncion.add(lblTituloPelicula1);
		lblTituloPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1.setForeground(new Color(168, 118, 222));
		
		JPanel panelBotonFuncion_1 = new JPanel();
		panelBotonFuncion_1.setLayout(null);
		panelBotonFuncion_1.setBackground(new Color(27, 73, 150));
		panelBotonFuncion_1.setBounds(271, 269, 168, 165);
		add(panelBotonFuncion_1);
		
		JLabel lblTituloPelicula1_1 = new JLabel("19:30");
		lblTituloPelicula1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1_1.setForeground(new Color(168, 118, 222));
		lblTituloPelicula1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1_1.setBounds(33, 11, 59, 23);
		panelBotonFuncion_1.add(lblTituloPelicula1_1);
		
		JPanel panelBotonFuncion_2 = new JPanel();
		panelBotonFuncion_2.setLayout(null);
		panelBotonFuncion_2.setBackground(new Color(27, 73, 150));
		panelBotonFuncion_2.setBounds(502, 269, 168, 165);
		add(panelBotonFuncion_2);
		
		JLabel lblTituloPelicula1_2 = new JLabel("19:30");
		lblTituloPelicula1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1_2.setForeground(new Color(168, 118, 222));
		lblTituloPelicula1_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1_2.setBounds(33, 11, 59, 23);
		panelBotonFuncion_2.add(lblTituloPelicula1_2);
		
		JPanel panelBotonFuncion_3 = new JPanel();
		panelBotonFuncion_3.setLayout(null);
		panelBotonFuncion_3.setBackground(new Color(27, 73, 150));
		panelBotonFuncion_3.setBounds(724, 269, 168, 165);
		add(panelBotonFuncion_3);
		
		JLabel lblTituloPelicula1_3 = new JLabel("19:30");
		lblTituloPelicula1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1_3.setForeground(new Color(168, 118, 222));
		lblTituloPelicula1_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1_3.setBounds(33, 11, 59, 23);
		panelBotonFuncion_3.add(lblTituloPelicula1_3);
		
		JPanel panelBotonFuncion_4 = new JPanel();
		panelBotonFuncion_4.setLayout(null);
		panelBotonFuncion_4.setBackground(new Color(27, 73, 150));
		panelBotonFuncion_4.setBounds(962, 269, 168, 165);
		add(panelBotonFuncion_4);
		
		JLabel lblTituloPelicula1_4 = new JLabel("19:30");
		lblTituloPelicula1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1_4.setForeground(new Color(168, 118, 222));
		lblTituloPelicula1_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1_4.setBounds(33, 11, 59, 23);
		panelBotonFuncion_4.add(lblTituloPelicula1_4);
		
		
		
	}
}