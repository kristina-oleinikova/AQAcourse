import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Parameters({"Login-value", "Psw-value"})
    @Test
    public void paramTest(@Optional("Default login") String login, @Optional("Default psw") String psw){
        System.out.println("Login is " + login);
        System.out.println("Password is " + psw);
    }
}
