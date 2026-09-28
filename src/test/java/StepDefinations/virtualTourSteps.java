package StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.virtualTourCreatePage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class virtualTourSteps {

    WebDriver driver;

    virtualTourCreatePage createPage;

    // Driver is created in Hooks; that's why the page is created on first use.
    private virtualTourCreatePage createPage() {
        if (createPage == null) {
            driver = BaseDriver.getDriver();
            createPage = new virtualTourCreatePage(driver);
        }
        return createPage;
    }

    @When("navigate to the AI virtual tour page")
    public void navigate_to_the_ai_virtual_tour_page() {
        createPage().openAiVirtualTour();
    }

    @Then("verify that the Ai virtual tour page has opened")
    public void verify_that_the_ai_virtual_tour_create_page_has_opened() {
        createPage().verifyCreatePageOpened();
    }

    @When("click the Upload From Files tab")
    public void click_the_upload_from_files_tab() {
        createPage().clickUploadFromFilesTab();
    }

    @When("upload an image for the virtual tour")
    public void upload_an_image_for_the_virtual_tour() {
        createPage().uploadImages(ConfigReader.getProperty("virtualTour.imagePath"));
    }

    @Then("verify that the image is displayed in the selected images section")
    public void verify_that_the_image_is_displayed_in_the_selected_images_section() {
        createPage().verifyImageSelected();
    }

    @When("select {string} from the resolution dropdown")
    public void select_from_the_resolution_dropdown(String option) {
        createPage().selectResolution(option);
    }

    @When("select {string} from the orientation dropdown")
    public void select_from_the_orientation_dropdown(String option) {
        createPage().selectOrientation(option);
    }

    @When("open the customise section")
    public void open_the_customise_section() {
        createPage().openCustomiseSection();
    }

    @When("select {string} from the font style dropdown")
    public void select_from_the_font_style_dropdown(String option) {
        createPage().selectFontStyle(option);
    }

    @When("select {string} from the background audio dropdown")
    public void select_from_the_background_audio_dropdown(String option) {
        createPage().selectBackgroundAudio(option);
    }

    @When("enter {string} into the intro text box")
    public void enter_into_the_intro_text_box(String text) {
        createPage().enterIntroText(text);
    }

    @When("enter {string} into the agent name box")
    public void enter_into_the_agent_name_box(String text) {
        createPage().enterAgentName(text);
    }

    @When("enter {string} into the phone box")
    public void enter_into_the_phone_box(String text) {
        createPage().enterPhone(text);
    }

    @When("enter {string} into the email box")
    public void enter_into_the_email_box(String text) {
        createPage().enterEmail(text);
    }

    @When("upload a profile image")
    public void upload_a_profile_image() {
        createPage().uploadProfileImage(ConfigReader.getProperty("virtualTour.profileImagePath"));
    }

    @When("upload a logo")
    public void upload_a_logo() {
        createPage().uploadLogo(ConfigReader.getProperty("virtualTour.logoPath"));
    }

    @Then("verify that the credit cost is displayed")
    public void verify_that_the_credit_cost_is_displayed() {
        createPage().verifyCreditCostDisplayed();
    }

    @When("click the Create Virtual Tour button")
    public void click_the_create_virtual_tour_button() {
        createPage().clickCreateVirtualTourBtn();
    }
}
