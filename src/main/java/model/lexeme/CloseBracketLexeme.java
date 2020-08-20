package model.lexeme;

import model.visitor.Visitor;

public class CloseBracketLexeme extends Lexeme {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitCloseBracketLexeme(this);
    }
}
