package model.visitor;


import model.command.*;
import model.compiler.InputData;
import model.compiler.OutputData;
import tree.CommandTreeCreator;
import tree.MyTreeNode;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class PreOrderTreeVisitor {


    private boolean isLoop = false;
    private InputData inputData;
    private OutputData outputData;
    private CommandTreeCreator treeConvector = new CommandTreeCreator();
    private ListIterator<MyTreeNode> commandIterator;
    private Stack<ListIterator<MyTreeNode>> stackForLoops = new Stack<>();

    private MyTreeNode nextCommand;
    private boolean isExit = false;

    public PreOrderTreeVisitor(InputData inputData, OutputData outputData) {
        this.inputData = inputData;
        this.outputData = outputData;

    }


    public void visit(String code) {
        treeConvector.createTree(code);
        commandIterator = treeConvector.getRoot().getChildren().listIterator();
        traverseEachNode(treeConvector.getRoot(), commandIterator);

    }


    private void traverseEachNode(MyTreeNode node, ListIterator<MyTreeNode> commandIterator) {

        CommandVisitor commandVisitor = new CommandVisitor();

        if (commandIterator.hasNext()) {

            node = commandIterator.next();
            convertCommand(node, commandVisitor, commandIterator);


            traverseEachNode(node, commandIterator);
            return;
        }


    }




    private void convertCommand(MyTreeNode<String> node, CommandVisitor commandVisitor, ListIterator<MyTreeNode> currentCommandIterator) {

        switch (node.getData()) {
            case "+": {
                commandVisitor.visitPlusCommand(new PlusCommand(inputData));
                break;
            }
            case "-": {

                commandVisitor.visitMinusCommand(new MinusCommand(inputData));
                break;
            }
            case ">": {

                commandVisitor.visitGreaterThanCommand(new GreaterThanCommand(inputData));
                break;
            }
            case "<": {

                commandVisitor.visitLessThanCommand(new LessThanCommand(inputData));
                break;
            }
            case ".": {

                commandVisitor.visitDotCommand(new DotCommand(inputData, outputData));
                break;
            }
            case "[": {
                isLoop = true;
                stackForLoops.push(currentCommandIterator);
                boolean loopStatus = commandVisitor.visitLoopCommand(new LoopCommand(inputData));
                if (loopStatus) {
                    isLoop = true;

                    if (stackForLoops.peek().hasNext()) {
                        nextCommand = stackForLoops.peek().next();
                    }
                }
                ListIterator<MyTreeNode> loopIterator = node.getChildren().listIterator();
                while (isLoop) {

                    traverseEachNode(node, loopIterator);
                    return;

                }


                break;
            }
            case "]": {
                boolean loopStatus = commandVisitor.visitLoopCommand(new LoopCommand(inputData));
                if (!loopStatus) {
                    if (stackForLoops.peek().hasPrevious()) stackForLoops.peek().previous();

                    traverseEachNode(nextCommand, stackForLoops.pop());
                } else {
                    ListIterator<MyTreeNode> resetLoopCommand = node.getParent().getChildren().listIterator();

                    traverseEachNode(node.getParent(), resetLoopCommand);
                    return;
                }


                break;
            }
        }


    }

}

