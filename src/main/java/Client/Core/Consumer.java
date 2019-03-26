package Client.Core;

import Client.Core.ProtocolParser.Parser;
import Client.Graphics.Line;
import Client.Graphics.MainFrame;

public class Consumer {

    private final TaskQueue taskQueue;
    private final MainFrame mainFrame;

    private static final int VALUES = 3;

    public Consumer(TaskQueue taskQueue, MainFrame mainFrame) {
        this.taskQueue = taskQueue;
        this.mainFrame = mainFrame;
    }

    public void consume() throws InterruptedException {
        while (true) {
            Parser parser = new Parser(taskQueue.get());
            if (parser.isCorrect()) {
                Line line = new Line();
                line.addStartPoint(parser.getX(), parser.getY());
                Parser next;
                int counter = 0;
                while (counter != VALUES) {
                    if ((next = new Parser(taskQueue.get())).isCorrect()) {
                        line.addPoint(next.getX(), next.getY());
                        counter++;
                    } else counter--;
                }
                line.addCurve();
                mainFrame.showLine(line);
            }
        }
    }
}
