package model.compiler;

public class OutputData {
    public static StringBuilder output= new StringBuilder();


    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        OutputData.output = output;
    }
}
