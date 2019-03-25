
import Client.Core.ProtocolParser.Parser;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class ParserTest {

    @Test
    public void getAllTokens() {
        String command = "60:21:C0:2A:E0:33;start;0.15703125;0.28644067;-16777216";
        Parser parser = new Parser(command);
        assertTrue(parser.isCorrect());
        assertEquals(0.15703125, parser.getX());
        assertEquals(0.28644067, parser.getY());
        assertEquals(Color.BITMASK, parser.getColor());
    }
}
