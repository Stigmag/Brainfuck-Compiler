package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class GreaterThanCommand  implements ICommand {

    private int pointer;

    public GreaterThanCommand( ) {

        this.pointer = InputData.getPointer();
    }

    @Override
    public void execute() {
       InputData.setPointer(++this.pointer);

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGreaterThanCommand(this);
    }
}
