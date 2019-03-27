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
        Line line = new Line();
        while (true) {
            Parser cmd = new Parser(taskQueue.get());
            if (cmd.isCorrect()) {
                if (cmd.isStart()) {
                    line = new Line();
                    line.addStartPoint(cmd.getX(), cmd.getY());
                    int counter = 0;
                    Parser next;
                    while (counter != VALUES) {
                        if ((next = new Parser(taskQueue.get())).isCorrect()) {
                            line.addPoint(next.getX(), next.getY());
                            counter++;
                        } else counter--;
                    }
                    line.addCurve();
                    line.clear();
                } else {
                    line.addPoint(cmd.getX(), cmd.getY());
                    line.addCurve();
                    mainFrame.showLine(line);
                    line.clear();
                }
            }
        }
    }
}
