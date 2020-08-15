package model.compiler;

import model.visitor.PreOrderTreeVisitor;

public class Compiler {

    private OutputData outputData = new OutputData();

    public void printResult() {

        System.out.println(outputData.getOutput());
    }

    public String getResult() {
        return outputData.getOutput().toString();
    }

    public void compile(String code) {
        if(code!=""){
        InputData inputData = new InputData(code);

        PreOrderTreeVisitor visitor = new PreOrderTreeVisitor(inputData, outputData);
        visitor.visit(code);}
        else outputData.setOutput(new StringBuilder("ERROR! EMPTY STRING! PLEASE, ENTER STRING!"));

    }
}

