package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;

import javax.xml.crypto.Data;
import java.util.List;

public class RegisterAndLogin {
    LoginPage loginPage;
    RegisterPage registerPage;


    @Given("The user clicks the Log in button on the homepage.")
    public void theUserClicksTheLogInButtonOnTheHomepage() {
        loginPage = new LoginPage(BaseDriver.getDriver());
        registerPage = new RegisterPage(BaseDriver.getDriver());
        loginPage.clickLoginBtn();
    }

    @When("The user clicks the register button on the login page.")
    public void theUserClicksTheRegisterButtonOnTheLoginPage() {
        loginPage.registerButton();
    }

    @Then("On the registration page,enter a valid email and password.")
    public void onTheRegistrationPageEnterAValidEmailAndPassword(DataTable dataTable) {
        List<String> data = dataTable.asList();

        String email = registerPage.resolveDynamicValue(data.get(0));
        String password = registerPage.resolveDynamicValue(data.get(1));
        String passwordRepeat = registerPage.resolveDynamicValue(data.get(2));

        registerPage.registerFullEmailAndPassword(email,password,passwordRepeat);
    }

    @And("The user checks the terms of acceptance box.")
    public void theUserChecksTheTermsOfAcceptanceBox() {
        registerPage.checkBoxSelect();
    }

    @Then("The user clicks the Create an account button.")
    public void theUserClicksTheCreateAnAccountButton() {
        registerPage.clickAccount();
    }

    @When("On the login page,enter a valid email and password.")
    public void onTheLoginPageEnterAValidEmailAndPassword(DataTable dataTable) {
        List<String> data = dataTable.asList();

        String email = registerPage.resolveDynamicValue(data.get(0));
        String password = registerPage.resolveDynamicValue(data.get(1));

        loginPage.fillUserAndPassword(email,password);
    }

    @And("The user clicks the button.")
    public void theUserClicksTheButton() {
        loginPage.clickGirisYapBtn();
    }

    @And("The user clicks the cookie.")
    public void theUserClicksTheCookie() {
        loginPage.cerezlerKabul();
    }


    @Then("The user should see the verify your email message.")
    public void theUserShouldSeeTheMessage() {
        registerPage.verifyMessage();
    }

    @Then("should display the user avatar")
    public void shouldDisplayTheUserAvatar() {
        loginPage.isAvatarVisible();
        loginPage.verifiyAvatar();
    }
}
