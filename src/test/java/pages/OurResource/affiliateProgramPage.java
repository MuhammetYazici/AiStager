package pages.OurResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class affiliateProgramPage extends BasePage {
    // Affiliate Program
    @FindBy(css = "[data-testid='link-affiliate-program']")
    WebElement affiliateProgramBtn;
    @FindBy(css = "[data-testid='title-hero']")
    WebElement affiliateProgramTitle;
    @FindBy(css = "[data-testid='button-join-now']")
    WebElement joinNowBtn;
    @FindBy(css = "[data-testid='input-first-name']")
    WebElement firstNameInput;
    @FindBy(css = "[data-testid='input-last-name']")
    WebElement lastNameInput;
    @FindBy(css = "[data-testid='input-email']")
    WebElement emailInput;
    @FindBy(css = "[data-testid='input-website']")
    WebElement websiteInput;
    @FindBy(css = "[data-testid='textarea-promotion-plan']")
    WebElement promotionPlanInput;
    @FindBy(css = "[data-testid='button-submit-signup']")
    WebElement signUpBtn;
    @FindBy(css = "[data-testid='text-success-reference']")
    WebElement applicationReceivedText;
    @FindBy(css = "[data-testid='faq-question-0']")
    WebElement faqQuestion0Btn;
    @FindBy(css = "[data-testid='faq-question-1']")
    WebElement faqQuestion1Btn;
    @FindBy(css = "[data-testid='faq-question-2']")
    WebElement faqQuestion2Btn;
    @FindBy(css = "[data-testid='faq-question-3']")
    WebElement faqQuestion3Btn;
    @FindBy(css = "[data-testid='faq-question-4']")
    WebElement faqQuestion4Btn;
    @FindBy(css = "[data-testid='faq-question-5']")
    WebElement faqQuestion5Btn;
    @FindBy(css = "[data-testid='button-join-final']")
    WebElement joinFinalBtn;
    @FindBy(css = "[data-testid='subtitle-signup']")
    WebElement joinPageTitle;
    @FindBy(css = "[data-testid='button-contact-final']")
    WebElement contactFinalBtn;
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactUsTitle;

    public affiliateProgramPage(WebDriver driver) {
        super(driver);
    }

    public void clickAffiliateProgramBtn() {
        clickElement(affiliateProgramBtn);
    }

    public void verifyAffiliateProgramPage() {
        verifyDisplayed(affiliateProgramTitle, "Affiliate program page opened");
    }

    public void clickJoinNowBtn() {
        clickElement(joinNowBtn);
    }

    public void fillFormAndSignUp(String firstName, String lastName, String email, String website, String promotionPlan) {
        sendKeysToElement(firstNameInput, firstName);
        sendKeysToElement(lastNameInput, lastName);
        sendKeysToElement(emailInput, email);
        sendKeysToElement(websiteInput, website);
        sendKeysToElement(promotionPlanInput, promotionPlan);
        clickElement(signUpBtn);
    }

    public void verifyApplicationReceived() {
        verifyDisplayed(applicationReceivedText, "Application received text is visible");
    }

    public void backToAffiliateProgram() {
        driver.navigate().back();
    }

    public void checkFaqs() {
        clickElement(faqQuestion0Btn);
        clickElement(faqQuestion1Btn);
        clickElement(faqQuestion2Btn);
        clickElement(faqQuestion3Btn);
        clickElement(faqQuestion4Btn);
        clickElement(faqQuestion5Btn);
    }

    public void clickJoinFinalBtn() {
        clickElement(joinFinalBtn);
    }

    public void verifyJoinPageAndBack() {
        verifyDisplayed(joinPageTitle, "Join page opened");
        driver.navigate().back();
    }

    public void clickContactFinalBtn() {
        clickElement(contactFinalBtn);
    }

    public void verifyContactUsPage() {
        verifyDisplayed(contactUsTitle, "Contact us page opened");
    }
}
