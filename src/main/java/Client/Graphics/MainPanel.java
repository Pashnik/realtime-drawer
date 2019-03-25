package Client.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel {

    private final List<Line> lines;

    public MainPanel() {
        lines = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform transform = AffineTransform.getTranslateInstance((float) MainFrame.getFrameWidth() / 2,
                (float) MainFrame.getFrameHeight() / 2);
        g2d.setTransform(transform);
        for (Line line : lines) {
            line.paint(g2d);
        }
    }


    public void addLine(Line line) {
        lines.add(line);
        this.repaint();
    }


}
