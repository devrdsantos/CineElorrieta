package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionDeLaInformacion;
import modelo.Funcion;
import vista.VentanaPrincipal;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;



import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class PanelSeleccionFuncion extends JPanel {
	
	private int cantidad = 0;
	
	public PanelSeleccionFuncion(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		ArrayList<Funcion> funciones = gestionINF.almacenarFunciones(gestionINF.pasarIdPeliculaSeleccionada(), gestionINF.pasarNombreCine());
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
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

		// (!) LBL PELICULA SELECCIONADA (TRAE DATOS DE BD!!!!)

		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setText(gestionINF.pasarNombrePelicula());
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(267, 158, 797, 49);
		add(lblPeliculaSeleccionada);

		// CALENDARIO

		JDateChooser dateChooserDia = new JDateChooser();
		dateChooserDia.getCalendarButton().setFont(new Font("Verdana", Font.PLAIN, 14));
		dateChooserDia.setBounds(280, 301, 142, 28);

		// Para que coja la fecha actual
		/*
		 * dateChooserDia.setMinSelectableDate(new Date());
		 */
		//dateChooserDia.setMinSelectableDate(new Date());

		// Para darle un maximo y un minimo de fechas elegibles
		/*
		 * try { String date = "12 Feb 2024"; Date date2 = new
		 * SimpleDateFormat("dd MMM yyyy").parse(date);
		 * dateChooserDia.setMinSelectableDate(date2);
		 * dateChooserDia.setMaxSelectableDate(date2); } catch (Exception e) {
		 * System.out.println(e); }
		 */
		add(dateChooserDia);
		try {
			String date = "27 Feb 2024";
			Date fechaCine = new SimpleDateFormat("dd MMM yyyy").parse(date);
			dateChooserDia.setMinSelectableDate(fechaCine);
		} catch (Exception e) {
			// TODO: handle exception
		}

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

		// [!] COMBOBOX - SELECCIÓN FUNCIÓN - TRAE DATOS DE BD --> SALA Y HORA
		JComboBox<String> comboBoxFunciones = new JComboBox<String>();
		comboBoxFunciones.setBounds(545, 301, 274, 28);
		add(comboBoxFunciones);

		// PANEL CONTENEDOR DEL PRECIO DE LA FUNCIÓN
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 61, 125));
		panel.setBounds(419, 423, 400, 92);
		add(panel);
		panel.setLayout(null);

		// LBL PRECIO DE FUNCIÒN ELEGIDA
		JLabel lblPrecioFuncion = new JLabel("La función elegida tiene un precio de");
		lblPrecioFuncion.setBounds(45, 11, 305, 21);
		lblPrecioFuncion.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPrecioFuncion.setForeground(new Color(255, 255, 255));
		panel.add(lblPrecioFuncion);

		// [!] LBL PRECIO TRAÍDO DE BD
		JLabel lblPrecioBD = new JLabel();
		lblPrecioBD.setText("0");
		lblPrecioBD.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBD.setForeground(Color.WHITE);
		lblPrecioBD.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPrecioBD.setBounds(164, 35, 42, 21);
		panel.add(lblPrecioBD);

		// LBL EUROS
		JLabel lblEuros = new JLabel("€");
		lblEuros.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuros.setForeground(Color.WHITE);
		lblEuros.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEuros.setBounds(207, 35, 12, 21);
		panel.add(lblEuros);

		// LBL POR PERSONA
		JLabel lblPorPersona = new JLabel("Por persona");
		lblPorPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorPersona.setForeground(Color.WHITE);
		lblPorPersona.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPorPersona.setBounds(123, 57, 120, 21);
		panel.add(lblPorPersona);

		// BTN Seleccionar fecha
		JButton btnFecha = new JButton("Seleccionar");
		btnFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					comboBoxFunciones.removeAllItems();
					for (int i = 0; i < funciones.size(); i++) {
						if (formato.format(dateChooserDia.getDate()).equals(funciones.get(i).getFechafuncion())) {
							comboBoxFunciones.addItem(
									funciones.get(i).getHorafuncion() + " - Sala " + funciones.get(i).getIdsala());
							lblPrecioBD.setText(funciones.get(i).getPrecio() + "");
						} 
					}
					if (comboBoxFunciones.getItemCount() == 0 ) {
						JOptionPane.showMessageDialog(null, "No hay sesiones este día");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Seleccione una fecha");
				}
			}
		});
		btnFecha.setFont(new Font("Verdana", Font.BOLD, 16));
		btnFecha.setOpaque(true);
		btnFecha.setContentAreaFilled(true);
		btnFecha.setForeground(Color.decode("#FFFFFF"));
		btnFecha.setBorderPainted(false);
		btnFecha.setBackground(Color.decode("#C67ACE"));
		btnFecha.setBounds(280, 341, 142, 28);
		add(btnFecha);
		
		JLabel lblEligeUnaCantidad = new JLabel("Elige una cantidad:");
		lblEligeUnaCantidad.setForeground(Color.WHITE);
		lblEligeUnaCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEligeUnaCantidad.setBounds(870, 262, 186, 28);
		add(lblEligeUnaCantidad);
		
		JLabel lblCantidad = new JLabel("1");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCantidad.setBounds(1050, 262, 27, 28);
		add(lblCantidad);
		
		cantidad = 1;
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cantidad > 1) {
					cantidad--;
					lblCantidad.setText(cantidad + "");
				} else {
					JOptionPane.showMessageDialog(null, "Cantidad minima 1");
				}
			}
		});
		btnMenos.setBounds(914, 306, 41, 23);
		add(btnMenos);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cantidad < 8) {
					cantidad++;
					lblCantidad.setText(cantidad + "");
				} else {
					JOptionPane.showMessageDialog(null, "Cantidad maxima");
				}
			}
		});
		btnMas.setBounds(975, 306, 41, 23);
		add(btnMas);
		
		// BTN Principal
				JButton btnPrincipal = new JButton("Siguiente");
				btnPrincipal.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							String funcionSeleccionada = (String) comboBoxFunciones.getSelectedItem();
							gestionINF.separarFuncionSeleccionada(funcionSeleccionada);
							gestionINF.convertirADouble(lblPrecioBD.getText());
							gestionINF.recogerFechaSeleccionada(formato.format(dateChooserDia.getDate()));
							gestionINF.convertirAIntCantidad(lblCantidad.getText());
							v.cambiarDePanel(6);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "No has seleccionado nada");
						}
						
					}
				});
				btnPrincipal.setFont(new Font("Verdana", Font.BOLD, 16));
				btnPrincipal.setOpaque(true);
				btnPrincipal.setContentAreaFilled(true);
				btnPrincipal.setForeground(Color.decode("#FFFFFF"));
				btnPrincipal.setBorderPainted(false);
				btnPrincipal.setBackground(Color.decode("#C67ACE"));
				btnPrincipal.setBounds(490, 587, 150, 39);
				add(btnPrincipal);
				
				
	}
}