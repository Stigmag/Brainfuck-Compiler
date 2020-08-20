package model.command;

import model.compiler.Memory;

public class MinusCommand extends Command {
    public static final int MAX_CHAR_SIZE = 255;

    @Override
    public void execute(Memory memory) {
        if ((memory.getArr()[memory.getPointer()] - 1) < 0) memory.getArr()[memory.getPointer()] = MAX_CHAR_SIZE;
        else --memory.getArr()[memory.getPointer()];


    }
}
