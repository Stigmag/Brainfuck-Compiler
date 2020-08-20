package model;

import model.command.Command;
import model.compiler.Memory;

import java.util.List;

public class CommandExecutor {
    public String commandExecute(List<Command> commands){
        Memory memory= new Memory();

        for (Command command: commands
             ) {
            command.execute(memory);
        }
        return memory.getOutput().toString();
    }
}
