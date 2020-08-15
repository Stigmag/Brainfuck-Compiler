package model.command;

import model.compiler.InputData;
import model.compiler.OutputData;
import model.visitor.Visitor;

public class DotCommand  implements ICommand {

    private int pointer;
    private short[] arr;
    private StringBuilder output;
    private InputData inputData;
    private OutputData outputData;

    public DotCommand(InputData inputData,OutputData outputData) {
        this.inputData=inputData;
        this.pointer = inputData.getPointer();
        this.arr = inputData.getArr();
        this.output = outputData.getOutput();
        this.outputData=outputData;
    }

    @Override
    public void execute() {
        this.outputData.setOutput(this.output.append((char) arr[pointer]));
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitDotCommand(this);
    }
}
