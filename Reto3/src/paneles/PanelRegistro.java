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
import javax.swing.JRadioButton;

public class PanelRegistro extends JPanel {
	private JPasswordField passwordField;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;

	public PanelRegistro(VentanaPrincipal v) {
		setSize(1200, 720);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Tahoma", Font.BOLD, 11));
		setBackground(Color.decode("#142850"));
		JLabel mensajeRegistro = new JLabel("Regístrate en Cines ESA");
		mensajeRegistro.setForeground(Color.decode("#ffffff"));
		mensajeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeRegistro.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		mensajeRegistro.setBounds(371, 91, 515, 78);
		add(mensajeRegistro);
		
		JLabel lblDNI = new JLabel("Ingresa tu DNI:");
		lblDNI.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDNI.setBounds(433, 210, 150, 28);
		lblDNI.setForeground(Color.decode("#FFFFFF"));
		add(lblDNI);
		
		JLabel lblPassword = new JLabel("Ingresa una contraseña:");
		lblPassword.setForeground(Color.decode("#FFFFFF"));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword.setBounds(352, 279, 228, 28);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(597, 277, 266, 34);
		add(passwordField);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(597, 210, 266, 34);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JButton btnPrincipal = new JButton("Crear cuenta");
		btnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(1);
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
		btnPrincipal.setBounds(462, 551, 150, 39);
		add(btnPrincipal);
		
		JLabel lblTienesCuenta = new JLabel("¿Ya tienes una cuenta?");
		lblTienesCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarDePanel(1);
			}
		});
		lblTienesCuenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienesCuenta.setBounds(637, 561, 211, 20);
		lblTienesCuenta.setForeground(Color.decode("#BE6DB7"));
		add(lblTienesCuenta);
		
		JRadioButton rdbtnSexoMujer = new JRadioButton("Femenino");
		rdbtnSexoMujer.setSelected(true);
		rdbtnSexoMujer.setFont(new Font("Verdana", Font.PLAIN, 16));
		rdbtnSexoMujer.setBounds(597, 461, 109, 34);
		rdbtnSexoMujer.setForeground(Color.decode("#ffffff"));
		rdbtnSexoMujer.setContentAreaFilled(false);
		add(rdbtnSexoMujer);
		
		
		JLabel lblSexo = new JLabel("Ingresa tu sexo:");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSexo.setBounds(422, 463, 156, 28);
		add(lblSexo);
		
		JRadioButton rdbtnSexoHombre = new JRadioButton("Masculino");
		rdbtnSexoHombre.setForeground(Color.WHITE);
		rdbtnSexoHombre.setFont(new Font("Verdana", Font.PLAIN, 16));
		rdbtnSexoHombre.setContentAreaFilled(false);
		rdbtnSexoHombre.setBounds(719, 461, 109, 34);
		add(rdbtnSexoHombre);
		
		JLabel lblNombre = new JLabel("Ingresa tu nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombre.setBounds(396, 337, 193, 28);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(597, 337, 266, 34);
		add(textFieldNombre);
		
		JLabel lblIngresaTuApellido = new JLabel("Ingresa tu apellido:");
		lblIngresaTuApellido.setForeground(Color.WHITE);
		lblIngresaTuApellido.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblIngresaTuApellido.setBounds(396, 404, 193, 28);
		add(lblIngresaTuApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(597, 404, 266, 34);
		add(textFieldApellido);
		
	}
}