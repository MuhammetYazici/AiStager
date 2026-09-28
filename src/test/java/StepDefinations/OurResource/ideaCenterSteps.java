package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OurResource.ideaCenterPage;
import Utilities.BaseDriver;

public class ideaCenterSteps {

    WebDriver driver;

    ideaCenterPage ideacenterpage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private ideaCenterPage page() {
        if (ideacenterpage == null) {
            driver = BaseDriver.getDriver();
            ideacenterpage = new ideaCenterPage(driver);
        }
        return ideacenterpage;
    }

    @When("click the idea center button")
    public void click_the_idea_center_button() {
        page().clickIdeaCenterBtn();
    }

    @Then("verify that the idea center page has opened")
    public void verify_that_the_idea_center_page_has_opened() {
        page().verifyIdeaCenterPage();
    }

    @When("click the start staging button")
    public void click_the_start_staging_button() {
        page().clickStartStagingBtn();
    }

    @Then("verify that the virtual staging page has opened and get back to idea center page")
    public void verify_that_the_virtual_staging_page_has_opened_and_get_back_to_idea_center_page() {
        page().verifyVirtualStagingPageAndBack();
    }

    @Then("verify the photos from rooms are hoverable")
    public void verify_the_photos_from_rooms_are_hoverable() {
        page().hoverRoomPhotos();
    }

    @When("click the view full gallery")
    public void click_the_view_full_gallery() {
        page().clickViewGalleryBtn();
    }

    @Then("verify that the gallery page has opened")
    public void verify_that_the_gallery_page_has_opened() {
        page().verifyGalleryPage();
    }

    @When("choose the style of room")
    public void choose_the_style_of_room() {
        page().chooseRoomStyles();
    }

    @When("click the start stagign now button")
    public void click_the_start_stagign_now_button() {
        page().clickStartNowBtn();
    }

    @Then("verify that the virtual staging page has opened")
    public void verify_that_the_virtual_staging_page_has_opened() {
        page().verifyVirtualStagingPage();
    }

    @When("back to idea center page")
    public void back_to_idea_center_page() {
        page().backToIdeaCenter();
    }

    @When("click to the get started free button")
    public void click_to_the_get_started_free_button() {
        page().clickGetStartedBtn();
    }

    @When("click to the view pricing button")
    public void click_to_the_view_pricing_button() {
        page().clickViewPricingBtn();
    }

    @Then("verify that the pricing page has opened")
    public void verify_that_the_pricing_page_has_opened() {
        page().verifyPricingPage();
    }
}
