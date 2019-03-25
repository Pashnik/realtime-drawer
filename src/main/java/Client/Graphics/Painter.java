package Client.Graphics;

import javax.swing.*;

public class Painter extends JFrame {
    private Painter(String s) {
        super(s);
        setSize(800, 600);
        setContentPane(new MainPanel());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Painter("Возможности Graphics2D"));
    }

}

