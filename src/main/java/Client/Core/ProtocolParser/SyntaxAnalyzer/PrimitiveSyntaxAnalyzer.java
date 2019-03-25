package Client.Core.ProtocolParser.SyntaxAnalyzer;

import Client.Core.ProtocolParser.LexicalAnalyzer.Token;
import Client.Core.ProtocolParser.LexicalAnalyzer.Type;

import java.awt.*;
import java.util.List;

public class PrimitiveSyntaxAnalyzer {

    private List<Token> tokens;

    public PrimitiveSyntaxAnalyzer(List<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean isCorrect() {
        if (tokens.get(0).getTokenType() == Type.MAC_ADDRESS) {
            if (tokens.get(1).getTokenType() == Type.ACTION) {
                if (tokens.get(2).getTokenType() == Type.COORDINATE) {
                    if (tokens.get(3).getTokenType() == Type.COORDINATE) {
                        return tokens.get(4).getTokenType() == Type.COLOR;
                    }
                }
            }
        }
        return false;
    }

    public double getX() {
        return Double.parseDouble(tokens.get(2).getValue());
    }


    public double getY() {
        return Double.parseDouble(tokens.get(3).getValue());
    }

    /*
    it is not clear what principle colors are coded for, so put a Stub
     */

    public int getColor() {
        return Color.BITMASK;
    }

}
