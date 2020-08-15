package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class LoopCommand implements ICommand {

    private boolean checkedLoopStatus;
    private short[] arr;
    private int pointer;

    public LoopCommand(InputData inputData) {
        this.checkedLoopStatus = false;
        this.arr = inputData.getArr();
        this.pointer = inputData.getPointer();
    }

    public boolean isStatus() {
        return checkedLoopStatus;
    }

    @Override
    public void execute() {
        this.checkedLoopStatus = this.arr[this.pointer] != 0;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLoopCommand(this);
    }
}
