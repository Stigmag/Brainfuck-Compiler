package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class LessThanCommand  implements ICommand {

    private int pointer;

    public LessThanCommand() {

        this.pointer = InputData.getPointer();
    }

    @Override
    public void execute() {
        InputData.setPointer(--this.pointer);

    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLessThanCommand(this);
    }
}