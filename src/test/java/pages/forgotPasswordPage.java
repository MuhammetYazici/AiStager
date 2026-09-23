package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class forgotPasswordPage extends BasePage{

    public forgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='text-center mb-7']+div span")
    public WebElement dogrulamaMessage;
    @FindBy(xpath = "//button[text()='Şifremi unuttum?']")
    public WebElement forgotButton;
    @FindBy(css = "[type='email']")
    public WebElement email;
    @FindBy(xpath = "//button[text()='Sıfırlama E-postası Gönder']")
    public WebElement EpostaGonderButton;

    public boolean verifyDisplayed(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // Görünür olana kadar bekle:
            wait.until(ExpectedConditions.visibilityOf(dogrulamaMessage));
            return dogrulamaMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void forgotPasswordButtonClick(){
        clickElement(forgotButton);
    }

    public void setEmail(String eposta){
        sendKeysToElement(email,eposta);
    }

    public void setEpostaGonderButton(){
        clickElement(EpostaGonderButton);
    }


}
