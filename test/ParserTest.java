
import Client.Core.ProtocolParser.Parser;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class ParserTest {

    @Test
    public void parse() {
        String command = "60:21:C0:2A:E0:33;start;0.15703125;0.28644067;-16777216";
        Parser parser = new Parser(command);

        assertTrue(parser.isCorrect());
        assertEquals(0.15703125, parser.getX());
        assertEquals(0.28644067, parser.getY());
        assertEquals(Color.BITMASK, parser.getColor());
    }

    @Test
    public void isCorrect() {
        String command = "60:21:C0:2A:E0:33;start;0..15703125;0.28644067;-16777216";
        String command1 = "60:21:C0::2A:E0:33;start;0.15703125;0.28644067;-16777216";
        String command2 = "60:21:C0:2A:E0:A3:33;start;0.15703125;0.28644067;-16777216";
        String command3 = "60:21:C0 :2A:E0:33;start;0.157 03125;028644067;-16777216";

        assertFalse(new Parser(command).isCorrect());
        assertFalse(new Parser(command1).isCorrect());
        assertFalse(new Parser(command2).isCorrect());
        assertFalse(new Parser(command3).isCorrect());
    }
}
