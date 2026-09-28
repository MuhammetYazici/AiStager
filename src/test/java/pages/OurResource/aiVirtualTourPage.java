package pages.OurResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class aiVirtualTourPage extends BasePage {
    // AI Virtual Tour
    @FindBy(css = "[data-testid='link-ai-virtual-tour']")
    WebElement virtualTourBtn;
    @FindBy(css = "[data-testid='button-try-now']")
    WebElement tryNowBtn;
    @FindBy(css = "[data-testid='button-contact-support']")
    WebElement contactSupportBtn;
    @FindBy(css = "[data-testid='title-hero']")
    WebElement virtualTourTitle;
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactUsTitle;

    public aiVirtualTourPage(WebDriver driver) {
        super(driver);
    }

    public void clickVirtualTourBtn() {
        clickElement(virtualTourBtn);
    }

    public void verifyVirtualTourPage() {
        verifyDisplayed(virtualTourTitle, "AI Virtual Tour page opened");
    }

    public void clickTryNowBtn() {
        clickElement(tryNowBtn);
    }

    public void verifyContactUsPage() {
        verifyDisplayed(contactUsTitle, "Contact us page opened");
    }

    public void verifyContactUsPageAndBack() {
        verifyContactUsPage();
        driver.navigate().back();
    }

    public void clickContactSupportBtn() {
        clickElement(contactSupportBtn);
    }
}
