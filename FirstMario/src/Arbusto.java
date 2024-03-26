import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Arbusto {	
	private int x, y, w, h;
    private Color color;
	final Color COLOR_CONTORNO = new Color(33,33,33);
	
    public Arbusto (int x, int y, int width, int height, Color color) {
        this.w = width;
        this.h = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

	void draw(Graphics2D g2d) {
        // Relleno externo
		g2d.setColor(color.darker());
        g2d.fillOval((int)(x+w*0.15), y, (int)(w*0.4), h);
        g2d.fillOval(x, (int)(y+(h*0.4)), (int)(w*0.3), (int)(h*0.6));
        g2d.fillOval((int)(x+w*0.3), (int)(y+(h*0.4)), (int)(w*0.35), (int)(h*0.55));
        // Relleno interno
		g2d.setColor(color.brighter());
        g2d.fillOval((int)((x+w*0.15)+3), y+3, (int)((w*0.4)-6), h-6);
        g2d.fillOval(x+3, (int)(y+(h*0.4)+3), (int)((w*0.3)-6), (int)((h*0.6)-6));
        g2d.fillOval((int)((x+w*0.3)+3), (int)((y+(h*0.4))+3), (int)((w*0.35)-6), (int)((h*0.55)-6));
		       
        //Contorno	
        g2d.setColor(COLOR_CONTORNO);
        g2d.drawArc((int)(x+w*0.15), y, (int)(w*0.4), h, 5, 165);
        g2d.drawArc(x, (int)(y+(h*0.4)), (int)(w*0.3), (int)(h*0.6), 90, 130);
        g2d.drawArc((int)(x+w*0.3), (int)(y+(h*0.4)), (int)(w*0.35), (int)(h*0.55), 280, 145);
	}
}
