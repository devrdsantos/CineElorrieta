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
		JLabel seleccionaFuncion = new JLabel("Selecciona una función");
		seleccionaFuncion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaFuncion.setForeground(Color.decode("#ffffff"));
		seleccionaFuncion.setFont(new Font("Verdana", Font.BOLD, 32));
		seleccionaFuncion.setBounds(285, 38, 584, 59);
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

		// LBL PELICULAS EN CARTELERA
		JLabel lblFunciones = new JLabel("Funciones para la película");
		lblFunciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunciones.setForeground(new Color(134, 167, 252));
		lblFunciones.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFunciones.setBounds(43, 107, 222, 49);
		add(lblFunciones);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setText("<html>NOMBRE DE LA PELÍCULA</html>");
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(267, 107, 797, 49);
		add(lblPeliculaSeleccionada);

		/* --- GRUPO --- 1 */
		// LABEL TITULO PELICULA
		peliActual = 0;

		JDateChooser dateChooserDia = new JDateChooser();
		dateChooserDia.getCalendarButton().setFont(new Font("Verdana", Font.PLAIN, 14));
		dateChooserDia.setBounds(327, 192, 142, 28);
		add(dateChooserDia);

		JLabel lblEligeDia = new JLabel("Elige un día:");
		lblEligeDia.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEligeDia.setBounds(210, 190, 115, 28);
		lblEligeDia.setForeground(Color.decode("#FFFFFF"));
		add(lblEligeDia);

		JLabel lblEligeUnaFuncin = new JLabel("Elige una función:");
		lblEligeUnaFuncin.setForeground(Color.WHITE);
		lblEligeUnaFuncin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEligeUnaFuncin.setBounds(595, 190, 171, 28);
		add(lblEligeUnaFuncin);

		/**********************************************************
		 **************** PANELES DE FUNCIONES ********************
		 *********************************************************/

		// 1ª PANEL --------------------------------------------
		JPanel panelHoraSalaFuncion1 = new JPanel();
		panelHoraSalaFuncion1.addMouseListener(new MouseAdapter() {

			// Efecto Selected
			@Override
			public void mouseClicked(MouseEvent e) {
				panelHoraSalaFuncion1.setBackground(new Color(30, 61, 125));
				if (panelHoraSalaFuncion1.getBackground() == new Color(30, 61, 125)) {
					Funcion funcion1 = new Funcion();
				}
				// if(addMouseListener(panelHoraSalaFuncion1)){

				// }

				/*
				 * [¡!] Faltan 2 funciones: 1. Si el panel se selecciona y se da a continuar
				 * entonces se deben almacenar los datos dentro del panel en algún lado 2. Si se
				 * selecciona un panel, al seleccionar otro, el seleccionado se deseleccionará
				 * (solo se puede seleccionar uno)
				 */

			}
		});
		panelHoraSalaFuncion1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(116, 131, 201)));
		panelHoraSalaFuncion1.setBackground(Color.decode("#142850"));
		panelHoraSalaFuncion1.setBounds(593, 238, 188, 80);
		add(panelHoraSalaFuncion1);
		panelHoraSalaFuncion1.setLayout(null);

		// 1ª PANEL - LBL HORA PELICULA
		JLabel lblHoraPelicula1 = new JLabel("20:30");
		lblHoraPelicula1.setBounds(10, 11, 76, 23);
		panelHoraSalaFuncion1.add(lblHoraPelicula1);
		lblHoraPelicula1.setVerticalAlignment(SwingConstants.TOP);
		lblHoraPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoraPelicula1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblHoraPelicula1.setForeground(new Color(134, 167, 252));
		// 1ª PANEL - LBL SALA PELICULA
		JLabel lblSalaPelicula1 = new JLabel("NOMBRE SALA");
		lblSalaPelicula1.setVerticalAlignment(SwingConstants.TOP);
		lblSalaPelicula1.setBounds(10, 34, 168, 36);
		panelHoraSalaFuncion1.add(lblSalaPelicula1);
		lblSalaPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaPelicula1.setForeground(Color.WHITE);
		lblSalaPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
		
		// Almacenar los valores de los JLabel
		String valorLabel1 = lblHoraPelicula1.getText();
		String valorLabel2 = lblSalaPelicula1.getText();

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


	}
}