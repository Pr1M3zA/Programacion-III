import javax.swing.*;

public class SistemaPrueba {
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	
class Frame extends JFrame{
	public Frame() {
		setBounds(200,200,405,500);
		setLocationRelativeTo(null);
		setTitle("Sistema Administrativo");
		setResizable(true);
		SpringLayout layout = new SpringLayout(); 
		setLayout(layout);
		
		/*JMenuBar mb =  new JMenuBar();
		setJMenuBar(mb);
		
		JMenu menu1 = new JMenu("Archivo");
		mb.add(menu1);
		
		JMenu menu2 = new JMenu("Ayuda");
		mb.add(menu2);
		
		JMenu mi1 = new JMenu("Salir");
		menu1.add(mi1);
		
		JMenu mi2 = new JMenu("Ayuda");
		menu2.add(mi2);
		
		JMenuItem item1 = new JMenuItem("Opcion 1");
		mi1.add(item1);
		JMenuItem item2 = new JMenuItem("Opcion 2");
		mi1.add(item2);
		JMenuItem item3 = new JMenuItem("Opcion 3");
		menu1.add(item3);
		JMenuItem item4 = new JMenuItem("Ayuda");
		mi2.add(item4);*/
		
		PanelRegister panel = new PanelRegister();
		add(panel);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel, 0, SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, panel, 0, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		
		/*PanelLogin panel2 = new PanelLogin();
		add(panel2);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel2, 0, SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, panel2, 0, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		
		PanelChangePassword panel3 = new PanelChangePassword();
		add(panel3);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel3, 0, SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, panel3, 0, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		
		PanelMenu panel4 = new PanelMenu();
		add(panel4);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel4, 0, SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, panel4, 0, SpringLayout.VERTICAL_CENTER, this.getContentPane());*/
	}
}