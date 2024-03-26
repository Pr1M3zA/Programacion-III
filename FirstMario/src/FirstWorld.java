import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class FirstWorld extends JPanel {
	private static final long serialVersionUID = 1L;

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
        
        Tuberia t1 = new Tuberia(520, 360, 135, 205, VERDE_TUBERIA);
        t1.draw(g2d);
        
        // Cuadricula base inferior
        for(int x=0; x<24; x++) {
        	for(int y=0; y<3; y++) {
                Plataforma cellGrid = new Plataforma(25 + (x*40), 585 + (y*40), 40, 40, CAFE_CUADRICULA);
        		cellGrid.draw(g2d);
        	}
        }
        // Arbusto
        Arbusto a1 = new Arbusto(60, 470, 170, 100, VERDE_ARBUSTO);
        a1.draw(g2d);
        
        //Suelo base
        Plataforma sueloBase = new Plataforma(25,  561,  960, 28, CAFE_BLOQUE);
        sueloBase.draw(g2d);
    }
}
