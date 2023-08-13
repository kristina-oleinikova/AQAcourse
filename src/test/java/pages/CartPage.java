package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    private final static String pagePath = "/cart.html";

    // Блок описания локаторов для элементов
    @FindBy(id = "checkout")
    public WebElement checkoutButton;


    // Блок инициализации
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("checkout");
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Step("Click on 'Checkout' button to start the process")
    public CheckoutAddInformation clickCheckout(){
        checkoutButton.click();
        return new CheckoutAddInformation(driver);
    }
}
