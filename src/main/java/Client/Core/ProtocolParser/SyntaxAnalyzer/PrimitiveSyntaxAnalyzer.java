package Client.Core.ProtocolParser.SyntaxAnalyzer;

import Client.Core.ProtocolParser.LexicalAnalyzer.Tokens;

import java.util.List;

public class PrimitiveSyntaxAnalyzer {

    private List<Tokens> tokens;

    public PrimitiveSyntaxAnalyzer(List<Tokens> tokens) {
        this.tokens = tokens;
    }

    public boolean isCorrect() {
        // TODO
        return true;
    }
}
