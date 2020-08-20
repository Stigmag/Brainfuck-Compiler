package model.lexeme;
import model.visitor.Visitor;

public class PlusLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlusLexeme(this);
    }

}
