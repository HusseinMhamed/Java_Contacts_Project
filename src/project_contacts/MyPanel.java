 
package project_contacts;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GradientPaint;
 
public class MyPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(52, 143, 80);
        Color color2 = new Color(86, 180, 211);
//         Color color1 = new Color(50,6, 100);
//        Color color2 = new Color(100, 60, 211);
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}
