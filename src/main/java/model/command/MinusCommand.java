package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class MinusCommand implements ICommand {


    private short[] arr;
    private int pointer;
    private InputData inputData;

    public MinusCommand(InputData inputData) {
        this.inputData=inputData;
        this.arr = inputData.getArr();
        this.pointer =inputData.getPointer();
    }

    @Override
    public void execute() {
        if ((this.arr[pointer]-1) < 0) this.arr[pointer] = 255;
        else --this.arr[pointer];
        this.inputData.setArr(this.arr);

    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMinusCommand(this);
    }

}
