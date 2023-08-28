package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import io.qameta.allure.*;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

@Epic("User registration")
@Feature("User login")
@Link(name = "User Login story", type = "myLink", url = "https://example.org")
public class LoginTest extends BaseTest {
    @Test(description = "Login with valid credentials")
    @Description("Successful login with valid credentials")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("TestCase-11")
    public void successLoginTest() {
                loginStep.successLogin(DataHelper.getStandartUser()).isPageOpened();
    }

    @Test(description = "Login with invalid username")
    @Description("Failed login: invalid username + valid password")
    @Severity(SeverityLevel.MINOR)
    @Issue("BUG-1")
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setUsername("asdasd");
        user.setPassword(ReadProperties.password());

        Assert.assertEquals(
                loginStep.negativeLogin(user).getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(description = "Login with invalid password")
    @Description("Failed login: valid username + invalid password")
    @Severity(SeverityLevel.MINOR)
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword("123456");

        Assert.assertEquals(
                loginStep.negativeLogin(user).getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }

    @Test(description = "Login with short password")
    @Description("Failed login: valid username + short password")
    @Severity(SeverityLevel.TRIVIAL)
    public void shortPswLoginTest() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword("123");

        Assert.assertEquals(
                loginStep.negativeLogin(user).getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }

    @Test(description = "Failed test - verify making screenshot functionality")
    @Description("Failed login: invalid username + valid password")
    @Severity(SeverityLevel.MINOR)
    public void screenshotLoginTest() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setUsername("asdasd");

        loginStep.successLogin(user).isPageOpened();
    };
}
