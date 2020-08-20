package model.compiler;

import model.command.Command;
import model.lexeme.Lexeme;
import model.lexeme.LexemeEnum;
import model.visitor.CommandVisitor;

import java.util.*;

public class Compiler {

    public List<Command> compile(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Empty instruction!");
        }
        Deque<List<Command>> commands = new ArrayDeque<>();
        List<Command> listOfCommand = new ArrayList<>();
        commands.push(listOfCommand);
        CommandVisitor visitor = new CommandVisitor(commands);
        List<Lexeme> listOfLexeme = getListOfLexemes(code);
        for (Lexeme lexeme : listOfLexeme
        ) {
            lexeme.accept(visitor);
        }
        return commands.pop();
    }

    public List<Lexeme> getListOfLexemes(String code) {
        List<Lexeme> listOfLexemes = new ArrayList<>();
        for (String value : code.split("")
        ) {
            LexemeEnum lexeme = LexemeEnum.fromString(value);
            listOfLexemes.add(lexeme.create());

        }
        return listOfLexemes;
    }

}


