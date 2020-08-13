package model.compiler;

import model.visitor.PreOrderTreeVisitor;

public class Compiler {
    public Compiler() {
    }

   private OutputData outputData= new OutputData();

    public void printResult() {

        System.out.println(outputData.getOutput());
    }
    public String getResult(){
        return outputData.getOutput().toString();
    }


        public void compile(String code)  {
            InputData inputData = new InputData(code);

            PreOrderTreeVisitor visitor = new PreOrderTreeVisitor(inputData,outputData);
            visitor.visit(code);
        }
    }

