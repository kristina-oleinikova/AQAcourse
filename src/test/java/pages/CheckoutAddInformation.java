package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutAddInformation extends BasePage {

    private final static String pagePath = "/checkout-step-one.html";

    // Блок описания локаторов для элементов
    private final By continueButtonLocator = By.id("continue");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By postalCodeInputLocator = By.id("postal-code");


    // Блок инициализации

    public CheckoutAddInformation(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }


    // Блок атомарных методов

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getPostalCodeInput() {
        return driver.findElement(postalCodeInputLocator);
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
