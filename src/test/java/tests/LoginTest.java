package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import io.qameta.allure.*;
import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
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
        Assert.assertTrue(
                new LoginPage(driver).successLogin().isPageOpened()
        );
    }

    @Test(description = "Login with invalid username")
    @Description("Failed login: invalid username + valid password")
    @Severity(SeverityLevel.MINOR)
    @Issue("BUG-1")
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setUsername("qwerty");
        user.setPassword(ReadProperties.password());

        Assert.assertEquals(
                new LoginPage(driver).negativeLogin(user).errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(description = "Login with invalid password")
    @Description("Failed login: valid username + invalid password")
    @Severity(SeverityLevel.MINOR)
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setUsername(DataHelper.getStandartUser().getUsername());
        user.setPassword("123456");

        Assert.assertEquals(
                new LoginPage(driver).negativeLogin(user).errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }

    @Test(description = "Login with short password")
    @Description("Failed login: valid username + short password")
    @Severity(SeverityLevel.TRIVIAL)
    public void shortPswLoginTest() {
        User user = new User();
        user.setUsername(DataHelper.getStandartUser().getUsername());
        user.setPassword("123");

        Assert.assertEquals(
                new LoginPage(driver).negativeLogin(user).errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }

    @Test(description = "Failed test - verify making screenshot functionality")
    @Description("Failed login: invalid username + valid password")
    @Severity(SeverityLevel.MINOR)
    public void screenshotLoginTest() {
        User user = new User();
        user.setUsername("qwerty");
        user.setPassword(ReadProperties.password());

        Assert.assertTrue(
                new LoginPage(driver).successLogin(user).isPageOpened());
    }

    @Test
    public void buildTest(){
        UserBuilder userBuilder = new UserBuilder.Builder()
                .withUsername("Kristina")
                .withAge(28)
                .withHeight(163)
                .withWeight(55)
                .build();
    }
}
