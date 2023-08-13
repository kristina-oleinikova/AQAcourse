package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BasePage {

    private final static String pagePath = "/checkout-complete.html";

    // Блок описания локаторов для элементов
    @FindBy(id ="back-to-products")
    public WebElement backHomeButton;

    @FindBy(xpath = "//*[contains(@class, 'title') and contains (text(), 'Checkout: Complete!')]")
    public WebElement checkoutCompleteTitle;

    // Блок инициализации

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("back-to-products");
    }

    @Step("Checkout completed successfully")
    public CheckoutComplete checkCompleteTitle(){
        checkoutCompleteTitle.isDisplayed();
        return this;
    }
}
