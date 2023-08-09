package pages;

import baseEntities.BasePage;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EditProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/edit/1/1";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.className("page_title");
    private final By checkboxLocator = By.id("show_announcement");


    // Блок инициализации
    public EditProjectsPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public CheckBox getCheckbox(){
        return new CheckBox(driver, checkboxLocator);
    }

    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public GroupOfRadioButtons getSuiteModeRadioButtons() {
        return new GroupOfRadioButtons(driver, "suite_mode");
    }
}
