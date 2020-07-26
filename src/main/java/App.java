import model.compiler.Compiler;

public class App {
    public static void main(String[] args)   {
        Compiler compiler= new Compiler();
        String code="++++++++[>++++++++++++>+++++++++++++<<-]>++++.-.>+++++++.<+.+.";
compiler.compile(code);
compiler.printResult();

    }
}
