package model.command;


import model.compiler.Memory;

public class GreaterThanCommand extends Command {

    @Override
    public void execute(Memory memory) {
        int pointer = memory.getPointer() + 1;
        memory.setPointer(pointer);

    }
}
