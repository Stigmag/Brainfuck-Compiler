package model.command;

import model.compiler.Memory;

import java.util.List;

public class LoopCommand extends Command {
    private List<Command> innerCommand;

    public LoopCommand(List<Command> innerCommand) {
        this.innerCommand = innerCommand;
    }

    @Override
    public void execute(Memory memory) {
        while (memory.getArr()[memory.getPointer()] != 0) {
            for (Command command : this.innerCommand
            ) {
                command.execute(memory);

            }
        }
    }
}


