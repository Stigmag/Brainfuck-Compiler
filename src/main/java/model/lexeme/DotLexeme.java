package model.lexeme;
import model.visitor.Visitor;

public class DotLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitDotLexeme(this);
    }
}
