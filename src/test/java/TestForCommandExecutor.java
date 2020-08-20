import model.CommandExecutor;
import model.command.Command;
import model.compiler.Compiler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestForCommandExecutor {
    Compiler compiler;
    CommandExecutor commandExecutor;
    String helloWorldWithLoops="++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
    @Before
    public void setUp() {
       compiler= new Compiler();
       commandExecutor= new CommandExecutor();

}

    @Test
    public void testForHelloWorld() {
        List<Command> list= compiler.compile(helloWorldWithLoops);
       String output= commandExecutor.commandExecute(list);
        Assert.assertEquals("Hello World!\n",output );
    }

}