package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.profilAndLanguagePage;

public class profilAndLanguage {

    profilAndLanguagePage profilPage = new profilAndLanguagePage(BaseDriver.getDriver());

    @Given("kullanici {string} alanina hover yapar")
    public void kullaniciAlaninaHoverYapar(String arg) {
        profilPage.hover(arg);
    }

    @When("kullanici dropdown menusundeki {string} butonuna tiklar")
    public void kullaniciMenusundekiButonunaTiklar(String name) {
       profilPage.clickableButton(name);
    }

    @Then("sayfada {string} metnini gormeli")
    public void sayfadaMetniniGormeli(String value) {
        profilPage.verifySelectionHeadling(value);
    }

    @And("kullanici {string} alanindaki {string} butonuna tiklar")
    public void kullaniciAlanindakiButonunaTiklar(String alan, String buton) {
        profilPage.alanClickButton(alan,buton);
    }

    @Given("kullanici dil secenegini {string} olarak secer")
    public void kullaniciDilSeceneginiOlarakSecer(String arg) {
        profilPage.clickableButton(arg);
    }

    @And("kullanici geriye tiklayarak geri doner")
    public void kullaniciGeriyeTiklayarakSekmesineDoner() {
        BaseDriver.getDriver().navigate().back();
    }

    @When("kullanici {string} butonuna tiklar")
    public void kullaniciButonunaTiklar(String arg) {
        profilPage.clickableButton(arg);
    }

    @And("kullanici modal uzerindeki {string} butonuna tiklar")
    public void kullaniciModalUzerindekiButonunaTiklar(String arg) {
        profilPage.clickableButton(arg);
    }
}
