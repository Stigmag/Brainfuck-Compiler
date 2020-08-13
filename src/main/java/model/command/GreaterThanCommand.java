package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class GreaterThanCommand  implements ICommand {

    private int pointer;
    private InputData inputData;
    public GreaterThanCommand( InputData inputData) {
        this.inputData=inputData;
        this.pointer = inputData.getPointer();
    }

    @Override
    public void execute() {
        this.inputData.setPointer(++this.pointer);

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGreaterThanCommand(this);
    }
}
