package model.lexeme;
import model.visitor.Visitor;

public class OpenBracketLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitOpenBracketLexeme(this);
    }

}
