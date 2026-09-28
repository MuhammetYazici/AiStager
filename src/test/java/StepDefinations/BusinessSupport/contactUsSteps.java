package StepDefinations.BusinessSupport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BusinessSupport.contactUsPage;
import Utilities.BaseDriver;
import Utilities.ConfigReader;

public class contactUsSteps {

    WebDriver driver;

    contactUsPage contactuspage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private contactUsPage page() {
        if (contactuspage == null) {
            driver = BaseDriver.getDriver();
            contactuspage = new contactUsPage(driver);
        }
        return contactuspage;
    }

    @When("click the contact us button")
    public void click_the_contact_us_button() {
        page().clickContactUsBtn();
    }

    @When("fill the contact us form and select reason for contact")
    public void fill_the_contact_us_form_and_select_reason_for_contact() {
        page().fillContactForm(
                ConfigReader.getProperty("contactUs.subject"),
                ConfigReader.getProperty("contactUs.name"),
                ConfigReader.getProperty("contactUs.email"),
                ConfigReader.getProperty("contactUs.phone"),
                ConfigReader.getProperty("contactUs.reason"),
                ConfigReader.getProperty("contactUs.message"));
    }

    @When("click the privacy box and submit button")
    public void click_the_privacy_box_and_submit_button() {
        page().clickPrivacyAndSubmit();
    }

    @Then("verify the message sent text is visible")
    public void verify_the_message_sent_text_is_visible() {
        page().verifyMessageSent();
    }

    @When("click the quick answer button \\(view FAQ\\)")
    public void click_the_quick_answer_button_view_faq() {
        page().clickFaqBtn();
    }

    @When("click the FAQs one by one")
    public void click_the_faqs_one_by_one() {
        page().clickFaqsOneByOne();
    }

    @When("click the Contact Support button")
    public void click_the_contact_support_button() {
        page().clickContactSupportBtn();
    }

    @Then("verify that the contact us page has opened and turn back to FAQ page")
    public void verify_that_the_contact_us_page_has_opened_and_turn_back_to_faq_page() {
        page().verifyContactUsPageAndBack();
    }

    @When("click the Schedule a call button")
    public void click_the_schedule_a_call_button() {
        page().clickScheduleCallBtn();
    }

    @Then("verifiy that the schedule meeting page has opened and turn back to contact us page")
    public void verifiy_that_the_schedule_meeting_page_has_opened_and_turn_back_to_contact_us_page() {
        page().verifyScheduleMeetingPageAndBack();
    }

    @When("click the book a time button \\(SaM\\)")
    public void click_the_book_a_time_button_sam() {
        page().clickBookTimeBtn();
    }

    @Then("verify that the Schedule a Meeting page has opened")
    public void verify_that_the_schedule_a_meeting_page_has_opened() {
        page().verifyScheduleMeetingPage();
    }
}
