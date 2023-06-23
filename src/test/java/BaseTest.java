import org.testng.annotations.*;

public class BaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass: ....");
        calculator = new Calculator();
        calculator.setLevel(this.getClass().toString());
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite: ....");
    }

    @BeforeGroups
    public void beforeGroup(){
        System.out.println("BeforeGroup: ....");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest: ....");
        calculator = new Calculator();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod: ....");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite: ....");
    }

    @AfterGroups
    public void afterGroup(){
        System.out.println("AfterGroup: ....");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest: ....");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass: ....");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod: ....");
    }
}
