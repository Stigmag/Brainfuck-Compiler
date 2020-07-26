package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class PlusCommand implements ICommand {

    private short[] arr;
    private int pointer;

    public PlusCommand() {
        this.arr = InputData.getArr();
        this.pointer = InputData.getPointer();
    }

    @Override
    public void execute() {
        if ((arr[pointer]+1) > 255) this.arr[pointer] = 0;
        else ++this.arr[pointer];

    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlusCommand(this);
    }

}
