package StepDefinations.loginAndRegisterStepler;

import Utilities.BaseDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.registerAndLoginPage.RegisterPage;

import java.util.List;

public class NegativeLogin {

    @Then("The user should see the warning message.")
    public void theUserShouldSeeTheWarningMessage(DataTable dataTable) {
        RegisterPage registerPage = new RegisterPage(BaseDriver.getDriver());
        List<String> data = dataTable.asList();

        for (int i = 0; i < data.size(); i++) {
            registerPage.getElement(data.get(i));
        }

    }
}
