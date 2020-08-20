package model.compiler;

public class Memory {

    private static final int STACK_LENGHT = 30000;
    private short[] arr;
    private int pointer;
    private StringBuilder output;


    public Memory() {
        this.arr = new short[STACK_LENGHT];
        this.pointer = 0;
        this.output = new StringBuilder();

    }

    public short[] getArr() {
        return this.arr;
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setArr(short[] arr) {
        this.arr = arr;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        this.output = output;
    }

}
