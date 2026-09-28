package StepDefinations.BusinessSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BusinessSupport.partnersPage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class partnersSteps {

    WebDriver driver;

    partnersPage partnerspage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private partnersPage page() {
        if (partnerspage == null) {
            driver = BaseDriver.getDriver();
            partnerspage = new partnersPage(driver);
        }
        return partnerspage;
    }

    @When("click the partners button")
    public void click_the_partners_button() {
        page().clickPartnersBtn();
    }

    @Then("verify that the partners page has opened - Partners")
    public void verify_that_the_partners_page_has_opened_partners() {
        page().verifyPartnersPage();
    }

    @When("click the start partnership journey")
    public void click_the_start_partnership_journey() {
        page().clickBecomePartnerBtn();
    }

    @When("filling in the required information and select partnership type")
    public void filling_in_the_required_information_and_select_partnership_type() {
        page().fillPartnerForm(
                ConfigReader.getProperty("partners.name"),
                ConfigReader.getProperty("partners.email"),
                ConfigReader.getProperty("partners.phone"),
                ConfigReader.getProperty("partners.company"),
                ConfigReader.getProperty("partners.specialization"),
                ConfigReader.getProperty("partners.message"));
    }

    @When("click the submit partnership application button")
    public void click_the_submit_partnership_application_button() {
        page().clickSubmitFormBtn();
    }

    @Then("verify the application received text is visible")
    public void verify_the_application_received_text_is_visible() {
        page().verifyApplicationReceived();
    }
}
