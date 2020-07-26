package model.visitor;


import model.command.*;
import tree.CommandTreeCreator;
import tree.MyTreeNode;

import java.util.LinkedList;
import java.util.ListIterator;

public class PreOrderTreeVisitor {
    public PreOrderTreeVisitor() {
    }
   private boolean inLoop=false;

    private CommandTreeCreator treeConvector = new CommandTreeCreator();
    ListIterator<MyTreeNode> commandIterator;

    public void visit(String code) {
        treeConvector.createTree(code);
        commandIterator = treeConvector.getRoot().getChildren().listIterator();
        traverseEachNode(treeConvector.getRoot());

    }


    private void traverseEachNode(MyTreeNode node) {

        CommandVisitor commandVisitor = new CommandVisitor();
        if(!inLoop && commandIterator.hasNext()){

            node=commandIterator.next();
            convertCommand(node, commandVisitor);

            traverseEachNode(node);
        }
        else{LinkedList<MyTreeNode<String>> listOfNode = node.getChildren();

        for (MyTreeNode each : listOfNode) {

            convertCommand(each, commandVisitor);

            traverseEachNode(each);

        }
        }



    }


    private void convertCommand(MyTreeNode<String> node, CommandVisitor commandVisitor) {

        switch (node.getData()) {
            case "+": {
                commandVisitor.visitPlusCommand(new PlusCommand());
                break;
            }
            case "-": {

                commandVisitor.visitMinusCommand(new MinusCommand());
                break;
            }
            case ">": {

                commandVisitor.visitGreaterThanCommand(new GreaterThanCommand());
                break;
            }
            case "<": {

                commandVisitor.visitLessThanCommand(new LessThanCommand());
                break;
            }
            case ".": {

                commandVisitor.visitDotCommand(new DotCommand());
                break;
            }
            case "[": {
                inLoop = true;
                boolean loopStatus = commandVisitor.visitOpenBracketCommand(new OpenBracket());
                if (loopStatus){
                    inLoop = false;}
                while (inLoop) {
                    traverseEachNode(node);
                }
                break;
            }
            case "]": {
                boolean loopStatus = commandVisitor.visitCloseBracketCommand(new CloseBracket());
                if (!loopStatus)
                { inLoop = false;}
                break;
            }
        }
    }


}
