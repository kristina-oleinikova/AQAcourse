import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void calculateElectricFloorHeating () throws InterruptedException {


        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement weightInput = driver.findElement(By.id("el_f_width"));
        WebElement lenghtInput = driver.findElement(By.id("el_f_lenght"));
        WebElement calcButton = driver.findElement(By.name("button"));

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement);
        WebElement selectWebElement1 = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement1);

        weightInput.sendKeys("5");
        lenghtInput.sendKeys("4");

        selectRoomType.selectByIndex(1);
        Thread.sleep(2000);

        selectHeatingType.selectByIndex(1);
        Thread.sleep(2000);
        calcButton.click();
        Thread.sleep(2000);

        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));

        Assert.assertEquals(floorCablePower.getAttribute("value"), "2400", "Incorrect value");
        Assert.assertEquals(specFloorCablePower.getAttribute("value"), "120", "Incorrect value");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
