package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class OpenBracket implements ICommand {
    private boolean status;
    private short[] arr;
    private int pointer;

    public OpenBracket() {
        this.status = false;
        this.arr = InputData.getArr();
        this.pointer = InputData.getPointer();
    }



    public boolean isStatus() {
        return status;
    }

    @Override
    public void execute() {
        if(arr[pointer] == 0)

        this.status=true;
    }

    @Override
    public void accept(Visitor visitor) {

            visitor.visitOpenBracketCommand(this);
    }
}
