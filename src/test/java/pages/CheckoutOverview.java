package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverview extends BasePage {

    private final static String pagePath = "/checkout-step-two.html";

    // Блок описания локаторов для элементов
    @FindBy(id = "finish")
    public WebElement finishButton;

    // Блок инициализации

    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("finish");
    }

    @Step("Overview order details & click on 'Finish' button")
    public CheckoutComplete clickFinish(){
        finishButton.click();
        return new CheckoutComplete(driver);
    }
}
