package tests;

import baseEntities.BaseTest;
import elements.TableCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import utils.configuration.ReadProperties;

public class WrappersTest extends BaseTest {

    @Test
    public void testName(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes input"));

    }

    public void setCheckBox (WebElement webElement){
        if(!webElement.isSelected()){
            webElement.click();
        }
    }

    public void removeCheckBox (WebElement webElement){
        if(!webElement.isSelected()){
            webElement.click();
        }
    }

    @Test
    public void tableTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();

        TableCell cell = projectsPage.getProjectsTable().getCell("Project", 1);
        cell.getLink().click();
    }
}
