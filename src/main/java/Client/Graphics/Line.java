package Client.Graphics;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Line {

    private static final int BASE_SIZE = 1000;

    private GeneralPath generalPath;

    public Line() {
        this.generalPath = new GeneralPath();
    }

    public void paint(Graphics2D graphics) {
        graphics.draw(generalPath);
    }

    public void addCurve(float x1, float y1, float x2, float y2, float x3, float y3) {
        generalPath.curveTo(x1 * BASE_SIZE, y1 * BASE_SIZE,
                x2 * BASE_SIZE, y2 * BASE_SIZE, x3 * BASE_SIZE, y3 * BASE_SIZE);
    }

    public void moveTo(float x, float y) {
        generalPath.moveTo(x, y);
    }
}
