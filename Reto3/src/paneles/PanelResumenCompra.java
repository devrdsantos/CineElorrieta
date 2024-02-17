package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
import modelo.Entrada;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;

public class PanelResumenCompra extends JPanel {

	private double precioReal;
	private GestionBD gestionBD = new GestionBD();
	
	public PanelResumenCompra (VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		ArrayList<Entrada> entradas = gestionINF.enseñarEntradas();
		System.out.println(entradas);
		

		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaPelicula = new JLabel("Finaliza tu compra");
		seleccionaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaPelicula.setForeground(Color.decode("#ffffff"));
		seleccionaPelicula.setFont(new Font("Verdana", Font.BOLD, 24));
		seleccionaPelicula.setBounds(285, 18, 584, 40);
		add(seleccionaPelicula);

		// LBL ENTRADAS
		JLabel lblEntradas = new JLabel("ENTRADAS:");
		lblEntradas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntradas.setForeground(Color.WHITE);
		lblEntradas.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEntradas.setBounds(254, 54, 102, 34);
		add(lblEntradas);

		// BTN PRINCIPAL -- FINALIZAR COMPRA
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestionINF.mensajeDeRecibo(v);
				
			}
		});
		btnFinalizarCompra.setOpaque(true);
		btnFinalizarCompra.setForeground(Color.WHITE);
		btnFinalizarCompra.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFinalizarCompra.setContentAreaFilled(true);
		btnFinalizarCompra.setBorderPainted(false);
		btnFinalizarCompra.setBackground(new Color(198, 122, 206));
		btnFinalizarCompra.setBounds(732, 631, 195, 34);
		add(btnFinalizarCompra);

		// BTN CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.cambiarDePanel(3);
			}
		});
		btnCancelar.setOpaque(true);
		btnCancelar.setForeground(new Color(20, 40, 80));
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnCancelar.setContentAreaFilled(true);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(584, 631, 125, 34);
		add(btnCancelar);

		// SEPARADOS
		JSeparator separator = new JSeparator();
		separator.setBounds(251, 91, 724, 22);
		add(separator);

		/*************************************
		 ******* ELEMENTOS DEL PANEL 1 *******
		 ************************************/

		// PANEL 1

		int y = 101;
		for (int i = 0; i < entradas.size(); i++) {
		
		JPanel panel1 = new JPanel();
		panel1.setForeground(new Color(30, 61, 125));
		panel1.setBackground(new Color(30, 61, 125));
		panel1.setBounds(251, y, 724, 84);
		add(panel1);
		panel1.setLayout(null);

			y = y + 80;

		// LBL NOMBRE PELICULA 1
		JLabel lblPeliculaSeleccionada = new JLabel("xxxxxxxx");
		lblPeliculaSeleccionada.setText(entradas.get(i).getNombrePelicula());
		lblPeliculaSeleccionada.setBounds(12, 9, 540, 40);
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(134, 167, 252));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblPeliculaSeleccionada);

		// LBL CINE SELECCIONADO 1
		JLabel lblCineSeleccionado = new JLabel("xxxxxxxxxxxxx");
		lblCineSeleccionado.setText(entradas.get(i).getCine());
		lblCineSeleccionado.setBounds(12, 52, 156, 18);
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado.setForeground(Color.WHITE);
		lblCineSeleccionado.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblCineSeleccionado);

		// LBL FUNCION SELECCIONADA 1
		JLabel lblFuncinSeleccionada = new JLabel("xxxxxxxxxxxx");
		lblFuncinSeleccionada.setText(entradas.get(i).getFecha());
		lblFuncinSeleccionada.setBounds(345, 52, 200, 18);
		lblFuncinSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncinSeleccionada.setForeground(Color.WHITE);
		lblFuncinSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblFuncinSeleccionada);

		// LBL SALA SELECCIONADA 1
		JLabel lblSalaSeleccionada = new JLabel("xxxxxxxxxx");
		lblSalaSeleccionada.setText("Sala " + entradas.get(i).getIdsala());
		lblSalaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaSeleccionada.setForeground(Color.WHITE);
		lblSalaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSalaSeleccionada.setBounds(175, 52, 146, 18);
		panel1.add(lblSalaSeleccionada);

		// LBL CANTIDAD SELECCIONADA 1
		JLabel lblCantidadSeleccionada = new JLabel("xxxxxxxxxx");
		lblCantidadSeleccionada.setText(entradas.get(i).getCantidad()+ "");
		lblCantidadSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadSeleccionada.setForeground(Color.WHITE);
		lblCantidadSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCantidadSeleccionada.setBounds(648, 52, 34, 18);
		panel1.add(lblCantidadSeleccionada);
		
		// SEPARADOR 1
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(169, 60, 8, 10);
		panel1.add(separator_1);
		// SEPARADOR 1.2
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(332, 60, 8, 10);
		panel1.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(526, 60, 8, 10);
		panel1.add(separator_1_1_1);
		
		JLabel lblCantidad = new JLabel("Entradas: ");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCantidad.setBounds(558, 52, 99, 18);
		panel1.add(lblCantidad);
		
		}


		

		// SEPARADOR 1.3
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(254, 619, 724, 22);
		add(separator_2);

		// LBL PRECIO REAL
		JLabel lblPrecioReal = new JLabel("Precio real");
		lblPrecioReal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioReal.setForeground(new Color(255, 255, 255));
		lblPrecioReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrecioReal.setBounds(254, 539, 80, 20);
		add(lblPrecioReal);
		// [¡BD!] LBL VALOR REAL

		precioReal = 0;
		for (int j = 0; j < entradas.size(); j++) {
			precioReal = precioReal + (entradas.get(j).getPrecio() * gestionINF.cantidadTotalDeEntradas());
		}

		JLabel lblValorReal = new JLabel();
		lblValorReal.setText(precioReal + "");
		lblValorReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorReal.setForeground(new Color(255, 255, 255));
		lblValorReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblValorReal.setBounds(907, 539, 52, 20);
		add(lblValorReal);
		// LBL EURO VALOR REAL
		JLabel lblEuroValorReal = new JLabel("€");
		lblEuroValorReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEuroValorReal.setForeground(new Color(255, 255, 255));
		lblEuroValorReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEuroValorReal.setBounds(930, 539, 40, 20);
		add(lblEuroValorReal);

		// LBL DESCUENTO
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescuento.setForeground(new Color(255, 255, 255));
		lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDescuento.setBounds(254, 563, 80, 20);
		add(lblDescuento);
		// LBL [-] DESCUENTO
		JLabel lblMenos = new JLabel("-");
		lblMenos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMenos.setForeground(Color.WHITE);
		lblMenos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMenos.setBounds(881, 563, 32, 20);
		add(lblMenos);
		
		double descuento = gestionINF.descuento(precioReal, gestionINF.cantidadTotalDeEntradas());
		
		// [¡BD!] LBL DESCUENTO TOTAL
		JLabel lblDescuentoTotal = new JLabel();
		lblDescuentoTotal.setText(descuento + "");
		lblDescuentoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoTotal.setForeground(Color.WHITE);
		lblDescuentoTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDescuentoTotal.setBounds(907, 563, 52, 20);
		add(lblDescuentoTotal);
		// LBL EURO DESCUENTO
		JLabel lblDescuentoTotalEuro = new JLabel("€");
		lblDescuentoTotalEuro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoTotalEuro.setForeground(Color.WHITE);
		lblDescuentoTotalEuro.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDescuentoTotalEuro.setBounds(930, 563, 40, 20);
		add(lblDescuentoTotalEuro);

		// LBL TOTAL
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(new Color(198, 122, 206));
		lblTotal.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTotal.setBounds(254, 588, 80, 20);
		add(lblTotal);
		
		// [¡BD!] LBL PRECIO TOTAL
		double precioTotal = precioReal - descuento;
		DecimalFormat df = new DecimalFormat("#.00");
		
		
		JLabel lblTotalValor = new JLabel();
		lblTotalValor.setText(df.format(precioTotal) + "");
		lblTotalValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalValor.setForeground(new Color(198, 122, 206));
		lblTotalValor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTotalValor.setBounds(907, 588, 52, 20);
		add(lblTotalValor);
		// LBL EURO TOTAL
		JLabel lblTotalEuro = new JLabel("€");
		lblTotalEuro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEuro.setForeground(new Color(198, 122, 206));
		lblTotalEuro.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTotalEuro.setBounds(930, 588, 40, 20);
		add(lblTotalEuro);

	}
}