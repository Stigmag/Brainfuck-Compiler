package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class LessThanCommand  implements ICommand {

    private int pointer;
    private InputData inputData;

    public LessThanCommand(InputData inputData) {
        this.inputData=inputData;
        this.pointer = inputData.getPointer();
    }

    @Override
    public void execute() {
        this.inputData.setPointer(--this.pointer);

    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitLessThanCommand(this);
    }
}