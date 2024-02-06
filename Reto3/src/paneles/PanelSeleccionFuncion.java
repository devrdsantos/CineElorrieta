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
import javax.swing.JSeparator;
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
		JButton btnVolver = new JButton("<html><u>Volver a Seleccionar Película<u><html>");
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
		btnVolver.setBounds(21, 23, 263, 39);
		add(btnVolver);


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

		JLabel lblCineSeleccionado = new JLabel("PELICULA SELECCIONADA");
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado.setForeground(Color.decode("#C67ACE"));
		lblCineSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCineSeleccionado.setBounds(156, 143, 889, 49);
		add(lblCineSeleccionado);

		// LABEL DURACIÓN PELICULA
		JLabel lblDuracionPelicula = new JLabel("lunes 29/01");
		lblDuracionPelicula.setOpaque(true);
		lblDuracionPelicula.setBackground(new Color(37, 72, 150));
		lblDuracionPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracionPelicula.setForeground(Color.WHITE);
		lblDuracionPelicula.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDuracionPelicula.setBounds(48, 190, 144, 34);
		add(lblDuracionPelicula);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos = new JLabel("martes 30/01");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setForeground(Color.WHITE);
		lblMinutos.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMinutos.setBounds(193, 190, 144, 34);
		add(lblMinutos);

		/* --- GRUPO --- 1 */
		// BTN PRINCIPAL -- SELECCIONAR PELICULA
		JButton btnSeleccionarPelicula = new JButton("Seleccionar película");
		btnSeleccionarPelicula.setOpaque(true);
		btnSeleccionarPelicula.setForeground(Color.WHITE);
		btnSeleccionarPelicula.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSeleccionarPelicula.setContentAreaFilled(true);
		btnSeleccionarPelicula.setBorderPainted(false);
		btnSeleccionarPelicula.setBackground(new Color(198, 122, 206));
		btnSeleccionarPelicula.setBounds(364, 675, 195, 34);
		add(btnSeleccionarPelicula);
		
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
		
		JLabel lblMiercoles = new JLabel("miércoles 30/01");
		lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiercoles.setForeground(Color.WHITE);
		lblMiercoles.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMiercoles.setBounds(343, 189, 144, 34);
		add(lblMiercoles);
		
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