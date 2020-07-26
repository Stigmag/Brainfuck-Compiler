package model.visitor;

import model.command.*;

public class CommandVisitor implements Visitor {
    public CommandVisitor() {
    }

    @Override
    public void visitPlusCommand(PlusCommand command) {
command.execute();
    }

    @Override
    public void visitMinusCommand(MinusCommand command) {
        command.execute();
    }

    @Override
    public void visitGreaterThanCommand(GreaterThanCommand command) {
        command.execute();
    }

    @Override
    public void visitLessThanCommand(LessThanCommand command) {
        command.execute();
    }


    @Override
    public boolean visitOpenBracketCommand(OpenBracket command) {
        command.execute();
       return command.isStatus();
    }

    @Override
    public boolean visitCloseBracketCommand(CloseBracket command) {
        command.execute();
        return command.isStatus();
    }

    @Override
    public void visitDotCommand(DotCommand command) {
        command.execute();
    }
}
