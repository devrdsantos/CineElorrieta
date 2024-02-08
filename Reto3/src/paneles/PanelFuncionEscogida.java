// Este Panel mostrará le selección que se realizó en en Selección de Función

package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
import modelo.Pelicula;
import vista.VentanaPrincipal;
import javax.swing.JSeparator;

public class PanelFuncionEscogida extends JPanel {

	private GestionBD gestion = new GestionBD();
	ArrayList<Pelicula> peli = gestion.sacarInformacionPeliculas();
	

	public PanelFuncionEscogida(VentanaPrincipal v) {
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
		lblPeliculaSeleccionada.setText("<html>NOMBRE DE LA PELÍCULA</html>");
		// lblCineSeleccionado.setText(cine.getNombreCine());
		lblPeliculaSeleccionada.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeliculaSeleccionada.setForeground(new Color(211, 213, 248));
		lblPeliculaSeleccionada.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPeliculaSeleccionada.setBounds(235, 226, 797, 49);
		add(lblPeliculaSeleccionada);

		// LBL REDIRECCIÒN
		JLabel lblEnUnosSegundos = new JLabel("En unos segundos serás redirigido al inicio...");
		lblEnUnosSegundos.setForeground(Color.WHITE);
		lblEnUnosSegundos.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblEnUnosSegundos.setBounds(359, 481, 400, 21);
		add(lblEnUnosSegundos);
		
		// SEPARADOR
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(134, 167, 255));
		separator.setBounds(167, 450, 800, 8);
		add(separator);
		
		// LBL CINE
		JLabel lblCine = new JLabel("Cine:");
		lblCine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCine.setForeground(new Color(134, 167, 252));
		lblCine.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCine.setBounds(171, 288, 56, 49);
		add(lblCine);
		
		// [!] LBL NOMBRE DEL CINE - TRAE DE BD
		JLabel lblNombreDelCine = new JLabel();
		lblNombreDelCine.setText("NOMBRE DEL CINE");
		lblNombreDelCine.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelCine.setForeground(new Color(211, 213, 248));
		lblNombreDelCine.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombreDelCine.setBounds(235, 289, 797, 49);
		add(lblNombreDelCine);
		
		// LBL FUNCIÓN
		JLabel lblFuncin = new JLabel("Función:");
		lblFuncin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuncin.setForeground(new Color(134, 167, 252));
		lblFuncin.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFuncin.setBounds(156, 362, 72, 49);
		add(lblFuncin);
		
		// [!] LBL SALA Y HORA - TRAE DE BD
		JLabel lblSalaYHora = new JLabel();
		lblSalaYHora.setText("SALA Y HORA");
		lblSalaYHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaYHora.setForeground(new Color(211, 213, 248));
		lblSalaYHora.setFont(new Font("Verdana", Font.BOLD, 16));
		lblSalaYHora.setBounds(235, 363, 797, 49);
		add(lblSalaYHora);


	}
	
}