package com.mycompany.sistema_de_biblioteca;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class BooksPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Color BACKGROUND_YELLOW = new Color(253,250,245);
        final Color YELLOW_RECTANGLE = new Color(255,220,156);
        final Color YELLOW_RECTANGLE2 = new Color(213,171,97);
        final Color YELLOW_RECTANGLE3 = new Color(255,245,288);
        final Color OPTION_1 = new Color(137,104,31);
        final Color OPTION_2 = new Color(82,43,29);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(YELLOW_RECTANGLE);
        g2d.fillRect(1, 1, 100, 75);
        //g2d.setColor(YELLOW_RECTANGLE2);
        //g2d.fillRect(175, 0, 672, 75);
        //g2d.setBackground(BACKGROUND_YELLOW);
        //g2d.setColor(OPTION_2);
        //g2d.fillRoundRect(547, 514, 191, 41, 5, 5);
        //g2d.setColor(OPTION_1);
    }
}
