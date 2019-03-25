package Client.Core.ProtocolParser.LexicalAnalyzer;

import java.util.Objects;

public class Token {

    private final Type tokenType;

    private final String value;

    public Token(Type tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public Type getTokenType() {
        return tokenType;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return tokenType == token.tokenType &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenType, value);
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }
}
