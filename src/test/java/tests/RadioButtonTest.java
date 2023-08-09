package tests;

import baseEntities.BaseTest;
import elements.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.EditProjectsPage;
import utils.configuration.ReadProperties;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonTest extends BaseTest {


    @Test
    public void radioButtonTestByName() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        EditProjectsPage editProjectsPage = new EditProjectsPage(driver);
        editProjectsPage.openPageByUrl();

        GroupOfRadioButtons groupOfRadioButtons = editProjectsPage.getSuiteModeRadioButtons();
        groupOfRadioButtons.selectByText("Use multiple test suites to manage cases");
    }

    @Test
    public void radioButtonTestByIndex() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        EditProjectsPage editProjectsPage = new EditProjectsPage(driver);
        editProjectsPage.openPageByUrl();

        GroupOfRadioButtons groupOfRadioButtons = editProjectsPage.getSuiteModeRadioButtons();
        groupOfRadioButtons.selectByIndex(2);

    }

    @Test
    public void radioButtonTestByValue() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        EditProjectsPage editProjectsPage = new EditProjectsPage(driver);
        editProjectsPage.openPageByUrl();

        GroupOfRadioButtons groupOfRadioButtons = editProjectsPage.getSuiteModeRadioButtons();
        groupOfRadioButtons.selectByValue("2");
    }
}
