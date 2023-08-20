package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutAddInformation extends BasePage {

    private final static String pagePath = "/checkout-step-one.html";

    // Блок описания локаторов для элементов
    private final By continueButtonLocator = By.id("continue");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By postalCodeInputLocator = By.id("postal-code");


    // Блок инициализации

    public CheckoutAddInformation() {
        super();
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }


    // Блок атомарных методов

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator);
    }

    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator);
    }

    public SelenideElement getPostalCodeInput() {
        return $(postalCodeInputLocator);
    }

    public void setFirstName(String value) {
        getFirstNameInput().sendKeys(value);
    }

    public void setLastName(String value) {
        getLastNameInput().sendKeys(value);
    }

    public void setPostalCode(String value) {
        getPostalCodeInput().sendKeys(value);
    }


    public void addInfoInForm(String firstName, String lastName,String postalCode){
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
    }
}
