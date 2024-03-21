import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
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
        final Color CAFE_BLOQUE_CONTORNO = new Color(187,137,109);
        final Color CAFE_BASE = new Color(232,206,187);
        final Color ROSA_SOMBRA = new Color (226, 159, 125);
        final Color AZUL_SOMBRA = new Color (67, 142, 219);
        final Color TUBERIA_VERDE_SOMBRA = new Color (52, 102, 41);
        final Color CAFE_CUADRICULA = new Color(116, 90, 93);
        final Color CAFE_CUADRICULA_CONTORNO = new Color(150, 125, 128);
        
        g2d.setStroke(new BasicStroke(5));   // Grosor de linea
        
        // Background (cielo)
        g2d.setColor(AZUL_CIELO);
        g2d.fillRect(0,  0,  974,  683);

        // Cuadro grande Cyan	
        g2d.setColor(AZUL_RECTANGULO);
        g2d.fillRoundRect(268,  257,  154, 308, 16, 16);
        g2d.setColor(AZUL_SOMBRA);
        //Cuadro grande Cyan relleno
        g2d.drawRoundRect(268,  257,  154, 308, 16, 16);
        
        //Arbusto izquierdo
        //Relleno de arbusto izquierdo
        g2d.setColor(VERDE_ARBUSTO);
        g2d.fillOval(84, 468, 70, 97);
        g2d.fillOval(59, 511, 50, 58);
        g2d.fillOval(110, 509, 60, 56);
        
        //Contorno	
        g2d.setColor(VERDE_TUBERIA);
        g2d.drawArc(84, 468, 70, 97, 5, 165);
        g2d.drawArc(59, 511, 50, 58, 90, 120);
        g2d.drawArc(110, 509, 60, 56, 280, 135);
        
        //Sombra Cuadro grande Cyan
        g2d.setColor(AZUL_SOMBRA);
        g2d.fillRoundRect(421, 317, 24, 244, 16, 16);
        
        // Cuadro rosa delante del cuadro cyan
        g2d.setColor(ROSA_RECTANGULO);
        g2d.fillRoundRect(175, 360, 157, 206, 16, 16);
        g2d.setColor(ROSA_SOMBRA);
        g2d.drawRoundRect(175, 360, 157, 206, 16, 16);
        
        //Sombra Cuadro rosa
        g2d.setColor(ROSA_SOMBRA);
        g2d.fillRoundRect(328,  411,  27, 147, 16, 16);
        
       // Relleno de los cuadros medianos elevados
        g2d.setColor(CAFE_BLOQUE);
        g2d.fillRect(41,  216,  55,  80);
        g2d.fillRect(145, 30, 55, 80);
        g2d.fillRect(200, 30, 55, 80);
        g2d.fillRect(835,  215,  55,  80);
       
        // Contorno de los cuadros medianos elevados
        g2d.setColor(CAFE_BLOQUE_CONTORNO);
        g2d.drawRect(41,  216,  55,  80);
        g2d.drawRect(145, 30, 55, 80);
        g2d.drawRect(200, 30, 55, 80);
        g2d.drawRect(835,  215,  55,  80);
        
        // Relleno tuberia verde
        g2d.setColor(VERDE_TUBERIA);
        g2d.fillRect(519,  358,  135, 65);
        g2d.fillRect(523,  426,  120, 137);
        
        // Contorno Tuberia verde
        g2d.setColor(TUBERIA_VERDE_SOMBRA);
        g2d.drawRect(519,  358,  135, 65);
        g2d.drawRect(523,  426,  120, 137);
        
        // Sombra Tuberia Verde
        g2d.setColor(TUBERIA_VERDE_SOMBRA);
        g2d.fillRect(579,  362,  72, 59);
        g2d.fillRect(600, 428, 40, 130);
        
        // Cuadro verde relleno
        g2d.setColor(new Color(28, 172, 119));
        g2d.fillRect(825,  361,  140, 197);
        
        // Cuadro verde grande
        g2d.setColor(VERDE_RECTANGULO);
        g2d.drawRoundRect(825,  361,  140, 197, 16, 16);
       
        // Rectangulo cafe base
        g2d.setColor(CAFE_BASE);
        g2d.setColor(new Color(169, 147, 150));
        g2d.drawRect(25,  561,  949, 28);
        
        //Rectangulo cafe relleno
        g2d.fillRect(25,  561,  949, 28);
        
        // Cuadricula base inferior
        for(int x=0; x<24; x++) {
        	for(int y=0; y<3; y++) {
                g2d.setColor(CAFE_CUADRICULA);
                g2d.drawRect(25 + (x*40), 585 + (y*40), 40, 40);
                g2d.setColor(CAFE_CUADRICULA_CONTORNO);
                g2d.fillRect(27+(x*40), 587+(y*40), 37, 37);
        	}
        }
    }
}
