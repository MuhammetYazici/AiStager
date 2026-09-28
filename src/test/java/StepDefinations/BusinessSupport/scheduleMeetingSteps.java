package StepDefinations.BusinessSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BusinessSupport.scheduleMeetingPage;
import Utilities.BaseDriver;

public class scheduleMeetingSteps {

    WebDriver driver;

    scheduleMeetingPage schedulemeetingpage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private scheduleMeetingPage page() {
        if (schedulemeetingpage == null) {
            driver = BaseDriver.getDriver();
            schedulemeetingpage = new scheduleMeetingPage(driver);
        }
        return schedulemeetingpage;
    }

    @When("click the schedule a meeting button")
    public void click_the_schedule_a_meeting_button() {
        page().clickScheduleMeetingBtn();
    }

    @Then("verify that the meeting page has opened")
    public void verify_that_the_meeting_page_has_opened() {
        page().verifyScheduleMeetingPage();
    }
}
