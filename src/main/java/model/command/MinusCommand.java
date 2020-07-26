package model.command;

import model.compiler.InputData;
import model.visitor.Visitor;

public class MinusCommand implements ICommand {


        private short[] arr;
        private int pointer;

        public MinusCommand() {
            this.arr = InputData.getArr();
            this.pointer =InputData.getPointer();
        }

        @Override
        public void execute() {
            if ((arr[pointer]-1) < 0) this.arr[pointer] = 255;
            else --this.arr[pointer];

        }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMinusCommand(this);
    }

}
