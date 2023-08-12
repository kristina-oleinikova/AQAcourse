package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.DashboardPage;
import steps.*;
import utils.configuration.ReadProperties;

//@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginStep = new LoginStep(driver);
        dashboardPage = new DashboardPage(driver);

//        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
