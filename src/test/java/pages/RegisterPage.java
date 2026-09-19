package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='confirmPassword']")
    WebElement passwordRepeatInput;
    @FindBy(css = "[name='email']")
    WebElement emailInputBox;
    @FindBy(css = "[name='password']")
    WebElement sifreInputBox;
    @FindBy(css = "[id='terms-accept']")
    WebElement checkBox;
    @FindBy(xpath = "//button[text()='Hesap Oluştur']")
    WebElement accountButton;
    @FindBy(xpath = "//h2[text()='Verify your email']")
    public WebElement message;
    @FindBy(xpath = "//span[text()='Or press Create Account again to use the address as typed.']")
    public WebElement orPressCreatAccount;
    @FindBy(xpath = "//p[text()='Password must be at least 8 characters']")
    public WebElement passwordCharacters;
    @FindBy(xpath = "//p[text()='Passwords do not match']")
    public WebElement passwordMatch;
    @FindBy(xpath = "//p[text()='Please enter a valid email address']")
    public WebElement validEmailAdress;
    @FindBy(xpath = "//span[text()='Password is known to be weak and easy to guess, please choose a different one.']")
    public WebElement easyPassword;
    @FindBy(xpath = "//span[text()='Password is known to be weak and easy to guess, please choose a different one.']")
    public WebElement invalidEmailOrPassword;
    @FindBy(xpath = "(//span['Unable to validate email address: invalid format'])[1]")
    public WebElement Unable;
    @FindBy(xpath = "(//span['Please enter your email address.'])[1]")
    public WebElement pleaseEmail;


    public void registerFullEmailAndPassword(String email, String password,String passwordRepeat){
        sendKeysToElement(emailInputBox,email);
        sendKeysToElement(sifreInputBox,password);
        sendKeysToElement(passwordRepeatInput,passwordRepeat);
    }

     public void checkBoxSelect(){
        if (!checkBox.isSelected()){
            checkBox.click();
        }
     }

     public void clickAccount(){accountButton.click();}

    public boolean verifyMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // Görünür olana kadar bekle:
            wait.until(ExpectedConditions.visibilityOf(message));
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getElement(String value){
        switch (value){
            case "orPressCreatAccount": return orPressCreatAccount;
            case "passwordCharacters":return passwordCharacters;
            case "passwordMatch":return passwordMatch;
            case "validEmailAdress":return validEmailAdress;
            case "easyPassword":return easyPassword;
            case "invalidEmailOrPassword":return invalidEmailOrPassword;
            case "Unable":return Unable;
            case "pleaseEmail":return pleaseEmail;
        }
        return null;
    }


}
