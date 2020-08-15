import model.compiler.Compiler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestForCompiler {
    Compiler compiler;
    String dCode="++++++++[>++++++++++++>+++++++++++++<<-]>++++.-.>+++++++.<+.+.";
    String helloWorld="++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
    String helloWorldWithLoops="++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
    String emptyString="";
    @Before
    public void setUp() {
       compiler= new Compiler();

}

    @Test
    public void testForDCode() {
        compiler.compile(dCode);
        Assert.assertEquals("dcode",compiler.getResult() );
    }
    @Test
    public void testForHelloWorld() {
        compiler.compile(helloWorld);
        Assert.assertEquals("Hello World!\n",compiler.getResult() );
    }
    @Test
    public void testForHelloWorldWithLoops() {
        compiler.compile(helloWorldWithLoops);
        Assert.assertEquals("Hello World!\n",compiler.getResult() );
    }
    @Test
    public void testForEmptyString() {
        compiler.compile(emptyString);
        Assert.assertEquals("ERROR! EMPTY STRING! PLEASE, ENTER STRING!",compiler.getResult() );
    }
}