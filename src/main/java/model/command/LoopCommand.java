package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class LoopCommand  implements ICommand {
    private boolean status;
    private short[] arr;
    private int pointer;

    public LoopCommand(InputData inputData) {
        this.status = false;
        this.arr = inputData.getArr();
        this.pointer = inputData.getPointer();
    }



    public boolean isStatus() {
        return status;
    }

    @Override
    public void execute() {
        this.status= this.arr[this.pointer] != 0;
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visitLoopCommand(this);
    }
}
