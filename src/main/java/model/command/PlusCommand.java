package model.command;

import model.compiler.Memory;

public class PlusCommand extends Command {
    public static final int MAX_CHAR_SIZE = 255;

    @Override
    public void execute(Memory memory) {
        if ((memory.getArr()[memory.getPointer()] + 1) > MAX_CHAR_SIZE) memory.getArr()[memory.getPointer()] = 0;
        else ++memory.getArr()[memory.getPointer()];


    }
}
