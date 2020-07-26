import model.compiler.Compiler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestForCompiler {
    Compiler compiler;
    String dCode="++++++++[>++++++++++++>+++++++++++++<<-]>++++.-.>+++++++.<+.+.";
    String helloWorld="++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";

    @Before
    public void setUp() {
       compiler= new Compiler();

}

    @Test
    public void testFroDCode() {
        compiler.compile(dCode);
        Assert.assertEquals("dcode",compiler.getResult() );
    }
    @Test
    public void testFroHelloWorld() {
        compiler.compile(helloWorld);
        Assert.assertEquals("Hello World!\n",compiler.getResult() );
    }
}