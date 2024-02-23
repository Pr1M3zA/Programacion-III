import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelLogin extends JPanel {
 
	public PanelLogin(){
	 setLayout(null);
		JButton button = new JButton("Aceptar");
		button.setBounds(205, 370, 120, 30);
		button.setBackground(new Color(228, 232, 255));
		add(button);
		
		JButton button2 = new JButton("Cancelar");
		button2.setBounds(75, 370, 120, 30);
		button2.setBackground(new Color(255, 228, 228));
		add(button2);
		
		JButton buttonForgotPassword = new JButton("¿Olvidaste la contraseña?");
		buttonForgotPassword.setFont(new Font("Serif", Font.BOLD,15));
		buttonForgotPassword.setBounds(90,305,210,20);
		buttonForgotPassword.setBackground(new Color(211, 229, 232));
		add(buttonForgotPassword);
		
		
		JLabel lWelcomeUser = new JLabel("¡Hola de nuevo Usuario!");
		lWelcomeUser.setFont(new Font("Serif", Font.BOLD,25));
		lWelcomeUser.setBounds(65,40,500,100);
		add(lWelcomeUser);
	
		JLabel lUser = new JLabel("Usuario");
		lUser.setFont(new Font("SansSerif", Font.PLAIN,15));
		lUser.setBounds(80,95,500,100);
		add(lUser);
		
		JLabel lPassword = new JLabel("Contraseña");
		lPassword.setFont(new Font("SansSerif", Font.PLAIN,15));
		lPassword.setBounds(80,170,500,100);
		add(lPassword);
		
		JTextField tUser = new JTextField();
		tUser.setFont(new Font("SansSerif", Font.PLAIN,15));
		tUser.setBounds(75, 155, 250, 30);
		add(tUser);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(75, 230, 250, 30);
		add(password);
 	}
}
