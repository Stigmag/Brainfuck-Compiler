package model.visitor;

import model.command.*;

public interface Visitor {
    void visitPlusCommand(PlusCommand command);
    void visitMinusCommand(MinusCommand command);
    void visitGreaterThanCommand(GreaterThanCommand command);
    void visitLessThanCommand(LessThanCommand command);
    void visitDotCommand(DotCommand command);
    boolean visitOpenBracketCommand(OpenBracket command);
    boolean visitCloseBracketCommand(CloseBracket command);
}