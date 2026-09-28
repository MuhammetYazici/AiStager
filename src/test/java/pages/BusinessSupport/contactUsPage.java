package pages.BusinessSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class contactUsPage extends BasePage {
    // Contact Us
    @FindBy(css = "[data-testid='link-contact-us']")
    WebElement contactUsBtn;
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactUsTitle;
    @FindBy(css = "[data-testid='input-subject']")
    WebElement subjectInput;
    @FindBy(css = "[data-testid='input-name']")
    WebElement nameInput;
    @FindBy(css = "[data-testid='input-email']")
    WebElement emailInput;
    @FindBy(css = "[data-testid='input-phone']")
    WebElement phoneInput;
    @FindBy(css = "[data-testid='select-reason']")
    WebElement reasonSelect;
    @FindBy(css = "[data-testid='textarea-message']")
    WebElement messageInput;
    @FindBy(css = "[data-testid='checkbox-privacy']")
    WebElement privacyCheckbox;
    @FindBy(css = "[data-testid='button-submit']")
    WebElement submitBtn;
    @FindBy(css = "[data-testid='contact-success']")
    WebElement messageSentText;
    // quick answers
    @FindBy(css = "[data-testid='button-faq']")
    WebElement faqBtn;
    @FindBy(css = "[data-testid='question-0']")
    WebElement faqQuestion0Btn;
    @FindBy(css = "[data-testid='question-1']")
    WebElement faqQuestion1Btn;
    @FindBy(css = "[data-testid='question-2']")
    WebElement faqQuestion2Btn;
    @FindBy(css = "[data-testid='question-100']")
    WebElement faqQuestion3Btn;
    @FindBy(css = "[data-testid='question-101']")
    WebElement faqQuestion4Btn;
    @FindBy(css = "[data-testid='question-102']")
    WebElement faqQuestion5Btn;
    @FindBy(css = "[data-testid='question-200']")
    WebElement faqQuestion6Btn;
    @FindBy(css = "[data-testid='question-201']")
    WebElement faqQuestion7Btn;
    @FindBy(css = "[data-testid='question-202']")
    WebElement faqQuestion8Btn;
    @FindBy(css = "[data-testid='question-203']")
    WebElement faqQuestion9Btn;
    @FindBy(css = "[data-testid='question-300']")
    WebElement faqQuestion10Btn;
    @FindBy(css = "[data-testid='question-301']")
    WebElement faqQuestion11Btn;
    @FindBy(css = "[data-testid='question-302']")
    WebElement faqQuestion12Btn;
    @FindBy(css = "[data-testid='question-400']")
    WebElement faqQuestion13Btn;
    @FindBy(css = "[data-testid='question-401']")
    WebElement faqQuestion14Btn;
    @FindBy(css = "[data-testid='question-402']")
    WebElement faqQuestion15Btn;
    @FindBy(css = "[data-testid='button-contact']")
    WebElement contactSupportBtn; // goes back to contact us page
    @FindBy(css = "[data-testid='button-schedule']")
    WebElement scheduleCallBtn; // goes to schedule meeting page
    // schedule meeting
    @FindBy(css = "[data-testid='button-schedule']")
    WebElement bookTimeBtn; // goes to schedule meeting page
    @FindBy(css = "[data-testid='heading-scheduler']")
    WebElement scheduleMeetingTitle;

    public contactUsPage(WebDriver driver) {
        super(driver);
    }

    public void clickContactUsBtn() {
        clickElement(contactUsBtn);
    }

    // Native select ise Select ile, degilse (ozel acilir liste) acip metne gore secenegi tiklar.
    private void selectOption(WebElement select, String optionText) {
        if ("select".equalsIgnoreCase(select.getTagName())) {
            new Select(select).selectByVisibleText(optionText);
        } else {
            clickElement(select);
            clickElement(driver.findElement(By.xpath("//*[@role='option' and normalize-space(.)='" + optionText + "']")));
        }
    }

    public void fillContactForm(String subject, String name, String email, String phone, String reason, String message) {
        sendKeysToElement(subjectInput, subject);
        sendKeysToElement(nameInput, name);
        sendKeysToElement(emailInput, email);
        sendKeysToElement(phoneInput, phone);
        selectOption(reasonSelect, reason);
        sendKeysToElement(messageInput, message);
    }

    public void clickPrivacyAndSubmit() {
        clickElement(privacyCheckbox);
        clickElement(submitBtn);
    }

    public void verifyMessageSent() {
        verifyDisplayed(messageSentText, "Message sent text is visible");
    }

    public void clickFaqBtn() {
        clickElement(faqBtn);
    }

    public void clickFaqsOneByOne() {
        clickElement(faqQuestion0Btn);
        clickElement(faqQuestion1Btn);
        clickElement(faqQuestion2Btn);
        clickElement(faqQuestion3Btn);
        clickElement(faqQuestion4Btn);
        clickElement(faqQuestion5Btn);
        clickElement(faqQuestion6Btn);
        clickElement(faqQuestion7Btn);
        clickElement(faqQuestion8Btn);
        clickElement(faqQuestion9Btn);
        clickElement(faqQuestion10Btn);
        clickElement(faqQuestion11Btn);
        clickElement(faqQuestion12Btn);
        clickElement(faqQuestion13Btn);
        clickElement(faqQuestion14Btn);
        clickElement(faqQuestion15Btn);
    }

    public void clickContactSupportBtn() {
        clickElement(contactSupportBtn);
    }

    public void verifyContactUsPageAndBack() {
        verifyDisplayed(contactUsTitle, "Contact us page opened");
        driver.navigate().back();
    }

    public void clickScheduleCallBtn() {
        clickElement(scheduleCallBtn);
    }

    public void verifyScheduleMeetingPageAndBack() {
        verifyDisplayed(scheduleMeetingTitle, "Schedule meeting page opened");
        driver.navigate().back();
    }

    public void clickBookTimeBtn() {
        clickElement(bookTimeBtn);
    }

    public void verifyScheduleMeetingPage() {
        verifyDisplayed(scheduleMeetingTitle, "Schedule meeting page opened");
    }
}
