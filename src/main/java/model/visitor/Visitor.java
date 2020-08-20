package model.visitor;

import model.command.*;
import model.lexeme.*;

import java.util.List;

public interface Visitor {

    void visitPlusLexeme(PlusLexeme command);

    void visitMinusLexeme(MinusLexeme command);

    void visitGreaterThanLexeme(GreaterThanLexeme command);

    void visitLessThanLexeme(LessThanLexeme command);

    void visitDotLexeme(DotLexeme command);

    void visitOpenBracketLexeme(OpenBracketLexeme command);

    void visitCloseBracketLexeme(CloseBracketLexeme command);
}