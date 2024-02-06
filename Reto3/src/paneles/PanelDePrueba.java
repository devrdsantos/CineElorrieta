package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controlador.GestionBD;
import modelo.Cine;
import modelo.Funcion;
import modelo.Pelicula;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import com.toedter.calendar.JDayChooser;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.ScrollPane;
import java.awt.List;
import java.awt.TextField;
import javax.swing.JMenu;
import java.awt.Panel;
import javax.swing.JSeparator;

public class PanelDePrueba extends JPanel {

	private String[] urlPeliculas = {};
	private int peliActual;
	private GestionBD gestion = new GestionBD();
	// private Cine cine = new Cine();
	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();

	public PanelDePrueba(VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaFuncion = new JLabel("<html>A continuación se muestra la selección que has realizado</html>");
		seleccionaFuncion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaFuncion.setForeground(Color.decode("#ffffff"));
		seleccionaFuncion.setFont(new Font("Verdana", Font.BOLD, 20));
		seleccionaFuncion.setBounds(203, 119, 680, 49);
		add(seleccionaFuncion);


		// BOTÓN SECUNDARIO - - VOLVER ATRÁS
		JButton btnVolver = new JButton("<html><u>Volver a Seleccionar Cine<u><html>");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnVolver.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolver.setOpaque(true);
		btnVolver.setContentAreaFilled(true);
		btnVolver.setForeground(Color.decode("#C67ACE"));
		btnVolver.setBorderPainted(false);
		btnVolver.setBackground(Color.decode("#142850"));
		btnVolver.setBounds(21, 23, 254, 39);
		add(btnVolver);

		// LBL PELICULAS EN CARTELERA
		JLabel lblPeliculasEnCartelera = new JLabel("Películas en cartelera para:");
		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPeliculasEnCartelera.setBounds(43, 91, 273, 49);
		add(lblPeliculasEnCartelera);

		// LBL FUNCIONES
		JLabel lblFunciones = new JLabel("Película:");
		lblFunciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunciones.setForeground(new Color(134, 167, 252));
		lblFunciones.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFunciones.setBounds(159, 212, 75, 49);
		add(lblFunciones);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setVerticalAlignment(SwingConstants.TOP);
		lblPeliculaSeleccionada.setText("<html>NOMBRE DE LA PELÍCULA</html>");
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(235, 226, 797, 49);
		add(lblPeliculaSeleccionada);

	
		peliActual = 0;
		
		JLabel lblEnUnosSegundos = new JLabel("En unos segundos serás redirigido al inicio...");
		lblEnUnosSegundos.setForeground(Color.WHITE);
		lblEnUnosSegundos.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblEnUnosSegundos.setBounds(359, 481, 400, 21);
		add(lblEnUnosSegundos);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(134, 167, 255));
		separator.setBounds(167, 450, 800, 8);
		add(separator);
		
		JLabel lblCine = new JLabel("Cine:");
		lblCine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCine.setForeground(new Color(134, 167, 252));
		lblCine.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCine.setBounds(171, 288, 56, 49);
		add(lblCine);
		
		JLabel lblNombreDelCine = new JLabel();
		lblNombreDelCine.setText("NOMBRE DEL CINE");
		lblNombreDelCine.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelCine.setForeground(new Color(211, 213, 248));
		lblNombreDelCine.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombreDelCine.setBounds(235, 289, 797, 49);
		add(lblNombreDelCine);
		
		JLabel lblFuncin = new JLabel("Función:");
		lblFuncin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncin.setForeground(new Color(134, 167, 252));
		lblFuncin.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFuncin.setBounds(156, 362, 72, 49);
		add(lblFuncin);
		
		JLabel lblSalaYHora = new JLabel();
		lblSalaYHora.setText("SALA Y HORA");
		lblSalaYHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaYHora.setForeground(new Color(211, 213, 248));
		lblSalaYHora.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSalaYHora.setBounds(235, 363, 797, 49);
		add(lblSalaYHora);


	}
}