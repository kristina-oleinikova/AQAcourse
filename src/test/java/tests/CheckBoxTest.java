package tests;

import baseEntities.BaseTest;
import elements.CheckBox;
import org.testng.annotations.Test;
import pages.EditProjectsPage;
import utils.configuration.ReadProperties;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkboxTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        EditProjectsPage editProjectsPage = new EditProjectsPage(driver);
        editProjectsPage.openPageByUrl();

        CheckBox checkBox = editProjectsPage.getCheckbox();
        checkBox.setFlag();
    }
}
