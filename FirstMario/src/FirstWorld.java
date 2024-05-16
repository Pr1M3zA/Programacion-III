import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.event.*;

public class FirstWorld extends JPanel {
	private Plataforma personaje;
	private double personajeX = 30; 
	private double personajeY = 520;
	private double movimientoX = 0;
	private double movimientoY = -10;
	private int gravedad = 4;
	private boolean jumping = false;
	private boolean canJump = false;
	
 	private Rectangle [] valoresObstaculos = {
			new Rectangle (268, 257, 154,308),
			new Rectangle (175, 360, 157, 206),
			new Rectangle (825, 361, 140, 197),
			new Rectangle (41, 216, 55, 80),
			new Rectangle (145,30,55,80),
			new Rectangle (200,30,55,80),
			new Rectangle (835, 215, 55, 80),
			new Rectangle (520, 360,135, 205),
			new Rectangle (0, 0, 1, 1000),
			new Rectangle (25,  561,  960, 28),
	};
	private static final int timerDelay = 35;
	private static final long serialVersionUID = 1L;
	
	public FirstWorld() {
		new javax.swing.Timer(timerDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop();
			}
		}).start();
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {	
        	public void keyTyped(KeyEvent e) {

        	}
        	public void keyPressed(KeyEvent e) {
        		System.out.println("Key typed: " + e.getKeyChar());
        		if(e.getKeyCode() == KeyEvent.VK_A) {
        			movimientoX = -10;
        			System.out.println(personajeX);
        		}
        		if(e.getKeyCode() == KeyEvent.VK_D) {
        			movimientoX = 10;
        			System.out.println(personajeX);
        		}
        		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        			if(!jumping && canJump)
        				movimientoY = 90;
        			jumping = true;
        		}
        	}
        	public void keyReleased(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_A) {
        			movimientoX = 0;
        		}
        		if(e.getKeyCode() == KeyEvent.VK_D) {
        			movimientoX = 0;
        		}
        		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
        			movimientoY = -10;
        			jumping = false;
        		}
        	}
        });
	}
	
	public void gameLoop() {
		personajeX += movimientoX;
		if(checkCollision())
			personajeX -= movimientoX;
		else
			repaint();
		personajeY -= movimientoY;
		if(checkCollision())
			personajeY += movimientoY;
		else
			repaint();
		if(movimientoY > gravedad) {
			movimientoY -= 20;
		}
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
                
        //Colores
        final Color AZUL_CIELO = new Color(191, 236, 252);
        final Color AZUL_RECTANGULO = new Color(145, 190, 250);
        final Color ROSA_RECTANGULO = new Color(246, 198, 186);
        final Color VERDE_RECTANGULO = new Color(121, 214, 119);
        final Color VERDE_TUBERIA = new Color(68, 136, 48);
        final Color VERDE_ARBUSTO = new Color(118, 207, 123);
        final Color CAFE_BLOQUE = new Color(239,150,107);
        final Color CAFE_CUADRICULA = new Color(116, 90, 93);
        final Color VERDE_PERSONAJE = new Color(130,156,100);
       
        this.setBackground(AZUL_CIELO);
        // Plataformas
        Plataforma p1 = new Plataforma(268,257,154,308, AZUL_RECTANGULO, true, true);
        Plataforma p2 = new Plataforma(175, 360, 157, 206, ROSA_RECTANGULO, true, true);
        Plataforma p3 = new Plataforma(825,  361,  140, 197, VERDE_RECTANGULO, true, true);
        p1.draw(g2d);
        p2.draw(g2d);
        p3.draw(g2d);
        
        // Bloques elevados
        Plataforma block1 = new Plataforma(41,  216,  55,  80, CAFE_BLOQUE, false, true);
        Plataforma block2 = new Plataforma(145, 30, 55, 80, CAFE_BLOQUE, false, true);
        Plataforma block3 = new Plataforma(200, 30, 55, 80, CAFE_BLOQUE, false, true);
        Plataforma block4 = new Plataforma(835,  215,  55,  80, CAFE_BLOQUE, false, true);
        
        block1.draw(g2d);
        block2.draw(g2d);
        block3.draw(g2d);
        block4.draw(g2d);
        
        // Arbusto
        Arbusto a1 = new Arbusto(60, 470, 170, 100, VERDE_ARBUSTO);
        a1.draw(g2d);
        
        // Personaje
        personaje = new Plataforma((int)personajeX,  (int)personajeY,  40,  40, VERDE_PERSONAJE, false, false);
        personaje.draw(g2d); 
        
        Tuberia t1 = new Tuberia(520, 360, 135, 205, VERDE_TUBERIA);
        t1.draw(g2d);
        
        // Cuadricula base inferior
        for(int x=0; x<24; x++) {
        	for(int y=0; y<3; y++) {
                Plataforma cellGrid = new Plataforma(25 + (x*40), 585 + (y*40), 40, 40, CAFE_CUADRICULA);
        		cellGrid.draw(g2d);
        	}
        }
        
        //Suelo base
        Plataforma sueloBase = new Plataforma(25,  561,  960, 28, CAFE_BLOQUE);
        sueloBase.draw(g2d);
	}
	public boolean checkCollision() {
		Rectangle areaPersonaje = new Rectangle((int)personajeX, (int)personajeY, 40, 40);
		for(int i = 0; i < valoresObstaculos.length; i++) {
			if(valoresObstaculos[i].intersects(areaPersonaje)) { 
				canJump = true;
				return true;
			}
		}
		canJump = false;
		return false;
	}
}