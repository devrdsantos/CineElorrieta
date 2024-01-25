package paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vista.VentanaPrincipal;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class PanelLogin extends JPanel {
	private JPasswordField passwordField;
	private JTextField textFieldDNI;

	public PanelLogin(VentanaPrincipal v) {
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
		
		JButton btnPrincipal = new JButton("Iniciar sesión");
		btnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(3);
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
		btnPrincipal.setBounds(431, 446, 150, 39);
		add(btnPrincipal);
		
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