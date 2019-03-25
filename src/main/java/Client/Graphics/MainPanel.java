package Client.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class MainPanel extends JPanel {

    public MainPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        GeneralPath shape = new GeneralPath();
        shape.moveTo(0, 0);
        shape.curveTo(0, 2 * 100, 1 * 100, 2 * 100, 4 * 100, -1 * 100);
        // shape.curveTo(-1.0, -92.0, 4, 6, 7, 9);
//        shape.curveTo(-1.0, -90.0, 1, 2, 1, 2);


        AffineTransform transform = AffineTransform.getTranslateInstance(500.0, 500.0);
        g2d.setTransform(transform);
        g2d.draw(shape);

    }
}
