package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage extends BasePage{
    public CartPage cartPage;
    private final static String pagePath = "/inventory.html";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'app_logo') and contains(text(), 'Swag Labs')]");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartButtonLocator = By.id("shopping_cart_container");

    // Блок инициализации
    public InventoryPage(){
        super();

        cartPage = new CartPage();
    }

    public void openPageByUrl(String pagePath) {
         super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    // Блок атомарных методов

    public SelenideElement getHeaderTitle() {
        return $(headerTitleLabelLocator);
    }

    public SelenideElement getAddToCartButton() {
        return $(addToCartButtonLocator);
    }

    public SelenideElement getShoppingCartButton() {
        return $(shoppingCartButtonLocator);
    }
}
