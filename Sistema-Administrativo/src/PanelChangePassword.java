import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class PanelChangePassword extends JPanel {
	
	public PanelChangePassword() {
		setLayout(null);
		setPreferredSize(new Dimension(405,500));
		
		JButton button = new JButton("Confirmar");
		button.setBounds(205, 370, 120, 30);
		button.setBackground(new Color(228, 232, 255));
		add(button);
		
		JButton button2 = new JButton("Atras");
		button2.setBounds(75, 370, 120, 30);
		button2.setBackground(new Color(255, 228, 228));
		add(button2);
		
		
		JLabel lChangePassword = new JLabel("Cambiar contraseña ");
		lChangePassword.setFont(new Font("Serif", Font.BOLD,25));
		lChangePassword.setBounds(80,40,500,100);
		add(lChangePassword);
	
		JLabel lNewPassword = new JLabel("Nueva Contraseña");
		lNewPassword.setFont(new Font("SansSerif", Font.PLAIN,15));
		lNewPassword.setBounds(80,95,500,100);
		add(lNewPassword);
		
		JLabel lConfirmPassword = new JLabel("Confirmar contraseña");
		lConfirmPassword.setFont(new Font("SansSerif", Font.PLAIN,15));
		lConfirmPassword.setBounds(80,170,500,100);
		add(lConfirmPassword);
		
		JTextField tNewPassword = new JTextField();
		tNewPassword.setFont(new Font("SansSerif", Font.PLAIN,15));
		tNewPassword.setBounds(75, 155, 250, 30);
		add(tNewPassword);
		
		JPasswordField tConfirmPassword = new JPasswordField();
		tConfirmPassword.setBounds(75, 230, 250, 30);
		add(tConfirmPassword);
	}
}
