package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.PricingPage;

import java.util.List;

public class PricingSteps {

    private static final Logger LOGGER = LogManager.getLogger(PricingSteps.class);

    PricingPage pricingPage = new PricingPage(BaseDriver.getDriver());

    @Then("the url ends with {string}")
    public void theUrlEndsWith(String expected) {
        LOGGER.info("the url ends with {}", expected);
        String actual = pricingPage.waitForUrlToEndWith(expected);
        Assert.assertTrue(actual.endsWith(expected),
                "URL does not end with the expected value. Expected: " + expected + " | Actual: " + actual);
    }

    @When("the user navigates back")
    public void theUserNavigatesBack() {
        LOGGER.info("the user navigates back");
        pricingPage.navigateBack();
    }

    @When("the user returns to the pricing page")
    public void theUserReturnsToThePricingPage() {
        LOGGER.info("the user returns to the pricing page");
        pricingPage.returnToPricingPage();
    }

    @Then("the pricing link is visible")
    public void thePricingLinkIsVisible() {
        LOGGER.info("the pricing link is visible");
        pricingPage.verifyPricingLink();
    }

    @When("the user clicks the pricing link")
    public void theUserClicksThePricingLink() {
        LOGGER.info("the user clicks the pricing link");
        pricingPage.clickPricingLink();
    }

    @When("the user switches the language to Turkish")
    public void theUserSwitchesTheLanguageToTurkish() {
        LOGGER.info("the user switches the language to Turkish");
        pricingPage.switchLanguageToTurkish();
    }

    @Then("the hero title is {string}")
    public void theHeroTitleIs(String expected) {
        LOGGER.info("the hero title is {}", expected);
        Assert.assertEquals(pricingPage.getHeroTitle(), expected, "Hero title is not as expected");
    }

    @Then("the {string} plan name is {string}")
    public void thePlanNameIs(String plan, String expected) {
        LOGGER.info("the {} plan name is {}", plan, expected);
        Assert.assertEquals(pricingPage.getPlanName(plan), expected,
                plan + " plan name is not as expected");
    }

    @Then("the {string} plan price is {string}")
    public void thePlanPriceIs(String plan, String expected) {
        LOGGER.info("the {} plan price is {}", plan, expected);
        Assert.assertEquals(pricingPage.getPlanPrice(plan), expected,
                plan + " plan price is not as expected");
    }

    @Then("the {string} plan quota is {string}")
    public void thePlanQuotaIs(String plan, String expected) {
        LOGGER.info("the {} plan quota is {}", plan, expected);
        Assert.assertEquals(pricingPage.getPlanQuota(plan), expected,
                plan + " plan quota is not as expected");
    }

    @Then("the {string} plan badge is {string}")
    public void thePlanBadgeIs(String plan, String expected) {
        LOGGER.info("the {} plan badge is {}", plan, expected);
        Assert.assertEquals(pricingPage.getPlanBadge(plan), expected,
                plan + " plan badge is not as expected");
    }

    @When("the user clicks the {string} plan button")
    public void theUserClicksThePlanButton(String plan) {
        LOGGER.info("the user clicks the {} plan button", plan);
        pricingPage.clickPlanButton(plan);
    }

    @Then("the modal title is {string}")
    public void theModalTitleIs(String expected) {
        LOGGER.info("the modal title is {}", expected);
        Assert.assertEquals(pricingPage.getModalTitle(), expected, "Modal title is not as expected");
    }

    @When("the user confirms the modal")
    public void theUserConfirmsTheModal() {
        LOGGER.info("the user confirms the modal");
        pricingPage.clickConfirmButton();
    }

    @When("the user cancels the modal")
    public void theUserCancelsTheModal() {
        LOGGER.info("the user cancels the modal");
        pricingPage.clickCancelButton();
    }

    @Then("the modal is closed")
    public void theModalIsClosed() {
        LOGGER.info("the modal is closed");
        Assert.assertTrue(pricingPage.waitForModalClosed(), "Modal did not close after Cancel");
    }

    @Then("the stripe checkout opens")
    public void theStripeCheckoutOpens() {
        LOGGER.info("the stripe checkout opens");
        Assert.assertTrue(pricingPage.isStripeCheckoutOpen(), "Stripe checkout did not open");
    }

    @Then("the stripe product name contains {string}")
    public void theStripeProductNameContains(String expected) {
        LOGGER.info("the stripe product name contains {}", expected);
        String actual = pricingPage.getStripeProductName();
        Assert.assertTrue(actual.contains(expected),
                "Stripe product name does not contain the expected text. Expected: " + expected + " | Actual: " + actual);
    }

    @Then("the stripe amount is {string}")
    public void theStripeAmountIs(String expected) {
        LOGGER.info("the stripe amount is {}", expected);
        Assert.assertEquals(pricingPage.getStripeAmount(), expected, "Stripe amount is not as expected");
    }

    @Then("the top-up title is {string}")
    public void theTopUpTitleIs(String expected) {
        LOGGER.info("the top-up title is {}", expected);
        assertTopUpCardContains(expected, "Top-up title");
    }

