package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OurResource.researchLabPage;
import Utilities.BaseDriver;

public class researchLabSteps {

    WebDriver driver;

    researchLabPage researchlabpage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private researchLabPage page() {
        if (researchlabpage == null) {
            driver = BaseDriver.getDriver();
            researchlabpage = new researchLabPage(driver);
        }
        return researchlabpage;
    }

    @When("click the research lab button")
    public void click_the_research_lab_button() {
        page().clickResearchLabBtn();
    }

    @Then("verify that the research lab page has opened")
    public void verify_that_the_research_lab_page_has_opened() {
        page().verifyResearchLabPage();
    }

    @When("click the learn more button")
    public void click_the_learn_more_button() {
        page().clickLearnMoreBtn();
    }

    @Then("verify that the partners page has opened and get back to the research lab page")
    public void verify_that_the_partners_page_has_opened_and_get_back_to_the_research_lab_page() {
        page().verifyPartnersPageAndBack();
    }

    @When("click the see our work button")
    public void click_the_see_our_work_button() {
        page().clickSeeWorkBtn();
    }

    @Then("verify that the idea center page has opened and turn back to the research lab page")
    public void verify_that_the_idea_center_page_has_opened_and_turn_back_to_the_research_lab_page() {
        page().verifyIdeaCenterPageAndBack();
    }

    @When("click the join research network button")
    public void click_the_join_research_network_button() {
        page().clickJoinNetworkBtn();
    }

    @When("click the apply to join button")
    public void click_the_apply_to_join_button() {
        page().clickApplyJoinBtn();
    }

    @Then("verify that the contact us page has opened - Research Lab")
    public void verify_that_the_contact_us_page_has_opened_research_lab() {
        page().verifyContactUsPage();
    }
}
