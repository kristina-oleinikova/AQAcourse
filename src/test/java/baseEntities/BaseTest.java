package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.configuration.ReadProperties;

@Listeners(InvokedListener.class)
//@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        driver.get(ReadProperties.getUrl());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
