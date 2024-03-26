import java.awt.Color;
import java.awt.Graphics2D;

public class Tornillo {
	
    private int x;
    private int y;
    final Color BLACK_SHADOW = new Color(33,33,33);
    final Color BOLT_COLOR = new Color(239,244,249);
    final int RADIUS = 5;    
    

    
    public Tornillo (int x, int y) {
        super(); 
        this.x = x;
        this.y = y;
    }

    void draw(Graphics2D g) {   
    	
     	double angle = Math.toRadians(135); 
        int x1 = x+5 - (int) (RADIUS * Math.cos(angle)); 
        int y1 = y+5 - (int) (RADIUS * Math.sin(angle)); 
        int x2 = x+5 + (int) (RADIUS * Math.cos(angle)); 
        int y2 = y+5 + (int) (RADIUS * Math.sin(angle)); 
    	
    	g.setColor(BOLT_COLOR.darker());
    	g.fillOval(x, y, RADIUS * 2, RADIUS * 2);
    	g.setColor(BOLT_COLOR);
    	g.fillOval(x, y, (RADIUS-1) * 2, (RADIUS-1) * 2);
    	g.setColor(BLACK_SHADOW);
    	g.drawOval(x, y, RADIUS * 2, RADIUS * 2);
        g.drawLine(x1, y1, x2, y2);
    }
}
