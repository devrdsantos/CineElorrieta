package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;

public class PanelResumenCompra extends JPanel {

	public PanelResumenCompra (VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel seleccionaPelicula = new JLabel("Finaliza tu compra");
		seleccionaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		seleccionaPelicula.setForeground(Color.decode("#ffffff"));
		seleccionaPelicula.setFont(new Font("Verdana", Font.BOLD, 32));
		seleccionaPelicula.setBounds(285, 38, 584, 59);
		add(seleccionaPelicula);

		JButton btnSiguiente = new JButton("+");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setOpaque(true);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSiguiente.setContentAreaFilled(true);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setBackground(new Color(134, 167, 252));
		btnSiguiente.setBounds(951, 140, 50, 40);
		add(btnSiguiente);

		// LBL PELICULAS EN CARTELERA
		JLabel lblPeliculasEnCartelera = new JLabel("Cine elegido:");
		lblPeliculasEnCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeliculasEnCartelera.setForeground(new Color(134, 167, 252));
		lblPeliculasEnCartelera.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPeliculasEnCartelera.setBounds(73, 396, 273, 49);
		add(lblPeliculasEnCartelera);

		/* --- GRUPO --- 1 */
		// LABEL TITULO PELICULA
		JLabel lblTituloPelicula1 = new JLabel("<html>Nombre de una película de ciencia ficción</html>");
		lblTituloPelicula1.setVerticalAlignment(SwingConstants.TOP);
		lblTituloPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPelicula1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTituloPelicula1.setBounds(370, 386, 321, 59);
		lblTituloPelicula1.setForeground(Color.decode("#86A7FC"));
		add(lblTituloPelicula1);

		// LABEL DURACIÓN PELICULA
		JLabel lblDuracionPelicula1 = new JLabel("Duración: ");
		lblDuracionPelicula1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuracionPelicula1.setForeground(Color.WHITE);
		lblDuracionPelicula1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDuracionPelicula1.setBounds(370, 439, 96, 34);
		add(lblDuracionPelicula1);

		// LABEL DURACIÓN PELICULA - MINUTOS
		JLabel lblMinutos1 = new JLabel("ARTICULOS:");
		lblMinutos1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos1.setForeground(Color.WHITE);
		lblMinutos1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblMinutos1.setBounds(142, 96, 102, 34);
		add(lblMinutos1);

		// BTN PRINCIPAL -- SELECCIONAR PELICULA
		JButton btnSeleccionarPelicula1 = new JButton("Finalizar compra");
		btnSeleccionarPelicula1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(5);
			}
		});
		btnSeleccionarPelicula1.setOpaque(true);
		btnSeleccionarPelicula1.setForeground(Color.WHITE);
		btnSeleccionarPelicula1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSeleccionarPelicula1.setContentAreaFilled(true);
		btnSeleccionarPelicula1.setBorderPainted(false);
		btnSeleccionarPelicula1.setBackground(new Color(198, 122, 206));
		btnSeleccionarPelicula1.setBounds(371, 549, 195, 34);
		add(btnSeleccionarPelicula1);

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
		btnCancelar.setBounds(236, 549, 125, 34);
		add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(142, 133, 920, 22);
		add(separator);
		
		JButton btnSiguiente_1 = new JButton("-");
		btnSiguiente_1.setOpaque(true);
		btnSiguiente_1.setForeground(Color.WHITE);
		btnSiguiente_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSiguiente_1.setContentAreaFilled(true);
		btnSiguiente_1.setBorderPainted(false);
		btnSiguiente_1.setBackground(new Color(134, 167, 252));
		btnSiguiente_1.setBounds(1011, 140, 50, 40);
		add(btnSiguiente_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(30, 61, 125));
		panel.setBackground(new Color(30, 61, 125));
		panel.setBounds(142, 143, 560, 120);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPeliculaSeleccionada = new JLabel("<html>Nombre película Nombre película Nombre película Nombre película Nombre película Nombre película </html>");
		lblPeliculaSeleccionada.setBounds(12, 12, 685, 18);
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(134, 167, 252));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(lblPeliculaSeleccionada);
		
		JLabel lblCineSeleccionado = new JLabel("Cine seleccionado");
		lblCineSeleccionado.setBounds(12, 28, 123, 18);
		lblCineSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblCineSeleccionado.setForeground(Color.WHITE);
		lblCineSeleccionado.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(lblCineSeleccionado);
		
		JLabel lblFuncinSeleccionada = new JLabel("Función seleccionada");
		lblFuncinSeleccionada.setBounds(12, 42, 146, 18);
		lblFuncinSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuncinSeleccionada.setForeground(Color.WHITE);
		lblFuncinSeleccionada.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(lblFuncinSeleccionada);

	}
}