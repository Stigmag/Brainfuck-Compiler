package model.compiler;

public class InputData {

    private static final int STACK_LENGHT = 30000;
    private short[] arr;
    private int pointer;
    private String code;

    public InputData(String code) {
        this.arr = new short[STACK_LENGHT];
        this.pointer = 0;
        this.code = code;
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

}
