import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class PanelRegister extends JPanel {
	public PanelRegister() {
		
		setLayout(null);
		setPreferredSize(new Dimension(405,500));

		JButton button = new JButton("Aceptar");
		button.setBounds(205, 370, 120, 30);
		button.setBackground(new Color(228, 232, 255));
		add(button);
		
		JButton button2 = new JButton("Cancelar");
		button2.setBounds(75, 370, 120, 30);
		button2.setBackground(new Color(255, 228, 228));
		add(button2);
		
		JLabel lNewUser = new JLabel("Nuevo Usuario");
		lNewUser.setFont(new Font("Serif", Font.BOLD,30));
		lNewUser.setBounds(100,20,500,100);
		add(lNewUser);
		
		JLabel lUser = new JLabel("Usuario");
		lUser.setFont(new Font("SansSerif", Font.PLAIN,15));
		lUser.setBounds(80,80,500,100);
		add(lUser);
		
		JLabel lEmail = new JLabel("Correo");
		lEmail.setFont(new Font("SansSerif", Font.PLAIN,15));
		lEmail.setBounds(80,150,500,100);
		add(lEmail);
		
		JLabel lPassword = new JLabel("Contraseña");
		lPassword.setFont(new Font("SansSerif", Font.PLAIN,15));
		lPassword.setBounds(80,220,500,100);
		add(lPassword);
		
		JTextField tUser = new JTextField();
		tUser.setFont(new Font("SansSerif", Font.PLAIN,15));
		tUser.setBounds(75, 140, 250, 30);
		add(tUser);
		
		JTextField tEmail = new JTextField();
		tEmail.setFont(new Font("SansSerif", Font.PLAIN,15));
		tEmail.setBounds(75, 210, 250, 30);
		add(tEmail);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(75, 280, 250, 30);
		add(password);
		
		JCheckBox cb = new JCheckBox("Acepto términos y condiciones", true);
		cb.setFont(new Font("SansSerif", Font.ITALIC,12));
		cb.setBounds(100, 320, 200, 40);
		add(cb);		
	}
}
