package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutAddInformation extends BasePage {

    private final static String pagePath = "/checkout-step-one.html";

    // Блок описания локаторов для элементов
    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;


    // Блок инициализации

    public CheckoutAddInformation(WebDriver driver) {
        super(driver);
    }

    public void openPageByUrl(String pagePath) {
        super.openPageByUrl(pagePath);
    }

    @Override
    protected By getPageIdentifier() {
        return By.id("continue");
    }


    // Блок атомарных методов

    public void setFirstName(String value) {
        firstNameInput.sendKeys(value);
    }

    public void setLastName(String value) {
        lastNameInput.sendKeys(value);
    }

    public void setPostalCode(String value) {
        postalCodeInput.sendKeys(value);
    }


    public void addInfoInForm(String firstName, String lastName,String postalCode){
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
    }

    @Step("Fill the form with valid data")
    public CheckoutAddInformation fillFormWithValidData(){
        addInfoInForm("1234","1234","1234");
        return this;
    }

    @Step("Submit the form")
    public CheckoutOverview continueCheckout(){
        continueButton.click();
        return new CheckoutOverview(driver);
    }
}
