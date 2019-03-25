package Client.Core.ProtocolParser.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveLexAnalyzer {

     /*
    Simple Lexical Analyzer
     */

    public List<Tokens> getTokens(String command) {
        List<Tokens> tokens = new ArrayList<>();
        for (String token : command.split(";")) {
            if (isAction(token)) tokens.add(Tokens.ACTION);
            if (isMacAddress(token)) tokens.add(Tokens.MAC_ADDRESS);
            if (isCoordinate(token)) tokens.add(Tokens.COORDINATE);
            if (isColor(token)) tokens.add(Tokens.COLOR);
        }
        return tokens;
    }

    private boolean isAction(String part) {
        return (part.equals("move") || part.equals("start"));
    }

    private boolean isMacAddress(String part) {
        List<String> groups = Arrays.asList(part.split(":"));
        if (groups.size() != 6) return false;
        for (String group : groups) {
            if (group.length() != 2) return false;
        }
        return true;
    }

    private boolean isCoordinate(String part) { // ???
        return part.charAt(0) == '0' && part.charAt(1) == '.';
    }

    private boolean isColor(String part) { // ???
        return part.equals("-16777216");
    }
}
