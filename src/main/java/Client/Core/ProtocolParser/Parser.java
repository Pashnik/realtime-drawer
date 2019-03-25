package Client.Core.ProtocolParser;

import Client.Core.ProtocolParser.LexicalAnalyzer.PrimitiveLexAnalyzer;
import Client.Core.ProtocolParser.SyntaxAnalyzer.PrimitiveSyntaxAnalyzer;

public class Parser {

    private final PrimitiveSyntaxAnalyzer syntaxAnalyzer;

    public Parser(String command) {
        PrimitiveLexAnalyzer lexAnalyzer = new PrimitiveLexAnalyzer();
        syntaxAnalyzer = new PrimitiveSyntaxAnalyzer(lexAnalyzer.getTokens(command));
    }

    public boolean isCorrect() {
        return syntaxAnalyzer.isCorrect();
    }

    public double getX() {
        return syntaxAnalyzer.getX();
    }

    public double getY() {
        return syntaxAnalyzer.getY();
    }

    public int getColor() {
        return syntaxAnalyzer.getColor();
    }


}
