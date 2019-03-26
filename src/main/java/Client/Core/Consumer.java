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

    public void consume() throws InterruptedException {  // hardcode
        Line line = new Line();
        while (true) {
            Parser parser = new Parser(taskQueue.get());
            if (parser.isCorrect()) {
                if (parser.isStart()) { // start of the curve
                    line.addCurve();
                    mainFrame.showLine(line);

                    line = new Line();
                    line.addStartPoint(parser.getX(), parser.getY());
                    Parser next;
                    int counter = 0;
                    while ((next = new Parser(taskQueue.get())).isCorrect()
                            && counter != VALUES - 1) {
                        line.addPoint(next.getX(), next.getY());
                        counter++;
                    }
                    line.addCurve();
                    mainFrame.showLine(line);
                } else {
                    Parser next;
                    int counter = 0;
                    while ((next = new Parser(taskQueue.get())).isCorrect()
                            && counter != VALUES - 2) {
                        line.addPoint(next.getX(), next.getY());
                        counter++;
                    }
                    line.addCurve();
                    mainFrame.showLine(line);
                }
            }
        }
    }

}
