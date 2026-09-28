package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OurResource.affiliateProgramPage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class affiliateProgramSteps {

    WebDriver driver;

    affiliateProgramPage affiliateprogrampage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private affiliateProgramPage page() {
        if (affiliateprogrampage == null) {
            driver = BaseDriver.getDriver();
            affiliateprogrampage = new affiliateProgramPage(driver);
        }
        return affiliateprogrampage;
    }

    @When("click the affiliate program")
    public void click_the_affiliate_program() {
        page().clickAffiliateProgramBtn();
    }

    @Then("verify that the affiliate program page has opened")
    public void verify_that_the_affiliate_program_page_has_opened() {
        page().verifyAffiliateProgramPage();
    }

    @When("click the join the program button")
    public void click_the_join_the_program_button() {
        page().clickJoinNowBtn();
    }

    @When("fill the required information and click the sign up button")
    public void fill_the_required_information_and_click_the_sign_up_button() {
        page().fillFormAndSignUp(
                ConfigReader.getProperty("affiliate.firstName"),
                ConfigReader.getProperty("affiliate.lastName"),
                ConfigReader.getProperty("affiliate.email"),
                ConfigReader.getProperty("affiliate.website"),
                ConfigReader.getProperty("affiliate.promotionPlan"));
    }

    @Then("verify the application received text")
    public void verify_the_application_received_text() {
        page().verifyApplicationReceived();
    }

    @When("back to the affiliate program page")
    public void back_to_the_affiliate_program_page() {
        page().backToAffiliateProgram();
    }

    @When("check Frequently Asked Questions")
    public void check_frequently_asked_questions() {
        page().checkFaqs();
    }

    @When("click to join the affiliate program button")
    public void click_to_join_the_affiliate_program_button() {
        page().clickJoinFinalBtn();
    }

    @Then("verify the join page is opened and turn back to affiliate program page")
    public void verify_the_join_page_is_opened_and_turn_back_to_affiliate_program_page() {
        page().verifyJoinPageAndBack();
    }

    @When("click the contact our team button")
    public void click_the_contact_our_team_button() {
        page().clickContactFinalBtn();
    }

    @Then("verify the contact us page is opened")
    public void verify_the_contact_us_page_is_opened() {
        page().verifyContactUsPage();
    }
}
