package Tests;

import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import SearchElements.LoginPage;

public class LoginPageTests extends BaseSeleniumTest {
    @Before
    public void initPage() {
        driver.get("file:///C:/Users/%D0%9C%D0%B8%D1%85%D0%B0%D0%B8%D0%BB/Downloads/qa-test.html");

    }

    @Test
    public void emailValidesionError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("ss@ss.ru");
        loginPage.login();
        Assert.assertEquals(loginPage.getError(), "Неверный E-Mail или пароль");

    }

    @Test
    public void PasswordValidationError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("ssss.ru");
        loginPage.login();
        Assert.assertTrue(loginPage.hasInvalidEmailError());
    }

    @Test
    public void clearPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("");
        loginPage.setPassword("");
        loginPage.login();
        Assert.assertTrue(loginPage.hasInvalidEmailError());
    }

    @Test
    public void symbolsPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("!;%:&$?*");
        loginPage.setPassword("!;%:&$?*");
        loginPage.login();
        Assert.assertTrue(loginPage.hasInvalidEmailError());
    }

}

