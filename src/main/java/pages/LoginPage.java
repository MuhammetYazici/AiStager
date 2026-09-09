package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='button-signin']")
    WebElement logInBtn;
    @FindBy(css = "[name='email']")
    WebElement emailInputBox;
    @FindBy(css = "[name='password']")
    WebElement sifreInputBox;
    @FindBy(css = "[type='submit']")
    WebElement girisYapBtn;
    @FindBy(css = "[data-testid='user-avatar']")
    WebElement userAvatar;

    public boolean isAvatarVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(userAvatar));
            return userAvatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @FindBy(css = "[data-testid='button-accept-all']")
    WebElement cerezler;
    // google ile devam et eklenecek.

    public void clickLoginBtn(){
        clickElement(logInBtn);}

    public void fillUserAndPassword(String email, String password) {
        sendKeysToElement(emailInputBox, email);
        sendKeysToElement(sifreInputBox, password);
    }

    public void clickGirisYapBtn(){clickElement(girisYapBtn);}

    public void verifiyAvatar(){verifyDisplayed(userAvatar,"avatar gorundu");}

    public void cerezlerKabul(){clickElement(cerezler);}

}
