package model.visitor;

import model.command.*;
import model.lexeme.*;

import java.util.*;

public class CommandVisitor implements Visitor {
    private Deque<List<Command>> commands;
    private List<Command> innerCommand;

    public CommandVisitor(Deque<List<Command>> commands) {
        this.commands = commands;
        List<Command> innerCommand = new ArrayList<>();
    }


    @Override
    public void visitPlusLexeme(PlusLexeme command) {
        commands.peek().add(new PlusCommand());
    }

    @Override
    public void visitMinusLexeme(MinusLexeme command) {
        commands.peek().add(new MinusCommand());
    }

    @Override
    public void visitGreaterThanLexeme(GreaterThanLexeme command) {
        commands.peek().add(new GreaterThanCommand());
    }

    @Override
    public void visitLessThanLexeme(LessThanLexeme command) {
        commands.peek().add(new LessThanCommand());
    }

    @Override
    public void visitDotLexeme(DotLexeme command) {
        commands.peek().add(new DotCommand());

    }

    @Override
    public void visitOpenBracketLexeme(OpenBracketLexeme command) {
        commands.push(new ArrayList<Command>());
    }

    @Override
    public void visitCloseBracketLexeme(CloseBracketLexeme command) {
        innerCommand = commands.pop();
        commands.peek().add(new LoopCommand(innerCommand));
    }
}
