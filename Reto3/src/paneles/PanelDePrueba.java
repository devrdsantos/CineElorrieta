package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionDeLaInformacion;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;

public class PanelDePrueba extends JPanel {

	public PanelDePrueba(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		addMouseListener(new MouseAdapter() {
			
            @Override
            public void mouseEntered(MouseEvent e) {
            	try {
					TimeUnit.SECONDS.sleep(6);
					v.cambiarDePanel(3);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
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

		// LABEL DURACIÓN PELICULA
		JLabel lblCantidad1 = new JLabel("1");
		lblCantidad1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad1.setForeground(Color.WHITE);
		lblCantidad1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCantidad1.setBounds(954, 116, 16, 34);
		add(lblCantidad1);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos1 = new JLabel("ENTRADAS:");
		lblMinutos1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos1.setForeground(Color.WHITE);
		lblMinutos1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMinutos1.setBounds(254, 54, 102, 34);
		add(lblMinutos1);

		// BTN PRINCIPAL -- SELECCIONAR PELICULA
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

		// BTN SIGUIENTE
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(251, 91, 724, 22);
		add(separator);
		
		JButton btnMenos1 = new JButton("-");
		btnMenos1.setOpaque(true);
		btnMenos1.setForeground(Color.WHITE);
		btnMenos1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMenos1.setContentAreaFilled(true);
		btnMenos1.setBorderPainted(false);
		btnMenos1.setBackground(new Color(134, 167, 252));
		btnMenos1.setBounds(837, 114, 50, 40);
		add(btnMenos1);
		
		JPanel panel1 = new JPanel();
		panel1.setForeground(new Color(30, 61, 125));
		panel1.setBackground(new Color(30, 61, 125));
		panel1.setBounds(251, 101, 560, 84);
		add(panel1);
		panel1.setLayout(null);
		
		JLabel lblPeliculaSeleccionada = new JLabel("<html>Nombre película Nombre película Nombre película Nombre película Nombre película Nombre película </html>");
		lblPeliculaSeleccionada.setBounds(12, 9, 540, 40);
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(134, 167, 252));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblPeliculaSeleccionada);
		
		JLabel lblCineSeleccionado = new JLabel("Cine seleccionado");
		lblCineSeleccionado.setBounds(12, 52, 156, 18);
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado.setForeground(Color.WHITE);
		lblCineSeleccionado.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblCineSeleccionado);
		
		JLabel lblFuncinSeleccionada = new JLabel("Función seleccionada");
		lblFuncinSeleccionada.setBounds(345, 52, 200, 18);
		lblFuncinSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncinSeleccionada.setForeground(Color.WHITE);
		lblFuncinSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel1.add(lblFuncinSeleccionada);
		
		JLabel lblSalaSeleccionada = new JLabel("Sala seleccionada");
		lblSalaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaSeleccionada.setForeground(Color.WHITE);
		lblSalaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSalaSeleccionada.setBounds(175, 52, 146, 18);
		panel1.add(lblSalaSeleccionada);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(169, 60, 8, 10);
		panel1.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(332, 60, 8, 10);
		panel1.add(separator_1_1);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCantidad.setBounds(847, 162, 80, 18);
		add(lblCantidad);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(254, 619, 724, 22);
		add(separator_2);
		
		JLabel lblPrecioReal = new JLabel("Precio real");
		lblPrecioReal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioReal.setForeground(new Color(255, 255, 255));
		lblPrecioReal.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPrecioReal.setBounds(254, 539, 80, 20);
		add(lblPrecioReal);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescuento.setForeground(new Color(255, 255, 255));
		lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDescuento.setBounds(254, 563, 80, 20);
		add(lblDescuento);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(new Color(198, 122, 206));
		lblTotal.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTotal.setBounds(254, 588, 80, 20);
		add(lblTotal);
		
		JLabel lblXxx = new JLabel("XXX");
		lblXxx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx.setForeground(new Color(255, 255, 255));
		lblXxx.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx.setBounds(919, 539, 40, 20);
		add(lblXxx);
		
		JLabel lblXxx_1 = new JLabel("€");
		lblXxx_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_1.setForeground(new Color(255, 255, 255));
		lblXxx_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx_1.setBounds(930, 539, 40, 20);
		add(lblXxx_1);
		
		JLabel lblXxx_2 = new JLabel("XXX");
		lblXxx_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_2.setForeground(Color.WHITE);
		lblXxx_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx_2.setBounds(927, 563, 32, 20);
		add(lblXxx_2);
		
		JLabel lblXxx_1_1 = new JLabel("€");
		lblXxx_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_1_1.setForeground(Color.WHITE);
		lblXxx_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx_1_1.setBounds(930, 563, 40, 20);
		add(lblXxx_1_1);
		
		JLabel lblXxx_2_1 = new JLabel("-");
		lblXxx_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_2_1.setForeground(Color.WHITE);
		lblXxx_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblXxx_2_1.setBounds(895, 564, 32, 20);
		add(lblXxx_2_1);
		
		JLabel lblXxx_3 = new JLabel("XXX");
		lblXxx_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_3.setForeground(new Color(198, 122, 206));
		lblXxx_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx_3.setBounds(919, 588, 40, 20);
		add(lblXxx_3);
		
		JLabel lblXxx_1_2 = new JLabel("€");
		lblXxx_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXxx_1_2.setForeground(new Color(198, 122, 206));
		lblXxx_1_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblXxx_1_2.setBounds(930, 588, 40, 20);
		add(lblXxx_1_2);
		
		JPanel panel1_1 = new JPanel();
		panel1_1.setLayout(null);
		panel1_1.setForeground(new Color(30, 61, 125));
		panel1_1.setBackground(new Color(30, 61, 125));
		panel1_1.setBounds(251, 198, 560, 84);
		add(panel1_1);
		
		JLabel lblPeliculaSeleccionada_1 = new JLabel("<html>Nombre película Nombre película Nombre película Nombre película Nombre película Nombre película </html>");
		lblPeliculaSeleccionada_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada_1.setForeground(new Color(134, 167, 252));
		lblPeliculaSeleccionada_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPeliculaSeleccionada_1.setBounds(12, 9, 540, 40);
		panel1_1.add(lblPeliculaSeleccionada_1);
		
		JLabel lblCineSeleccionado_1 = new JLabel("Cine seleccionado");
		lblCineSeleccionado_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCineSeleccionado_1.setForeground(Color.WHITE);
		lblCineSeleccionado_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCineSeleccionado_1.setBounds(12, 52, 156, 18);
		panel1_1.add(lblCineSeleccionado_1);
		
		JLabel lblFuncinSeleccionada_1 = new JLabel("Función seleccionada");
		lblFuncinSeleccionada_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncinSeleccionada_1.setForeground(Color.WHITE);
		lblFuncinSeleccionada_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblFuncinSeleccionada_1.setBounds(345, 52, 200, 18);
		panel1_1.add(lblFuncinSeleccionada_1);
		
		JLabel lblSalaSeleccionada_1 = new JLabel("Sala seleccionada");
		lblSalaSeleccionada_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaSeleccionada_1.setForeground(Color.WHITE);
		lblSalaSeleccionada_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSalaSeleccionada_1.setBounds(175, 52, 146, 18);
		panel1_1.add(lblSalaSeleccionada_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(169, 60, 8, 10);
		panel1_1.add(separator_1_2);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(332, 60, 8, 10);
		panel1_1.add(separator_1_1_1);

	}
}