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


	}
}