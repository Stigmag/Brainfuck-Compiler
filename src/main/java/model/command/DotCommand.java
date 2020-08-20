package model.command;

import model.compiler.Memory;

public class DotCommand extends Command {
    @Override
    public void execute(Memory memory) {
        memory.setOutput(memory.getOutput().append((char) memory.getArr()[memory.getPointer()]));
    }
}
