package steps;

import baseEntities.BaseStep;
import baseEntities.BaseTest;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.InventoryPage;

public class InventoryAddItemStep extends BaseStep {
    public InventoryAddItemStep(WebDriver driver) {
        super(driver);
    }

    public InventoryPage addItemToBasket(){
        inventoryPage.getAddToCartButton().click();
        return inventoryPage;
    }

    public CartPage openCart(){
        inventoryPage.getShoppingCartButton().click();
        return cartPage;
    }
}
