package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(css = "[name='confirmPassword']")
    WebElement passwordRepeatInput;
    @FindBy(css = "[name='email']")
    WebElement emailInputBox;
    @FindBy(css = "[name='password']")
    WebElement sifreInputBox;
    @FindBy(css = "[type='submit']")
    WebElement girisYapBtn;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void passwordRepeat(){clickElement(passwordRepeatInput);}


}
