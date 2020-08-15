package model.command;

import model.visitor.Visitor;

public interface ICommand {
    void execute();
    void accept(Visitor visitor);
}
