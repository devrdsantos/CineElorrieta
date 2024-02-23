package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
import controlador.GestionDeLaInformacion;
import modelo.Compra;
import vista.VentanaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class PanelLogin extends JPanel {
	
	private JPasswordField passwordField;
	private JTextField textFieldDNI;
	private GestionBD gestionBD = new GestionBD();
	
	public PanelLogin(VentanaPrincipal v , GestionDeLaInformacion gestionINF) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));
		JLabel mensajeBienvenida = new JLabel("Inicia sesión en Cines ESA");
		mensajeBienvenida.setForeground(Color.decode("#ffffff"));
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		mensajeBienvenida.setBounds(371, 169, 515, 78);
		add(mensajeBienvenida);

		JLabel lblDNI = new JLabel("Ingresa tu DNI:");
		lblDNI.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDNI.setBounds(406, 300, 150, 28);
		lblDNI.setForeground(Color.decode("#FFFFFF"));
		add(lblDNI);

		JLabel lblPassword = new JLabel("Ingresa tu contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword.setBounds(343, 367, 211, 28);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(574, 367, 266, 34);
		add(passwordField);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(574, 300, 266, 34);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);

		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni = textFieldDNI.getText();
				
				String pass = passwordField.getText();
				gestionINF.recogerDNI(dni);
				gestionBD.sacarIdCompra();
				
				try {
					gestionBD.verificarLogin(dni, pass, v);
				} catch (Exception e1) {
					System.out.println("salio mal");
					e1.printStackTrace();
				}
			}
		});
		btnIniciarSesion.setFont(new Font("Verdana", Font.BOLD, 16));
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setContentAreaFilled(true);
		btnIniciarSesion.setForeground(Color.decode("#FFFFFF"));
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(Color.decode("#C67ACE"));
		btnIniciarSesion.setBounds(431, 446, 150, 39);
		add(btnIniciarSesion);

		JLabel lblSinCuenta = new JLabel("¿Aún no tienes una cuenta?");
		lblSinCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(2);
			}
		});
		lblSinCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinCuenta.setBounds(606, 456, 211, 20);
		lblSinCuenta.setForeground(Color.decode("#BE6DB7"));
		add(lblSinCuenta);

	}
}