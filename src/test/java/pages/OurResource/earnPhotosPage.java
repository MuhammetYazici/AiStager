package pages.OurResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class earnPhotosPage extends BasePage {
    // Earn Photos page has only one clickable element: subscribe to newsletter.
    @FindBy(css = "[data-testid='link-earn-photos']")
    WebElement earnPhotosBtn;
    @FindBy(css = "h1")
    WebElement earnPhotosTitle;
    // Subscribe to our newsletter
    @FindBy(css = "[data-testid='input-newsletter-email']")
    WebElement newsletterEmailInput;
    @FindBy(css = "[data-testid='button-subscribe']")
    WebElement subscribeBtn;
    @FindBy(css = "[data-testid='newsletter-feedback']")
    WebElement feedBackText;

    public earnPhotosPage(WebDriver driver) {
        super(driver);
    }

    public void clickEarnPhotosBtn() {
        clickElement(earnPhotosBtn);
    }

    public void verifyEarnPhotosPage() {
        verifyDisplayed(earnPhotosTitle, "Earn photos page opened");
    }

    public void fillEmailAndSubscribe(String email) {
        sendKeysToElement(newsletterEmailInput, email);
        clickElement(subscribeBtn);
    }

    public void verifyFeedBack() {
        verifyDisplayed(feedBackText, "Feedback is visible");
    }
}
