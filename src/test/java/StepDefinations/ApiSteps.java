package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.ApiPage;

public class ApiSteps {

    private static final Logger LOGGER = LogManager.getLogger(ApiSteps.class);

    ApiPage apiPage = new ApiPage(BaseDriver.getDriver());

    @When("the user hovers over the products menu")
    public void theUserHoversOverTheProductsMenu() {
        LOGGER.info("the user hovers over the products menu");
        apiPage.hoverProductsMenu();
    }

    @Then("the products menu lists three product options")
    public void theProductsMenuListsThreeProductOptions() {
        LOGGER.info("the products menu lists three product options");
        Assert.assertEquals(apiPage.getProductMenuOptionCount(), 3,
                "The products menu does not list three options");
    }

    @When("the user clicks the virtual staging api option")
    public void theUserClicksTheVirtualStagingApiOption() {
        LOGGER.info("the user clicks the virtual staging api option");
        apiPage.clickVirtualStagingApiOption();
    }

    @Then("the api hero title is {string}")
    public void theApiHeroTitleIs(String expected) {
        LOGGER.info("the api hero title is {}", expected);
        Assert.assertEquals(apiPage.getHeroTitle(), expected, "API page heading is not as expected");
    }

    @Then("the api page is displayed")
    public void theApiPageIsDisplayed() {
        LOGGER.info("the api page is displayed");
        Assert.assertTrue(apiPage.isHeroTitleVisible(), "API page heading is not displayed");
    }

    @When("the user returns to the api page")
    public void theUserReturnsToTheApiPage() {
        LOGGER.info("the user returns to the api page");
        apiPage.navigateBackToApiPage();
    }

    @When("the user clicks the hero get in touch button")
    public void theUserClicksTheHeroGetInTouchButton() {
        LOGGER.info("the user clicks the hero get in touch button");
        apiPage.clickHeroGetInTouchButton();
    }

    @When("the user scrolls to the api suite section")
    public void theUserScrollsToTheApiSuiteSection() {
        LOGGER.info("the user scrolls to the api suite section");
        apiPage.scrollToApiSuiteSection();
    }

    @When("the user clicks learn more on the virtual staging api card")
    public void theUserClicksLearnMoreOnTheVirtualStagingApiCard() {
        LOGGER.info("the user clicks learn more on the virtual staging api card");
        apiPage.clickVirtualStagingLearnMoreButton();
    }

    @When("the user clicks learn more on the object detection api card")
    public void theUserClicksLearnMoreOnTheObjectDetectionApiCard() {
        LOGGER.info("the user clicks learn more on the object detection api card");
        apiPage.clickObjectDetectionLearnMoreButton();
    }

    @When("the user clicks the contact sales button")
    public void theUserClicksTheContactSalesButton() {
        LOGGER.info("the user clicks the contact sales button");
        apiPage.clickContactSalesButton();
    }

    @When("the user clicks the view pricing button")
    public void theUserClicksTheViewPricingButton() {
        LOGGER.info("the user clicks the view pricing button");
        apiPage.clickViewPricingButton();
    }
}
