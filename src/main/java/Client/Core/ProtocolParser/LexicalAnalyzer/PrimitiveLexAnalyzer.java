package Client.Core.ProtocolParser.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimitiveLexAnalyzer {

    private static final int MAC_GROUP_NUMBER = 6;
    private static final int MAC_GROUP_SIZE = 2;

    public List<Token> getTokens(String command) { // hardcode for quick writing
        List<Token> tokens = new ArrayList<>();
        for (String token : command.split(";")) {
            if (isAction(token)) {
                tokens.add(new Token(Type.ACTION, token));
            } else {
                if (isMacAddress(token)) {
                    tokens.add(new Token(Type.MAC_ADDRESS, token));
                } else {
                    if (isColor(token)) {
                        tokens.add(new Token(Type.COLOR, token));
                    } else {
                        if (isCoordinate(token)) {
                            tokens.add(new Token(Type.COORDINATE, token));
                        }
                    }
                }
            }
        }
        return tokens;
    }

    private boolean isAction(String part) {
        return (part.equals("move") || part.equals("start"));
    }

    private boolean isMacAddress(String part) {
        List<String> groups = Arrays.asList(part.split(":"));
        if (groups.size() != MAC_GROUP_NUMBER) return false;
        for (String group : groups) {
            if (group.length() != MAC_GROUP_SIZE) return false;
        }
        return true;
    }

    private boolean isCoordinate(String part) {
        return isDouble(part);
    }

     /*
    it is not clear what principle colors are coded for, so put a Stub
     */

    private boolean isColor(String part) { // ???
        return part.equals("-16777216");
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
