import java.awt.Color;
import java.awt.Graphics2D;

public class Tuberia {
	private int x, y, w, h;
    private Color color;
	
    public Tuberia (int x, int y, int width, int height, Color color) {
        this.w = width;
        this.h = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    void draw(Graphics2D g2d) {
		Plataforma bocaTubo = new Plataforma(x,  y,  w, h > 65 ? 65 : h, color);
		bocaTubo.draw(g2d);
		g2d.setColor(color.darker());
		g2d.fillRect((int)(x+(w*0.5)), y+2, (int)((w*0.49)), (h > 65? 60 : h-5));
		
		if(h > 67 && w > 12) {
			Plataforma baseTubo = new Plataforma(x+5, y+65, w-10, h-65, color);
			baseTubo.draw(g2d);
			g2d.setColor(color.darker());
			g2d.fillRect((int)(x+(w*0.6)+5), y+67, (int)((w*0.4)-12), h-71);
			g2d.fillRect((int)(x+(w*0.5)+5), y+67, (int)((w*0.19)-12), h-71);
		}
	}
}
