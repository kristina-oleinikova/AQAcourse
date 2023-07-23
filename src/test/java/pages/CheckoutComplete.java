package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutComplete extends BasePage {

    private final static String pagePath = "/checkout-complete.html";

    // Блок описания локаторов для элементов
    private final By backHomeButtonLocator = By.id("back-to-products");

    // Блок инициализации

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }

    // Блок атомарных методов

    public WebElement getBackToHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }
}
