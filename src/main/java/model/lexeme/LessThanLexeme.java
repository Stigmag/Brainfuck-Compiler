package model.lexeme;

import model.visitor.Visitor;

public class LessThanLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLessThanLexeme(this);
    }
}
