package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OurResource.earnPhotosPage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class earnPhotosSteps {

    WebDriver driver;

    earnPhotosPage earnphotospage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private earnPhotosPage page() {
        if (earnphotospage == null) {
            driver = BaseDriver.getDriver();
            earnphotospage = new earnPhotosPage(driver);
        }
        return earnphotospage;
    }

    @When("click the earn photos button")
    public void click_the_earn_photos_button() {
        page().clickEarnPhotosBtn();
    }

    @Then("verify that the earn photos page has opened.")
    public void verify_that_the_earn_photos_page_has_opened() {
        page().verifyEarnPhotosPage();
    }

    @When("fill the email box for newsletter and click subscribe button")
    public void fill_the_email_box_for_newsletter_and_click_subscribe_button() {
        page().fillEmailAndSubscribe(ConfigReader.getProperty("earnPhotos.newsletterEmail"));
    }

    @Then("verify the feed back is visible")
    public void verify_the_feed_back_is_visible() {
        page().verifyFeedBack();
    }
}
