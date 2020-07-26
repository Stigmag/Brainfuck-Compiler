package model.compiler;

public class InputData {
    private static final int STACK_LENGHT = 30000;
    private static short[] arr = new short[STACK_LENGHT];
    private static int pointer = 0;
    private String code;

    public InputData(String code)  {


        this.code = code;
    }

    public static short[] getArr() {
        return arr;
    }

    public static int getPointer() {
        return pointer;
    }

    public static void setPointer(int pointer) {
        InputData.pointer = pointer;
    }


}
