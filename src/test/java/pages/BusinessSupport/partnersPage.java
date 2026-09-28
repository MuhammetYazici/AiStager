package pages.BusinessSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class partnersPage extends BasePage {
    // Partners
    @FindBy(css = "[data-testid='link-partners']")
    WebElement partnersBtn;
    @FindBy(css = "[data-testid='heading-partner']")
    WebElement partnersTitle;
    @FindBy(css = "[data-testid='button-become-partner']")
    WebElement becomePartnerBtn; // scrolls down to the form
    @FindBy(css = "[data-testid='input-name']")
    WebElement nameInput;
    @FindBy(css = "[data-testid='input-email']")
    WebElement emailInput;
    @FindBy(css = "[data-testid='input-phone']")
    WebElement phoneInput;
    @FindBy(css = "[data-testid='input-company']")
    WebElement companyInput;
    @FindBy(css = "[data-testid='select-specialization']")
    WebElement specializationSelect;
    @FindBy(css = "[data-testid='textarea-message']")
    WebElement messageInput;
    @FindBy(css = "[data-testid='button-submit-form']")
    WebElement submitFormBtn;
    @FindBy(css = "[data-testid='partners-success']")
    WebElement applicationReceivedText;

    public partnersPage(WebDriver driver) {
        super(driver);
    }

    public void clickPartnersBtn() {
        clickElement(partnersBtn);
    }

    public void verifyPartnersPage() {
        verifyDisplayed(partnersTitle, "Partners page opened");
    }

    public void clickBecomePartnerBtn() {
        clickElement(becomePartnerBtn);
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

    public void fillPartnerForm(String name, String email, String phone, String company, String specialization, String message) {
        sendKeysToElement(nameInput, name);
        sendKeysToElement(emailInput, email);
        sendKeysToElement(phoneInput, phone);
        sendKeysToElement(companyInput, company);
        selectOption(specializationSelect, specialization);
        sendKeysToElement(messageInput, message);
    }

    public void clickSubmitFormBtn() {
        clickElement(submitFormBtn);
    }

    public void verifyApplicationReceived() {
        verifyDisplayed(applicationReceivedText, "Application received text is visible");
    }
}
