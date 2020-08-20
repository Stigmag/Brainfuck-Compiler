package model.lexeme;

import model.visitor.Visitor;

public class GreaterThanLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitGreaterThanLexeme(this);
    }
}
