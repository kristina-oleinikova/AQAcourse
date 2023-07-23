package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverview extends BasePage {

    private final static String pagePath = "/checkout-step-two.html";

    // Блок описания локаторов для элементов
    private final By FinishButtonLocator = By.id("finish");

    // Блок инициализации

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return FinishButtonLocator;
    }

    // Блок атомарных методов

    public WebElement getFinishButton() {
        return driver.findElement(FinishButtonLocator);
    }
}
