package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OurResource.aiVirtualTourPage;
import Utilities.BaseDriver;

public class aiVirtualTourSteps {

    WebDriver driver;

    aiVirtualTourPage aivirtualtourpage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private aiVirtualTourPage page() {
        if (aivirtualtourpage == null) {
            driver = BaseDriver.getDriver();
            aivirtualtourpage = new aiVirtualTourPage(driver);
        }
        return aivirtualtourpage;
    }

    @When("click the AI Virtual Tour button")
    public void click_the_ai_virtual_tour_button() {
        page().clickVirtualTourBtn();
    }

    @Then("verify that the Ai Virtual tour page has opened.")
    public void verify_that_the_ai_virtual_tour_page_has_opened() {
        page().verifyVirtualTourPage();
    }

    @When("click the request early access button")
    public void click_the_request_early_access_button() {
        page().clickTryNowBtn();
    }

    @Then("verify that the contact us page has opened and get back to AI virtual tour page")
    public void verify_that_the_contact_us_page_has_opened_and_get_back_to_ai_virtual_tour_page() {
        page().verifyContactUsPageAndBack();
    }

    @When("click the contact support button")
    public void click_the_contact_support_button() {
        page().clickContactSupportBtn();
    }

    @Then("verify that the contact us page has opened - AI Virtual Tour")
    public void verify_that_the_contact_us_page_has_opened_ai_virtual_tour() {
        page().verifyContactUsPage();
    }
}
