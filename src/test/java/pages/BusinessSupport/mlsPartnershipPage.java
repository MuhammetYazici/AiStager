package pages.BusinessSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class mlsPartnershipPage extends BasePage {
    // MLS Partnership
    @FindBy(css = "[data-testid='link-mls-partnership']")
    WebElement mlsPartnershipBtn;
    @FindBy(css = "[data-testid='heading-hero']")
    WebElement mlsPartnershipTitle;
    @FindBy(css = "[data-testid='button-request-demo']")
    WebElement requestDemoBtn;
    @FindBy(css = "[data-testid='button-start-partnership']")
    WebElement startPartnershipBtn;
    @FindBy(css = "[data-testid='input-full-name']")
    WebElement fullNameInput;
    @FindBy(css = "[data-testid='input-business-email']")
    WebElement businessEmailInput;
    @FindBy(css = "[data-testid='input-mls-organization']")
    WebElement organizationInput;
    @FindBy(css = "[data-testid='input-active-agents']")
    WebElement activeAgentsInput;
    @FindBy(css = "[data-testid='textarea-message']")
    WebElement messageInput;
    @FindBy(css = "[data-testid='button-submit-inquiry']")
    WebElement submitInquiryBtn;
    @FindBy(css = "[data-testid='mls-success']")
    WebElement inquiryReceivedText;
    @FindBy(css = "[data-testid='button-learn-partnerships']")
    WebElement learnPartnershipsBtn;
    // Elements used only for page verification
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactUsTitle;
    @FindBy(css = "[data-testid='heading-partner']")
    WebElement partnersTitle;

    public mlsPartnershipPage(WebDriver driver) {
        super(driver);
    }

    public void clickMlsPartnershipBtn() {
        clickElement(mlsPartnershipBtn);
    }

    public void verifyMlsPartnershipPage() {
        verifyDisplayed(mlsPartnershipTitle, "MLS partnership page opened");
    }

    public void clickRequestDemoBtn() {
        clickElement(requestDemoBtn);
    }

    public void verifyContactUsPageAndBack() {
        verifyDisplayed(contactUsTitle, "Contact us page opened");
        driver.navigate().back();
    }

    public void clickStartPartnershipBtn() {
        clickElement(startPartnershipBtn);
    }

    public void verifyPartnersPageAndBack() {
        verifyDisplayed(partnersTitle, "Partners page opened");
        driver.navigate().back();
    }

    public void fillMlsFormAndSubmit(String fullName, String businessEmail, String organization, String activeAgents, String message) {
        sendKeysToElement(fullNameInput, fullName);
        sendKeysToElement(businessEmailInput, businessEmail);
        sendKeysToElement(organizationInput, organization);
        sendKeysToElement(activeAgentsInput, activeAgents);
        sendKeysToElement(messageInput, message);
        clickElement(submitInquiryBtn);
    }

    public void verifyInquiryReceivedAndBack() {
        verifyDisplayed(inquiryReceivedText, "Inquiry received text is visible");
        driver.navigate().back();
    }

    public void clickLearnPartnershipsBtn() {
        clickElement(learnPartnershipsBtn);
    }

    public void verifyPartnersPage() {
        verifyDisplayed(partnersTitle, "Partners page opened");
    }
}
