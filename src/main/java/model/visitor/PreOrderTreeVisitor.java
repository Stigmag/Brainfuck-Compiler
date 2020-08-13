package model.visitor;


import model.command.*;
import model.compiler.InputData;
import model.compiler.OutputData;
import tree.CommandTreeCreator;
import tree.MyTreeNode;

import java.util.LinkedList;
import java.util.ListIterator;


public class PreOrderTreeVisitor {
    private boolean inLoop = false;
    private boolean endLoop = false;
    private CommandTreeCreator treeConvector = new CommandTreeCreator();
    private int numberOfOpenBracket = 0;
    private int indexOfNextCommand = 0;
    private MyTreeNode nextCommand;
    private InputData inputData;
    private OutputData outputData;

    private ListIterator<MyTreeNode> commandIterator;
    private ListIterator<MyTreeNode> loopCommandIterator;
    private boolean exit = false;

    public PreOrderTreeVisitor(InputData inputData, OutputData outputData) {
        this.inputData = inputData;
        this.outputData = outputData;

    }


    public void visit(String code) {
        treeConvector.createTree(code);
        commandIterator = treeConvector.getRoot().getChildren().listIterator();

        traverseEachNode(treeConvector.getRoot());

    }


    private void traverseEachNode(MyTreeNode node) {
        CommandVisitor commandVisitor = new CommandVisitor();
        if (!exit) {
            if (!inLoop && commandIterator.hasNext()) {

                loopCommandIterator = commandIterator;
                node = commandIterator.next();
                convertCommand(node, commandVisitor);
                if (commandIterator.hasNext())
                    traverseEachNode(node);
                else exit = true;


            } else {
                LinkedList<MyTreeNode<String>> listOfNode = node.getChildren();
                for (int i = 0; i < listOfNode.size(); i++) {
                    if (endLoop) {
                        i = indexOfNextCommand;
                        endLoop = false;

                    }
                    if (numberOfOpenBracket % 2 != 0 && loopCommandIterator.hasNext()) {

                        loopCommandIterator.next();
                    }

                    node = listOfNode.get(i);

                    convertCommand(node, commandVisitor);
                    traverseEachNode(node);


                }


            }

        }

    }


    private void convertCommand(MyTreeNode<String> node, CommandVisitor commandVisitor) {
        if (!exit) {
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

                    commandVisitor.visitDotCommand(new DotCommand(inputData,outputData));
                    break;
                }
                case "[": {

                    numberOfOpenBracket++;

                    indexOfNextCommand = loopCommandIterator.nextIndex();
                    if (loopCommandIterator.hasNext()) {
                        nextCommand = loopCommandIterator.next();
                    }


                    if (numberOfOpenBracket % 2 != 0) {

                        loopCommandIterator = node.getChildren().listIterator();
                    }
                }

                case "]": {

                    boolean loopStatus = commandVisitor.visitLoopCommand(new LoopCommand(inputData));
                    if (loopStatus) {
                        inLoop = true;
                        endLoop = false;


                    } else {
                        node = nextCommand.getParent();
                        numberOfOpenBracket--;
                        isLoopsEnd();
                        isStillLoop();
                        getPreviousElement();

                    }
                    while (inLoop) {
                        isHasNext(node);
                        if (node.hasChildren()) {
                            traverseEachNode(node);

                        } else {

                            traverseEachNode(node.getParent());
                        }
                    }
                    break;
                }

            }
        }
    }

    private void isHasNext(MyTreeNode node) {
        if (!loopCommandIterator.hasNext()) {
            loopCommandIterator = node.getParent().getChildren().listIterator();
        }
    }

    private void isLoopsEnd() {
        if (numberOfOpenBracket == 0) {
            inLoop = false;
            commandIterator.previous();

        }
    }

    private void isStillLoop() {
        if (numberOfOpenBracket % 2 != 0) {
            endLoop = true;

        }
    }

    private void getPreviousElement() {
        if (loopCommandIterator.hasPrevious()) {
            loopCommandIterator.previous();
        }
    }


}
