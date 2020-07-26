package model.command;

import model.compiler.InputData;
import model.compiler.OutputData;
import model.visitor.Visitor;

public class DotCommand  implements ICommand {

    private int pointer;
    private short[] arr;

    private StringBuilder output;

    public DotCommand() {
        this.pointer = InputData.getPointer();
        this.arr = InputData.getArr();
        this.output = OutputData.output;
    }

    @Override
    public void execute() {

       this.output.append((char) arr[pointer]);

    }
    @Override
    public void accept(Visitor visitor) {
         visitor.visitDotCommand(this);
    }
}
