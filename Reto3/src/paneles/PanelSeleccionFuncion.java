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
import modelo.Cine;
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

public class PanelSeleccionFuncion extends JPanel {

	private String[] urlPeliculas = {};
	private int peliActual;
	private GestionBD gestion = new GestionBD();
	//private Cine cine = new Cine();
	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();
	
	public PanelSeleccionFuncion (VentanaPrincipal v) {
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
		btnSecundario.setBounds(21, 23, 273, 39);
		add(btnSecundario);

		// LBL PELICULAS EN CARTELERA
		JLabel lblFunciones = new JLabel("Funciones para la película");
		lblFunciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunciones.setForeground(new Color(134, 167, 252));
		lblFunciones.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFunciones.setBounds(43, 91, 222, 49);
		add(lblFunciones);

		// (!) LBL CINE SELECCIONADO (TRAE DATOS DE BD!!!!)
		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setText("<html>NOMBRE DE LA PELÍCULA</html>");
		//lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(267, 91, 797, 49);
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
		
		JPanel panelHoraSalaFuncion1 = new JPanel();
		panelHoraSalaFuncion1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(116, 131, 201)));
		panelHoraSalaFuncion1.setBackground(Color.decode("#142850"));
		panelHoraSalaFuncion1.setBounds(593, 238, 188, 126);
		add(panelHoraSalaFuncion1);
		panelHoraSalaFuncion1.setLayout(null);
		JLabel lblTituloPelicula1 = new JLabel("20:30");
		lblTituloPelicula1.setBounds(10, 11, 76, 23);
		panelHoraSalaFuncion1.add(lblTituloPelicula1);
		lblTituloPelicula1.setVerticalAlignment(SwingConstants.TOP);
		lblTituloPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTituloPelicula1.setForeground(new Color(134, 167, 252));
		
				// LABEL DURACIÓN PELICULA
				JLabel lblDuracionPelicula1 = new JLabel("NOMBRE SALA");
				lblDuracionPelicula1.setVerticalAlignment(SwingConstants.TOP);
				lblDuracionPelicula1.setBounds(10, 45, 168, 69);
				panelHoraSalaFuncion1.add(lblDuracionPelicula1);
				lblDuracionPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
				lblDuracionPelicula1.setForeground(Color.WHITE);
				lblDuracionPelicula1.setFont(new Font("Verdana", Font.BOLD, 16));
				
				JPanel panelHoraSalaFuncion1_1 = new JPanel();
				panelHoraSalaFuncion1_1.setLayout(null);
				panelHoraSalaFuncion1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(116, 131, 201)));
				panelHoraSalaFuncion1_1.setBackground(new Color(20, 40, 80));
				panelHoraSalaFuncion1_1.setBounds(806, 238, 188, 126);
				add(panelHoraSalaFuncion1_1);
				
				JLabel lblTituloPelicula1_1 = new JLabel("20:30");
				lblTituloPelicula1_1.setVerticalAlignment(SwingConstants.TOP);
				lblTituloPelicula1_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblTituloPelicula1_1.setForeground(new Color(134, 167, 252));
				lblTituloPelicula1_1.setFont(new Font("Verdana", Font.BOLD, 20));
				lblTituloPelicula1_1.setBounds(10, 11, 76, 23);
				panelHoraSalaFuncion1_1.add(lblTituloPelicula1_1);
				
				JLabel lblDuracionPelicula1_1 = new JLabel("NOMBRE SALA");
				lblDuracionPelicula1_1.setVerticalAlignment(SwingConstants.TOP);
				lblDuracionPelicula1_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblDuracionPelicula1_1.setForeground(Color.WHITE);
				lblDuracionPelicula1_1.setFont(new Font("Verdana", Font.BOLD, 16));
				lblDuracionPelicula1_1.setBounds(10, 45, 168, 69);
				panelHoraSalaFuncion1_1.add(lblDuracionPelicula1_1);
				
				JPanel panelHoraSalaFuncion1_2 = new JPanel();
				panelHoraSalaFuncion1_2.setLayout(null);
				panelHoraSalaFuncion1_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(116, 131, 201)));
				panelHoraSalaFuncion1_2.setBackground(new Color(20, 40, 80));
				panelHoraSalaFuncion1_2.setBounds(595, 390, 188, 126);
				add(panelHoraSalaFuncion1_2);
				
				JLabel lblTituloPelicula1_2 = new JLabel("20:30");
				lblTituloPelicula1_2.setVerticalAlignment(SwingConstants.TOP);
				lblTituloPelicula1_2.setHorizontalAlignment(SwingConstants.LEFT);
				lblTituloPelicula1_2.setForeground(new Color(134, 167, 252));
				lblTituloPelicula1_2.setFont(new Font("Verdana", Font.BOLD, 20));
				lblTituloPelicula1_2.setBounds(10, 11, 76, 23);
				panelHoraSalaFuncion1_2.add(lblTituloPelicula1_2);
				
				JLabel lblDuracionPelicula1_2 = new JLabel("NOMBRE SALA");
				lblDuracionPelicula1_2.setVerticalAlignment(SwingConstants.TOP);
				lblDuracionPelicula1_2.setHorizontalAlignment(SwingConstants.LEFT);
				lblDuracionPelicula1_2.setForeground(Color.WHITE);
				lblDuracionPelicula1_2.setFont(new Font("Verdana", Font.BOLD, 16));
				lblDuracionPelicula1_2.setBounds(10, 45, 168, 69);
				panelHoraSalaFuncion1_2.add(lblDuracionPelicula1_2);
	}
}