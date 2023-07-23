package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final static String pagePath = "/cart.html";

    // Блок описания локаторов для элементов
    private final By checkoutButtonLocator = By.id("checkout");


    // Блок инициализации
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }
}
