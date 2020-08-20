package model.lexeme;
import model.visitor.Visitor;

public class MinusLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMinusLexeme(this);
    }

}
