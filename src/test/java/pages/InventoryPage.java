package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {
    public CartPage cartPage;
    private final static String pagePath = "/inventory.html";

    // Блок описания локаторов для элементов
    @FindBy(xpath = "//div[contains(@class, 'app_logo') and contains(text(), 'Swag Labs')]")
    public WebElement headerTitleLabel;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButton;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;

    // Блок инициализации
    public InventoryPage(WebDriver driver) {
        super(driver);

        cartPage = new CartPage(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//div[contains(@class, 'app_logo') and contains(text(), 'Swag Labs')]");
    }

    @Step("Add item to basket")
    public InventoryPage addItemToBasket(){
        addToCartButton.click();
        return this;
    }

    @Step("Click on Basket icon to navigate to Cart page")
    public CartPage openCart(){
        shoppingCartButton.click();
        return new CartPage(driver);
    }
}
