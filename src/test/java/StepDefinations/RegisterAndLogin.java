package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;

import javax.xml.crypto.Data;
import java.util.List;

public class RegisterAndLogin {
    LoginPage loginPage = new LoginPage(BaseDriver.getDriver());
    RegisterPage registerPage = new RegisterPage(BaseDriver.getDriver());

    @Given("The user clicks the Log in button on the homepage.")
    public void theUserClicksTheLogInButtonOnTheHomepage() {
        loginPage.clickLoginBtn();
    }

    @When("The user clicks the register button on the login page.")
    public void theUserClicksTheRegisterButtonOnTheLoginPage() {
        loginPage.registerButton();
    }

    @Then("On the registration page,enter a valid email and password.")
    public void onTheRegistrationPageEnterAValidEmailAndPassword(DataTable dataTable) {
        List<String> data = dataTable.asList();
        registerPage.registerFullEmailAndPassword(data.get(0), data.get(1), data.get(2) );
    }

    @And("The user checks the terms of acceptance box.")
    public void theUserChecksTheTermsOfAcceptanceBox() {
        registerPage.checkBoxSelect();
    }

    @Then("The user clicks the Create an account button.")
    public void theUserClicksTheCreateAnAccountButton() {
        registerPage.clickAccount();
    }

    @And("The user must verify the Verify your email text.")
    public void theUserMustVerifyTheVerifyYourEmailText() {
        Assert.assertTrue(registerPage.verifyMessage());
    }

    @When("On the login page,enter a valid email and password.")
    public void onTheLoginPageEnterAValidEmailAndPassword(DataTable dataTable) {
        List<String> data = dataTable.asList();
        loginPage.fillUserAndPassword(data.get(0), data.get(1) );
    }

    @And("The user clicks the button.")
    public void theUserClicksTheButton() {
        loginPage.clickGirisYapBtn();
    }
}
