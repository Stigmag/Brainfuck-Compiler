import model.compiler.Compiler;
import model.lexeme.Lexeme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestForGetListOfLexeme {
    Compiler compiler;
    String dCode="++++++++[";

    @Before
    public void setUp() {
       compiler= new Compiler();

}

    @Test
    public void testForDCode() {
        List<Lexeme> list= compiler.getListOfLexemes(dCode);
        Assert.assertEquals(9,list.size() );
    }

}