    @Then("the top-up price is {string}")
    public void theTopUpPriceIs(String expected) {
        LOGGER.info("the top-up price is {}", expected);
        assertTopUpCardContains(expected, "Top-up price");
    }

    @Then("the top-up note is {string}")
    public void theTopUpNoteIs(String expected) {
        LOGGER.info("the top-up note is {}", expected);
        assertTopUpCardContains(expected, "Top-up note");
    }

    @When("the user clicks the top-up button")
    public void theUserClicksTheTopUpButton() {
        LOGGER.info("the user clicks the top-up button");
        pricingPage.clickTopUpButton();
    }

    private void assertTopUpCardContains(String expected, String label) {
        String cardText = pricingPage.getTopUpCardText();
        Assert.assertTrue(cardText.contains(expected),
                label + " not found. Expected: " + expected + " | Card text: " + cardText);
    }

    @Then("the comparison title is {string}")
    public void theComparisonTitleIs(String expected) {
        LOGGER.info("the comparison title is {}", expected);
        Assert.assertEquals(pricingPage.getComparisonTitle(), expected,
                "Comparison table title is not as expected");
    }

    @Then("the comparison header is {string}")
    public void theComparisonHeaderIs(String expected) {
        LOGGER.info("the comparison header is {}", expected);
        Assert.assertEquals(String.join(", ", pricingPage.getTableHeader()), expected,
                "Table header row is not as expected");
    }

    @Then("the {string} row is {string}")
    public void theRowIs(String rowName, String expected) {
        LOGGER.info("the {} row is {}", rowName, expected);
        List<String> values = pricingPage.getRowValues(rowName);
        Assert.assertEquals(String.join(", ", values), expected,
                rowName + " row is not as expected");
    }

    @Then("the faq title is {string}")
    public void theFaqTitleIs(String expected) {
        LOGGER.info("the faq title is {}", expected);
        Assert.assertEquals(pricingPage.getFaqTitle(), expected, "FAQ title is not as expected");
    }

    @Then("the faq questions are listed")
    public void theFaqQuestionsAreListed() {
        Assert.assertTrue(pricingPage.getFaqQuestionCount() > 0, "No question is listed in the FAQ section");
    }

    @Then("all faq answers are collapsed")
    public void allFaqAnswersAreCollapsed() {
        LOGGER.info("the faq questions are listed");
        Assert.assertTrue(pricingPage.areAllFaqAnswersCollapsed(), "An FAQ answer is left open");
    }

    @When("the user clicks faq question {int}")
    public void theUserClicksFaqQuestion(int number) {
        LOGGER.info("the user clicks faq question {}", number);
        pricingPage.clickFaqQuestion(number - 1);
    }

    @Then("faq answer {int} is expanded")
    public void faqAnswerIsExpanded(int number) {
        LOGGER.info("faq answer {} is expanded", number);
        Assert.assertTrue(pricingPage.waitForFaqAnswerExpanded(number - 1), "FAQ answer " + number + " did not expand");
    }

    @Then("faq answer {int} is collapsed")
    public void faqAnswerIsCollapsed(int number) {
        LOGGER.info("faq answer {} is collapsed", number);
        Assert.assertTrue(pricingPage.waitForFaqAnswerCollapsed(number - 1), "FAQ answer " + number + " did not collapse");
    }

    @When("the user clicks the refund policy link")
    public void theUserClicksTheRefundPolicyLink() {
        LOGGER.info("the user clicks the refund policy link");
        pricingPage.clickRefundPolicyLink();
    }

    @Then("the support link points to {string}")
    public void theSupportLinkPointsTo(String expected) {
        LOGGER.info("the support link points to {}", expected);
        Assert.assertEquals(pricingPage.getSupportLinkHref(), expected, "Support link target is not as expected");
    }

    @Then("the contact heading is {string}")
    public void theContactHeadingIs(String expected) {
        LOGGER.info("the contact heading is {}", expected);
        Assert.assertEquals(pricingPage.getContactHeading(), expected, "Contact page heading is not as expected");
    }

    @Then("the subject field is {string}")
    public void theSubjectFieldIs(String expected) {
        LOGGER.info("the subject field is {}", expected);
        Assert.assertEquals(pricingPage.getContactSubject(), expected, "Subject field is not pre-filled");
    }

    @When("the user types {string} in the newsletter field")
    public void theUserTypesInTheNewsletterField(String email) {
        LOGGER.info("the user types {} in the newsletter field", email);
        pricingPage.typeNewsletterEmail(email);
    }

    @Then("the newsletter field contains {string}")
    public void theNewsletterFieldContains(String expected) {
        LOGGER.info("the newsletter field contains {}", expected);
        Assert.assertEquals(pricingPage.getNewsletterValue(), expected, "Newsletter field value is not as expected");
    }

    @Then("the subscribe button is clickable")
    public void theSubscribeButtonIsClickable() {
        LOGGER.info("the subscribe button is clickable");
        Assert.assertTrue(pricingPage.isSubscribeButtonClickable(), "Subscribe button is not clickable");
    }
}
