package tests;

import baseEntities.BaseTest;
import elements.Dropdown;
import elements.GroupOfRadioButtons;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTestCasePage;
import pages.EditProjectsPage;
import utils.configuration.ReadProperties;

public class DropdownTest extends BaseTest {


    @Test
    public void dropdownTest() throws InterruptedException {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
        addTestCasePage.openPageByUrl();

        Dropdown dropdown = new Dropdown(driver, "template_id");
        dropdown.select();
        Assert.assertTrue(dropdown.isOptionsVisible());
        dropdown.selectFirstOption();
        Assert.assertTrue(dropdown.firstOptionIsSelected());

        Thread.sleep(3000);
    }
}
