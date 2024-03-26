import java.awt.Color;

import javax.swing.JFrame;

public class PruebaMario {
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Java 2D Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        //frame.setBounds(0, 0, 974, 683);
        frame.setSize(986, 690);
        frame.add(new FirstWorld());
        frame.setVisible(true);
	}
}
