package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage{
    public CartPage cartPage;
    private final static String pagePath = "/inventory.html";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'app_logo') and contains(text(), 'Swag Labs')]");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartButtonLocator = By.id("shopping_cart_container");

    // Блок инициализации
    public InventoryPage(WebDriver driver){
        super(driver);

        cartPage = new CartPage(driver);
    }

    public void openPageByUrl(String pagePath) {
         super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    // Блок атомарных методов

    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getShoppingCartButton() {
        return driver.findElement(shoppingCartButtonLocator);
    }
}
