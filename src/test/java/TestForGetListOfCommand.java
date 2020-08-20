import model.command.Command;
import model.compiler.Compiler;
import model.lexeme.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestForGetListOfCommand {
    Compiler compiler;
    String helloWorldWithLoops="++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>";

    @Before
    public void setUp() {
       compiler= new Compiler();

}

    @Test
    public void testForHelloWorld() {
        List<Command> list= compiler.compile(helloWorldWithLoops);
        Assert.assertEquals(11,list.size() );
    }

}