package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionDeLaInformacion;
import vista.VentanaPrincipal;
import javax.swing.JSeparator;

public class PanelFuncionEscogida extends JPanel {
	
	public PanelFuncionEscogida(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		
		gestionINF.generarIdCompra();
		
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

		// LBL PELICULA
		JLabel lblFunciones = new JLabel("Película:");
		lblFunciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblFunciones.setForeground(new Color(134, 167, 252));
		lblFunciones.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFunciones.setBounds(159, 212, 75, 49);
		add(lblFunciones);

		// (!) LBL PELICULA SELECCIONADA (TRAE DATOS DE BD!!!!)
		JLabel lblPeliculaSeleccionada = new JLabel();
		lblPeliculaSeleccionada.setVerticalAlignment(SwingConstants.TOP);
		lblPeliculaSeleccionada.setText(gestionINF.pasarNombrePelicula());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(252, 226, 797, 49);
		add(lblPeliculaSeleccionada);

		// LBL REDIRECCIÒN
		JLabel lblEnUnosSegundos = new JLabel("En unos segundos serás redirigido al inicio...");
		lblEnUnosSegundos.setForeground(Color.WHITE);
		lblEnUnosSegundos.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblEnUnosSegundos.setBounds(359, 541, 400, 21);
		add(lblEnUnosSegundos);

		// SEPARADOR
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(134, 167, 255));
		separator.setBounds(167, 510, 800, 8);
		add(separator);

		// LBL CINE
		JLabel lblCine = new JLabel("Cine:");
		lblCine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCine.setForeground(new Color(134, 167, 252));
		lblCine.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCine.setBounds(131, 272, 75, 49);
		add(lblCine);

		// [!] LBL NOMBRE DEL CINE - TRAE DE BD
		JLabel lblNombreDelCine = new JLabel();
		lblNombreDelCine.setText(gestionINF.pasarNombreCine());
		lblNombreDelCine.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelCine.setForeground(new Color(211, 213, 248));
		lblNombreDelCine.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombreDelCine.setBounds(216, 272, 797, 49);
		add(lblNombreDelCine);

		// LBL FUNCIÓN
		JLabel lblFuncin = new JLabel("Función:");
		lblFuncin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncin.setForeground(new Color(134, 167, 252));
		lblFuncin.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFuncin.setBounds(159, 335, 72, 49);
		add(lblFuncin);

		// [!] LBL SALA Y HORA - TRAE DE BD
		JLabel lblSalaYHora = new JLabel();
		lblSalaYHora.setText(gestionINF.pasarFuncionSeleccionada());
		lblSalaYHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaYHora.setForeground(new Color(211, 213, 248));
		lblSalaYHora.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSalaYHora.setBounds(241, 335, 797, 49);
		add(lblSalaYHora);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setForeground(new Color(134, 167, 252));
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCantidad.setBounds(156, 395, 86, 49);
		add(lblCantidad);
		
		JLabel lblCantidadSeleccionada = new JLabel();
		lblCantidadSeleccionada.setText(gestionINF.pasarCantidadSeleccionada() + "");
		lblCantidadSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadSeleccionada.setForeground(new Color(211, 213, 248));
		lblCantidadSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCantidadSeleccionada.setBounds(252, 395, 797, 49);
		add(lblCantidadSeleccionada);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					TimeUnit.SECONDS.sleep(2);
					gestionINF.crearEntrada(0,gestionINF.pasarFechaSeleccionada(), gestionINF.pasarNombrePelicula(),
							gestionINF.pasarHoraSeleccionada(), gestionINF.pasarIdSalaSeleccionada(),
							gestionINF.pasarPrecio(), gestionINF.pasarNombreCine(), gestionINF.pasarCantidadSeleccionada(), gestionINF.pasarIdCompra());
					v.cambiarDePanel(3);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});

	}
}