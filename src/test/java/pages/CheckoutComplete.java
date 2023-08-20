package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutComplete extends BasePage {

    private final static String pagePath = "/checkout-complete.html";

    // Блок описания локаторов для элементов
    private final By backHomeButtonLocator = By.id("back-to-products");
    private final By checkoutCompleteTitleLocator = By.xpath(
            "//*[contains(@class, 'title') and contains (text(), 'Checkout: Complete!')]"
    );

    // Блок инициализации

    public CheckoutComplete() {
        super();
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return backHomeButtonLocator;
    }

    // Блок атомарных методов

    public SelenideElement getBackToHomeButton() {
        return $(backHomeButtonLocator);
    }

    public SelenideElement getCheckoutCompleteTitle() {
        return $(checkoutCompleteTitleLocator);
    }
}
