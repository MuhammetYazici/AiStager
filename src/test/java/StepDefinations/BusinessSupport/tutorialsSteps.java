package StepDefinations.BusinessSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BusinessSupport.tutorialsPage;
import Utilities.BaseDriver;

public class tutorialsSteps {

    WebDriver driver;

    tutorialsPage tutorialspage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private tutorialsPage page() {
        if (tutorialspage == null) {
            driver = BaseDriver.getDriver();
            tutorialspage = new tutorialsPage(driver);
        }
        return tutorialspage;
    }

    @When("click the tutorials button")
    public void click_the_tutorials_button() {
        page().clickTutorialsBtn();
    }

    @When("click the open staging editor button")
    public void click_the_open_staging_editor_button() {
        page().clickOpenStagingEditorBtn();
    }

    @Then("verify that the virtual staging page has opened and get back to tutorials page")
    public void verify_that_the_virtual_staging_page_has_opened_and_get_back_to_tutorials_page() {
        page().verifyVirtualStagingPageAndBack();
    }

    @When("click the join earyl access button")
    public void click_the_join_earyl_access_button() {
        page().clickJoinResearchBtn();
    }

    @Then("verify the research network page has opened")
    public void verify_the_research_network_page_has_opened() {
        page().verifyResearchNetworkPage();
    }
}
