package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitService;

import java.util.List;

public class ActionsTests_HW extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        WebElement contextMenu = waitService.waitForVisibilityLocatedBy(By.id("hot-spot"));

        actions
                .moveToElement(contextMenu, 10, 10)
                .contextClick(contextMenu)
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");

        alert.accept();
    }

    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitService waitService = new WaitService(driver);
        WebElement checkbox = waitService.waitForExists(By.id("checkbox"));
        WebElement inputType = waitService.waitForVisibilityLocatedBy(By.xpath("//input[@type='text']"));

        waitService.waitForVisibilityLocatedBy(By.xpath("//button[text()='Remove']")).click();
        Assert.assertEquals(waitService.waitForVisibilityLocatedBy(By.id("message")).getText(),"It's gone!");
        Assert.assertTrue(waitService.waitForElementInvisible(checkbox));
        Assert.assertFalse(inputType.isEnabled());
        waitService.waitForExists(By.xpath("//button[text()='Enable']")).click();
        Assert.assertEquals(waitService.waitForVisibilityLocatedBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(inputType.isEnabled());
    }

    @Test
    public void uploadFile(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WaitService waitService = new WaitService(driver);

        WebElement fileUploadElement = waitService.waitForExists(By.xpath("//form/input[@type='file']"));
        String pathToFile = ActionTests.class.getClassLoader().getResource("screenHW.png").getPath();
        fileUploadElement.sendKeys(pathToFile);

        waitService.waitForVisibilityLocatedBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitService.waitForVisibilityLocatedBy(By.id("uploaded-files")).getText(),
                "screenHW.png");
    }

    @Test
    public void checkIframeParagraphContent(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        WaitService waitService = new WaitService(driver);

        driver.switchTo().frame("mce_0_ifr");
        Assert.assertTrue(waitService.waitForVisibilityLocatedBy(By.id("tinymce")).isDisplayed());
        Assert.assertEquals(waitService.waitForVisibilityLocatedBy(By.xpath("//p")).getText(),
                "Your content goes here.");
    }
}
