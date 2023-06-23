import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Parameters({"", ""})
    @Test
    public void paramTest(String login, System psw){
        System.out.println("Login is " + login);
        System.out.println("Password is " + psw);
    }
}
