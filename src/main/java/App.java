import model.CommandExecutor;
import model.compiler.Compiler;

public class App {
    public static void main(String[] args)   {
        Compiler compiler= new Compiler();
        CommandExecutor commandExecutor= new CommandExecutor();
        String code="";
   System.out.println(commandExecutor.commandExecute(compiler.compile(code)));


    }
}
