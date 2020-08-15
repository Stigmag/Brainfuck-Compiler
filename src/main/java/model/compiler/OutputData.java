package model.compiler;

public class OutputData {

    private StringBuilder output;

    public OutputData() {
        this.output = new StringBuilder();
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        this.output = output;
    }
}
