package SearchElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FormPage {
    @FindBy(id = "dataEmail")
    private WebElement email;
    @FindBy(id = "dataSend")
    private WebElement formButton;
    @FindBy(id = "emailFormatError")
    private WebElement hasEmailError;

    @FindBy(id = "dataName")
    private WebElement hasName;

    @FindBy(id = "blankNameError")
    private WebElement hasNameError;

    @FindBy(id = "dataCheck11")
    private WebElement hasDataCheck11;
    @FindBy(id = "dataCheck12")
    private WebElement hasDataCheck12;
    @FindBy(id = "dataSelect21")
    private WebElement hasDataSelect21;

    @FindBy(id = "dataSelect22")
    private WebElement hasDataSelect22;

    @FindBy (id = "dataGender")
    private WebElement hasGender;

    @FindBy (xpath = "//button[text()='Ok']")
    private WebElement hasNotification;

    @FindBy (xpath = "//td[text()='ss@smail.ru']")
    private WebElement emailResult;

    @FindBy (xpath = "//td[text()='Michael']")
    private WebElement nameResult;

    @FindBy (xpath = "//td[text()='Мужской']")
    private WebElement genderResult;

    @FindBy (xpath = "//td[text()='1.1, 1.2']")
    private WebElement version1Result;

    @FindBy (xpath = "//td[text()='2.2']")
    private WebElement version2Result;

    public  String getEmailResult(){
        return emailResult.getText();
    }

    public String getNameResult(){
        return nameResult.getText();
    }

    public String getGenderResult(){
        return genderResult.getText();
    }

    public String getVersion1Result () {
        return version1Result.getText();
    }

    public String getVersion2Result(){
        return version2Result.getText();
    }


    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    public void setHasDataCheck11(){
        hasDataCheck11.click();
    }

    public void setHasDataCheck12(){
        hasDataCheck12.click();
    }

    public void setHasDataCheck21(){
        hasDataSelect21.click();
    }

    public void setHasDataSelect22(){
        hasDataSelect22.click();
    }

    public void setHasGender(){
        hasGender.click();
    }

    public void setLogin(String text) {
        email.sendKeys(text);
    }

    public void setName(String text) {
        hasName.sendKeys(text);
    }

    public void setButton() {
        formButton.click();
    }


    public boolean hasInvalidEmailError() {
        return hasEmailError.isDisplayed() && hasEmailError.getText().equals("Неверный формат E-Mail");

    }

    public boolean hasInvalidNameError() {
        return hasNameError.isDisplayed() && hasNameError.getText().equals("Поле имя не может быть пустым");
    }
    public String setHasNotification1() {
        return hasNotification.getText();
    }
    public void setClickNotification(){
        hasNotification.click();
    }
}


