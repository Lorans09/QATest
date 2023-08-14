package Tests;

import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import SearchElements.FormPage;
import SearchElements.LoginPage;

public class FormPageTests extends BaseSeleniumTest {

    @Before
    public void initPage() {
        driver.get("file:///C:/Users/%D0%9C%D0%B8%D1%85%D0%B0%D0%B8%D0%BB/Downloads/qa-test.html");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("test@protei.ru");
        loginPage.setPassword("test");
        loginPage.login();

    }

    @Test
    public void emailValidationError() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("fakesmail.ru");
        formPage.setButton();
        Assert.assertTrue(formPage.hasInvalidEmailError());
    }

    @Test
    public void nameValidationError() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("fake@smail.ru");
        formPage.setName("");
        formPage.setButton();
        Assert.assertTrue(formPage.hasInvalidNameError());
    }

    @Test
    public void clearAttributionError() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("");
        formPage.setName("");
        formPage.setButton();
        Assert.assertTrue(formPage.hasInvalidEmailError());
    }


    @Test
    public void CheckAddNotification() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("fake@smail.ru");
        formPage.setName("Michael");
        formPage.setHasGender();
        formPage.setHasDataCheck11();
        formPage.setHasDataCheck12();
        formPage.setHasDataSelect22();
        formPage.setButton();
        Assert.assertEquals(formPage.setHasNotification1(), "Ok");
    }

    @Test
    public void CheckFormAttributesMale() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("fake@mail.ru");
        formPage.setName("Michael");
        formPage.setHasDataCheck11();
        formPage.setHasDataSelect22();
        formPage.setButton();
        formPage.setClickNotification();
        Assert.assertEquals(formPage.getEmailResult(), "fake@mail.ru");
        Assert.assertEquals(formPage.getNameResult(), "Michael");
        Assert.assertEquals(formPage.getGenderResultMale(), "Мужской");
        Assert.assertEquals(formPage.getVersion1Result2(), "1.1");
        Assert.assertEquals(formPage.getVersion2Result(), "2.2");
    }

    @Test
    public void CheckFormAttributesFemale() {
        FormPage formPage = new FormPage(driver);
        formPage.setLogin("fake@mail.ru");
        formPage.setName("Michael");
        formPage.setGanderFemale();
        formPage.setHasDataCheck11();
        formPage.setHasDataCheck12();
        formPage.setHasDataSelect22();
        formPage.setButton();
        formPage.setClickNotification();
        Assert.assertEquals(formPage.getEmailResult(), "fake@mail.ru");
        Assert.assertEquals(formPage.getNameResult(), "Michael");
        Assert.assertEquals(formPage.getGenderResultFemale(), "Женский");
        Assert.assertEquals(formPage.getVersion1Result(), "1.1, 1.2");
        Assert.assertEquals(formPage.getVersion2Result(), "2.2");
    }
}

