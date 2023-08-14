package SearchElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "loginEmail")
    private WebElement login;

    @FindBy(id = "loginPassword")
    private WebElement password;

    @FindBy(id = "authButton")
    private WebElement authButton;

    @FindBy(id = "invalidEmailPassword")
    private WebElement loginError;

    @FindBy(id = "emailFormatError")
    private WebElement invalidEmailError;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void setLogin(String text) {
        login.sendKeys(text);
    }

    public void setPassword(String text) {
        password.sendKeys(text);
    }

    public void login() {
        authButton.click();
    }

    public String getError() {
        return loginError.getText();
    }

    public boolean hasInvalidEmailError() {
        return invalidEmailError.isDisplayed() && invalidEmailError.getText().equals("Неверный формат E-Mail");
    }

}
