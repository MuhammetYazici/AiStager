package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    WebElement message;

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
        return message.isDisplayed();
    }


}
