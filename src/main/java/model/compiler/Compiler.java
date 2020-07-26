package model.compiler;

import model.visitor.PreOrderTreeVisitor;

public class Compiler {
    public Compiler() {
    }

    private PreOrderTreeVisitor visitor = new PreOrderTreeVisitor();

    public void printResult() {

        System.out.println(OutputData.output);
    }
    public String getResult(){
        return OutputData.output.toString();
    }

    public void compile(String code)  {
        InputData inputData = new InputData(code);
        visitor.visit(code);
    }
}