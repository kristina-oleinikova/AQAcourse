package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverview extends BasePage {

    private final static String pagePath = "/checkout-step-two.html";

    // Блок описания локаторов для элементов
    private final By FinishButtonLocator = By.id("finish");

    // Блок инициализации

    public CheckoutOverview() {
        super();
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return FinishButtonLocator;
    }

    // Блок атомарных методов

    public SelenideElement getFinishButton() {
        return $(FinishButtonLocator);
    }
}
