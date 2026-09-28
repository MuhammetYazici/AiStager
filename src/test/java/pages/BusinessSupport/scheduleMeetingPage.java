package pages.BusinessSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class scheduleMeetingPage extends BasePage {
    // Schedule Meeting
    @FindBy(css = "[data-testid='link-schedule-a-meeting']")
    WebElement scheduleMeetingBtn;
    @FindBy(css = "[data-testid='heading-scheduler']")
    WebElement scheduleMeetingTitle;

    public scheduleMeetingPage(WebDriver driver) {
        super(driver);
    }

    public void clickScheduleMeetingBtn() {
        clickElement(scheduleMeetingBtn);
    }

    public void verifyScheduleMeetingPage() {
        verifyDisplayed(scheduleMeetingTitle, "Schedule meeting page opened");
    }
}
