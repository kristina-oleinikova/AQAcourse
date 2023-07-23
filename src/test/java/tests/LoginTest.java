package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

public class LoginTest extends BaseTest {
    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.successLogin(ReadProperties.username(), ReadProperties.password()
                ).isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin("asdasd", ReadProperties.password()).getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "123456").getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void shortPswLoginTest() {
        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "123").getErrorMessage().getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Неверное сообщение об ошибке");
    }
}
