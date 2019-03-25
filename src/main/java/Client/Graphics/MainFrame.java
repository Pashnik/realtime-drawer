package Client.Graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static int width;
    private static int height;
    private final MainPanel panel;

    private MainFrame() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        width = dimension.width;
        height = dimension.height;

        this.setSize(width, height);
        this.setLocation(0, 0);

        panel = new MainPanel();
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static int getFrameWidth() {
        return width;
    }

    public static int getFrameHeight() {
        return height;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

}

