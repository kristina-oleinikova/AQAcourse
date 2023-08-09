package pages;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.Dropdown;
import elements.GroupOfRadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {
    private final static String pagePath = "/index.php?/cases/add/1";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.className("page_title");
    private final By dropdownLocator = By.id("section_id_chzn");

    // Блок инициализации
    public AddTestCasePage(WebDriver driver) {
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
//    public Dropdown getDropdown(){
//        return new Dropdown(driver, dropdownLocator);
//    }


    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

}
