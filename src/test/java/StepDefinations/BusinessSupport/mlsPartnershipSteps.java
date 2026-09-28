package StepDefinations.BusinessSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BusinessSupport.mlsPartnershipPage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class mlsPartnershipSteps {

    WebDriver driver;

    mlsPartnershipPage mlspartnershippage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private mlsPartnershipPage page() {
        if (mlspartnershippage == null) {
            driver = BaseDriver.getDriver();
            mlspartnershippage = new mlsPartnershipPage(driver);
        }
        return mlspartnershippage;
    }

    @When("click the MLS partnership button")
    public void click_the_mls_partnership_button() {
        page().clickMlsPartnershipBtn();
    }

    @Then("verify the the MLS partnership has opened")
    public void verify_the_the_mls_partnership_has_opened() {
        page().verifyMlsPartnershipPage();
    }

    @When("click the request MLS integration demo button")
    public void click_the_request_mls_integration_demo_button() {
        page().clickRequestDemoBtn();
    }

    @Then("verify that the contact us page has opened and get back to the MLS page")
    public void verify_that_the_contact_us_page_has_opened_and_get_back_to_the_mls_page() {
        page().verifyContactUsPageAndBack();
    }

    @When("click the start MLS partnership button")
    public void click_the_start_mls_partnership_button() {
        page().clickStartPartnershipBtn();
    }

    @Then("verify that the partners page has opened and get back to the MLS page")
    public void verify_that_the_partners_page_has_opened_and_get_back_to_the_mls_page() {
        page().verifyPartnersPageAndBack();
    }

    @When("fill the MLS network form and click submit inquiry button")
    public void fill_the_mls_network_form_and_click_submit_inquiry_button() {
        page().fillMlsFormAndSubmit(
                ConfigReader.getProperty("mls.fullName"),
                ConfigReader.getProperty("mls.businessEmail"),
                ConfigReader.getProperty("mls.organization"),
                ConfigReader.getProperty("mls.activeAgents"),
                ConfigReader.getProperty("mls.message"));
    }

    @Then("verify that the inquiry received text is visible and get back to the MLS page")
    public void verify_that_the_inquiry_received_text_is_visible_and_get_back_to_the_mls_page() {
        page().verifyInquiryReceivedAndBack();
    }

    @When("click the learn about the partnerships button")
    public void click_the_learn_about_the_partnerships_button() {
        page().clickLearnPartnershipsBtn();
    }

    @Then("verify that the partners page has opened - MLS partnership")
    public void verify_that_the_partners_page_has_opened_mls_partnership() {
        page().verifyPartnersPage();
    }
}
