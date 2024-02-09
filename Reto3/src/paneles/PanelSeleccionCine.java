package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
import vista.VentanaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;

public class PanelSeleccionCine extends JPanel {

//	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();
	private GestionBD gestionBD = new GestionBD();

	public PanelSeleccionCine(VentanaPrincipal v, GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));

		// MSJ BIENVENIDA
		JLabel mensajeBienvenida = new JLabel("Iniciaste sesión en Cines ESA");
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setForeground(Color.decode("#ffffff"));
		mensajeBienvenida.setFont(new Font("Verdana", Font.BOLD, 32));
		mensajeBienvenida.setBounds(302, 169, 584, 78);
		add(mensajeBienvenida);

		// LABEL SELECCIONA UN CINE
		JLabel lblSeleccionarCine = new JLabel("Selecciona un cine:");
		lblSeleccionarCine.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSeleccionarCine.setBounds(359, 313, 193, 28);
		lblSeleccionarCine.setForeground(Color.decode("#FFFFFF"));
		add(lblSeleccionarCine);

		// COMBOBOX CINES
		JComboBox<String> comboBoxCines = new JComboBox<String>();
		comboBoxCines.setBounds(546, 317, 285, 28);
		comboBoxCines.setForeground(Color.decode("#BE6DB7"));
		comboBoxCines.setFont(new Font("Verdana", Font.PLAIN, 16));
		add(comboBoxCines);
		for (int i = 0; i < gestionINF.almacenarCines().size(); i++) {
			comboBoxCines.addItem(gestionINF.almacenarCines().get(i).getNombreCine());
		}

		// BOTÓN PRINCIPAL
		JButton btnSiguente = new JButton("Siguiente");
		btnSiguente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cineSeleccionado = (String) comboBoxCines.getSelectedItem();
				//System.out.println(cineSeleccionado);
				gestionINF.recogerCineSeleccionado(cineSeleccionado);
				gestionBD.sacarPeliculasDependiendoDelCineSeleccionado(cineSeleccionado);
				v.cambiarDePanel(4);

			}
		});
		btnSiguente.setFont(new Font("Verdana", Font.BOLD, 16));
		btnSiguente.setOpaque(true);
		btnSiguente.setContentAreaFilled(true);
		btnSiguente.setForeground(Color.decode("#FFFFFF"));
		btnSiguente.setBorderPainted(false);
		btnSiguente.setBackground(Color.decode("#C67ACE"));
		btnSiguente.setBounds(421, 489, 150, 39);
		add(btnSiguente);
		
		  // BTN SECUNDARIO - FINALIZAR 

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setOpaque(true);
        btnFinalizar.setForeground(Color.WHITE);
        btnFinalizar.setFont(new Font("Verdana", Font.BOLD, 16));
        btnFinalizar.setContentAreaFilled(true);
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setBackground(new Color(134, 167, 255));
        btnFinalizar.setBounds(594, 489, 140, 39);
        
        // Si selecciona FINALIZAR se cierra el programa
        btnFinalizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                System.exit(0);

            }
        });
        add(btnFinalizar);
	}
	
	
}