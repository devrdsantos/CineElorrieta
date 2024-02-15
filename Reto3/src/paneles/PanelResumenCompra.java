package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.GestionDeLaInformacion;
import modelo.Entrada;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;

public class PanelResumenCompra extends JPanel {

	public PanelResumenCompra (VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
//		System.out.println("------");
//		ArrayList<Entrada> entrada = gestionINF.almacenarEntradas();
//		System.out.println(entrada);
		
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
				v.cambiarDePanel(5);
			}
		});
		btnFinalizarCompra.setOpaque(true);
		btnFinalizarCompra.setForeground(Color.WHITE);
		btnFinalizarCompra.setFont(new Font("Verdana", Font.BOLD, 14));
		btnFinalizarCompra.setContentAreaFilled(true);
		btnFinalizarCompra.setBorderPainted(false);
		btnFinalizarCompra.setBackground(new Color(198, 122, 206));
		btnFinalizarCompra.setBounds(627, 631, 195, 34);
		add(btnFinalizarCompra);

		// BTN + 1
		JButton btnMas1 = new JButton("+");
		btnMas1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnMas1.setOpaque(true);
		btnMas1.setForeground(Color.WHITE);
		btnMas1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMas1.setContentAreaFilled(true);
		btnMas1.setBorderPainted(false);
		btnMas1.setBackground(new Color(134, 167, 252));
		btnMas1.setBounds(896, 114, 50, 40);
		add(btnMas1);

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
		btnCancelar.setBounds(492, 631, 125, 34);
		add(btnCancelar);

		// SEPARADOS
		JSeparator separator = new JSeparator();
		separator.setBounds(251, 91, 724, 22);
		add(separator);

		/*************************************
		 ******* ELEMENTOS DEL PANEL 1 *******
		 ************************************/
		// LBL CANTIDAD 1
		JLabel lblCantidad1 = new JLabel("1");
		lblCantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad1.setForeground(Color.WHITE);
		lblCantidad1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCantidad1.setBounds(954, 116, 16, 34);
		add(lblCantidad1);

		// BTN - 1
		JButton btnMenos1 = new JButton("-");
		btnMenos1.setOpaque(true);
		btnMenos1.setForeground(Color.WHITE);
		btnMenos1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMenos1.setContentAreaFilled(true);
		btnMenos1.setBorderPainted(false);
		btnMenos1.setBackground(new Color(134, 167, 252));
		btnMenos1.setBounds(837, 114, 50, 40);
		add(btnMenos1);

		// PANEL 1
		JPanel panel1 = new JPanel();
		panel1.setForeground(new Color(30, 61, 125));
		panel1.setBackground(new Color(30, 61, 125));
		panel1.setBounds(251, 101, 560, 84);
		add(panel1);
		panel1.setLayout(null);

		// LBL NOMBRE PELICULA 1
		JLabel lblPeliculaSeleccionada = new JLabel(
				"<html>Nombre película Nombre película Nombre película Nombre película Nombre película Nombre película </html>");
		lblPeliculaSeleccionada.setBounds(12, 9, 540, 40);
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(134, 167, 252));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblPeliculaSeleccionada);

		// LBL CINE SELECCIONADO 1
		JLabel lblCineSeleccionado = new JLabel("Cine seleccionado");
		lblCineSeleccionado.setBounds(12, 52, 156, 18);
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado.setForeground(Color.WHITE);
		lblCineSeleccionado.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblCineSeleccionado);

		// LBL FUNCION SELECCIONADA 1
		JLabel lblFuncinSeleccionada = new JLabel("Función seleccionada");
		lblFuncinSeleccionada.setBounds(345, 52, 200, 18);
		lblFuncinSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncinSeleccionada.setForeground(Color.WHITE);
		lblFuncinSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblFuncinSeleccionada);

		// LBL SALA SELECCIONADA 1
		JLabel lblSalaSeleccionada = new JLabel("Sala seleccionada");
		lblSalaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaSeleccionada.setForeground(Color.WHITE);
		lblSalaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSalaSeleccionada.setBounds(175, 52, 146, 18);
		panel1.add(lblSalaSeleccionada);

		// SEPARADOR 1
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(169, 60, 8, 10);
		panel1.add(separator_1);
		// SEPARADOR 1.2
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(332, 60, 8, 10);
		panel1.add(separator_1_1);
		// SEPARADOR 1.3
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(254, 619, 724, 22);
		add(separator_2);

		// LBL CANTIDAD 1
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCantidad.setBounds(847, 162, 80, 18);
		add(lblCantidad);

		// LBL PRECIO REAL
		JLabel lblPrecioReal = new JLabel("Precio real");
		lblPrecioReal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioReal.setForeground(new Color(255, 255, 255));
		lblPrecioReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrecioReal.setBounds(254, 539, 80, 20);
		add(lblPrecioReal);
		// [¡BD!] LBL VALOR REAL
		JLabel lblValorReal = new JLabel("XXX");
		lblValorReal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorReal.setForeground(new Color(255, 255, 255));
		lblValorReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblValorReal.setBounds(919, 539, 40, 20);
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
		lblMenos.setBounds(895, 564, 32, 20);
		add(lblMenos);
		// [¡BD!] LBL DESCUENTO TOTAL
		JLabel lblDescuentoTotal = new JLabel("XXX");
		lblDescuentoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoTotal.setForeground(Color.WHITE);
		lblDescuentoTotal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDescuentoTotal.setBounds(927, 563, 32, 20);
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
		JLabel lblTotalValor = new JLabel("XXX");
		lblTotalValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalValor.setForeground(new Color(198, 122, 206));
		lblTotalValor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTotalValor.setBounds(919, 588, 40, 20);
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