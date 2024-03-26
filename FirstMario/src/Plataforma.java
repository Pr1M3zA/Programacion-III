import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Plataforma {

	private boolean showShadow, showRivet;
		private int x, y, w, h;
	    private Color color;
	    final Color BLACK_SHADOW = new Color(33,33,33);

	    public Plataforma(int x, int y, int width, int height, Color color) {
	        this.w = width;
	        this.h = height;
	        this.x = x;
	        this.y = y;
	        this.color = color;
	        this.showRivet = false;
	        this.showShadow = false;
	    }
	    
	    public Plataforma(int x, int y, int width, int height, Color color, boolean showShadow, boolean showRivet) {
	        this.w = width;
	        this.h = height;
	        this.x = x;
	        this.y = y;
	        this.color = color;
	        this.showRivet = showRivet;
	        this.showShadow = showShadow;
	    }

	    
	    void draw(Graphics2D g) {
	        if(showShadow)  {
		    	g.setColor(BLACK_SHADOW);
			    g.fillRoundRect(x+15, y+10, w, h-9,5,5);
		    }
	        g.setColor(color);
	        g.fillRoundRect(x, y, w, h,5,5);
	        g.setColor(color.brighter());
	        g.fillRoundRect(x, y, w-4, h-4,5,5);
	        g.setColor(BLACK_SHADOW);
	    	g.setStroke(new BasicStroke(2));
	    	g.drawRoundRect(x, y, w, h, 5, 5);
	    	
	    	if(showRivet) {
		    	Tornillo boltUpperLeft = new Tornillo(x+5,y+5);
		    	Tornillo boltUpperRight = new Tornillo(x+w-20,y+5);
		    	Tornillo boltBottomLeft = new Tornillo(x+5,y+h-16);
		    	Tornillo boltBottomRight = new Tornillo(x+w-20,y+h-16);
		    	boltUpperLeft.draw(g);
		    	boltUpperRight.draw(g);
		    	boltBottomLeft.draw(g);
		    	boltBottomRight.draw(g);
		    }
	    	
	    }
}
