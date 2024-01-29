package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
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

public class PanelSeleccionCine extends JPanel {

//	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();
	private GestionBD gestionBD = new GestionBD();
	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();
	
	public PanelSeleccionCine(VentanaPrincipal v) {
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
		JLabel lblDNI = new JLabel("Selecciona un cine:");
		lblDNI.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDNI.setBounds(359, 313, 193, 28);
		lblDNI.setForeground(Color.decode("#FFFFFF"));
		add(lblDNI);
		
		
		// COMBOBOX CINES
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(546, 317, 285, 28);
		comboBox.setForeground(Color.decode("#BE6DB7"));
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		add(comboBox);
		for (int i = 0; i < gestionINF.almacenarCines().size(); i++) {
			comboBox.addItem(gestionINF.almacenarCines().get(i));
		}
		
		// BOTÓN PRINCIPAL
				JButton btnPrincipal = new JButton("Siguiente");
				btnPrincipal.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						gestionBD.sacarCines();
					}
				});
				btnPrincipal.setFont(new Font("Verdana", Font.BOLD, 16));
				btnPrincipal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnPrincipal.setOpaque(true);
				btnPrincipal.setContentAreaFilled(true);
				btnPrincipal.setForeground(Color.decode("#FFFFFF"));
				btnPrincipal.setBorderPainted(false);
				btnPrincipal.setBackground(Color.decode("#C67ACE"));
				btnPrincipal.setBounds(490, 489, 150, 39);
				add(btnPrincipal);
	}
}