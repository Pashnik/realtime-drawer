package Client.Graphics;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int BASE_SIZE = 1000;
    private static final int SIZE = 3;
    private Point temp;

    private final GeneralPath generalPath;
    private final List<Point> curvePoints;

    public Line() {
        this.generalPath = new GeneralPath();
        this.curvePoints = new ArrayList<>();
    }

    public void paint(Graphics2D graphics) {
        graphics.draw(generalPath);
    }

    public void addCurve() {
        switch (curvePoints.size()) {
            case SIZE:
                temp = new Point((curvePoints.get(1).getX() + curvePoints.get(2).getX()) / 2,
                        (curvePoints.get(1).getY() + curvePoints.get(2).getY()) / 2);

                generalPath.curveTo(curvePoints.get(0).getX(), curvePoints.get(0).getY(),
                        curvePoints.get(1).getX(), curvePoints.get(1).getY(),
                        temp.getX(), temp.getY());
                break;

            case SIZE - 1:
                generalPath.curveTo(temp.getX(), temp.getY(),
                        curvePoints.get(0).getX(), curvePoints.get(0).getY(),
                        (curvePoints.get(0).getX() + curvePoints.get(1).getX()) / 2,
                        (curvePoints.get(0).getY() + curvePoints.get(1).getY()) / 2
                );

                temp = new Point(curvePoints.get(0).getX() + curvePoints.get(1).getX() / 2,
                        (curvePoints.get(0).getY() + curvePoints.get(1).getY()) / 2);
                break;
        }
    }

    public void addStartPoint(float x, float y) {
        generalPath.moveTo(x * BASE_SIZE, y * BASE_SIZE);
    }

    public void addPoint(float x, float y) {
        curvePoints.add(new Point(x * BASE_SIZE, y * BASE_SIZE));
    }
}
