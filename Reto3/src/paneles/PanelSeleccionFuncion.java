package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
import modelo.Pelicula;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class PanelSeleccionFuncion extends JPanel {

	private String[] urlPeliculas = {};
	private int peliActual;
	private GestionBD gestion = new GestionBD();
	// private Cine cine = new Cine();
	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();

	public PanelSeleccionFuncion(VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaFuncion = new JLabel("Selecciona una función");
		seleccionaFuncion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaFuncion.setForeground(Color.decode("#ffffff"));
		seleccionaFuncion.setFont(new Font("Verdana", Font.BOLD, 32));
		seleccionaFuncion.setBounds(285, 71, 584, 59);
		add(seleccionaFuncion);

		// BOTÓN SECUNDARIO - - VOLVER ATRÁS
		JButton btnSecundario = new JButton("<html><u>Volver a Seleccionar Película<u><html>");
		btnSecundario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(4);
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
		btnSecundario.setBounds(21, 23, 273, 39);
		add(btnSecundario);

		// LBL FUNCIONES
		JLabel lblFunciones = new JLabel("Funciones para la película");
		lblFunciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunciones.setForeground(new Color(134, 167, 252));
		lblFunciones.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFunciones.setBounds(43, 158, 222, 49);
		add(lblFunciones);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setText("<html>NOMBRE DE LA PELÍCULA</html>");
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(267, 158, 797, 49);
		add(lblPeliculaSeleccionada);

		peliActual = 0;

		// CALENDARIO
		JDateChooser dateChooserDia = new JDateChooser();
		dateChooserDia.getCalendarButton().setFont(new Font("Verdana", Font.PLAIN, 14));
		dateChooserDia.setBounds(280, 301, 142, 28);
		add(dateChooserDia);

		// LBL ELIGE UN DÌA
		JLabel lblEligeDia = new JLabel("Elige un día:");
		lblEligeDia.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEligeDia.setBounds(280, 262, 115, 28);
		lblEligeDia.setForeground(Color.decode("#FFFFFF"));
		add(lblEligeDia);

		// LBL ELIGE UNA FUNCIÓN
		JLabel lblEligeUnaFuncin = new JLabel("Elige una función:");
		lblEligeUnaFuncin.setForeground(Color.WHITE);
		lblEligeUnaFuncin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEligeUnaFuncin.setBounds(545, 262, 171, 28);
		add(lblEligeUnaFuncin);

		// BTN Principal
		JButton btnPrincipal = new JButton("Siguiente");
		btnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(6);
			}
		});
		btnPrincipal.setFont(new Font("Verdana", Font.BOLD, 16));
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrincipal.setOpaque(true);
		btnPrincipal.setContentAreaFilled(true);
		btnPrincipal.setForeground(Color.decode("#FFFFFF"));
		btnPrincipal.setBorderPainted(false);
		btnPrincipal.setBackground(Color.decode("#C67ACE"));
		btnPrincipal.setBounds(490, 587, 150, 39);
		add(btnPrincipal);

		// [!] COMBOBOX - SELECCIÓN FUNCIÓN - TRAE DATOS DE BD --> SALA Y HORA
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(545, 301, 274, 28);
		add(comboBox);

		// PANEL CONTENEDOR DEL PRECIO DE LA FUNCIÓN
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 61, 125));
		panel.setBounds(359, 425, 400, 92);
		add(panel);
		panel.setLayout(null);

		// LBL PRECIO DE FUNCIÒN ELEGIDA
		JLabel lblPrecioFuncion = new JLabel("La función elegida tiene un precio de");
		lblPrecioFuncion.setBounds(45, 11, 305, 21);
		lblPrecioFuncion.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPrecioFuncion.setForeground(new Color(255, 255, 255));
		panel.add(lblPrecioFuncion);

		// [!] LBL PRECIO TRAÍDO DE BD
		JLabel lblPrecioBD = new JLabel("20");
		lblPrecioBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBD.setForeground(Color.WHITE);
		lblPrecioBD.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPrecioBD.setBounds(164, 35, 32, 21);
		panel.add(lblPrecioBD);

		// LBL EUROS
		JLabel lblEuros = new JLabel("€");
		lblEuros.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuros.setForeground(Color.WHITE);
		lblEuros.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEuros.setBounds(197, 35, 12, 21);
		panel.add(lblEuros);

		// LBL POR PERSONA
		JLabel lblPorPersona = new JLabel("Por persona");
		lblPorPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorPersona.setForeground(Color.WHITE);
		lblPorPersona.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPorPersona.setBounds(123, 57, 120, 21);
		panel.add(lblPorPersona);

	}
}