package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class CloseBracket implements ICommand {
    private boolean status;
    private short[] arr;
    private int pointer;

    public CloseBracket() {
        this.status =false;
        this.arr = InputData.getArr();
        this.pointer = InputData.getPointer();
    }

    public boolean isStatus() {
        return status;
    }


    @Override
    public void execute() {

        if(InputData.getArr()[InputData.getPointer()]!=0)
         this.status=true;
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visitCloseBracketCommand(this);
    }

}
