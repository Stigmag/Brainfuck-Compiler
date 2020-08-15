package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class PlusCommand implements ICommand {

    private short[] arr;
    private int pointer;
    private InputData inputData;
    public static final int MAX_CHAR_SIZE=255;

    public PlusCommand(InputData inputData) {
        this.inputData = inputData;
        this.arr = inputData.getArr();
        this.pointer = inputData.getPointer();
    }

    @Override
    public void execute() {
        if ((this.arr[pointer] + 1) > MAX_CHAR_SIZE) this.arr[pointer] = 0;
        else ++this.arr[pointer];
        this.inputData.setArr(this.arr);

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlusCommand(this);
    }

}
