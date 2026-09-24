package StepDefinations.loginAndRegisterStepler;

import Utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.registerAndLoginPage.forgotPasswordPage;

public class forgotPassword {
    forgotPasswordPage forgotPasswordPage;

    @When("The user clicks forgot password button.")
    public void theUserClicksForgotPasswordButton() {
        forgotPasswordPage = new forgotPasswordPage(BaseDriver.getDriver());
        forgotPasswordPage.forgotPasswordButtonClick();
    }

    @And("The user enters a registered email address.")
    public void theUserEntersARegisteredEmailAddress(DataTable dataTable) {
        String data = dataTable.toString();
        forgotPasswordPage.setEmail(data);
    }

    @And("The user clicks the send email button.")
    public void theUserClicksTheSendEmailButton() {
        forgotPasswordPage.setEpostaGonderButton();
    }

    @Then("user should see  message")
    public void userShouldSeeMessage() {
        forgotPasswordPage.verifyDisplayed();
    }
}
