package pages.OurResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class researchLabPage extends BasePage {
    // Research Lab
    @FindBy(css = "[data-testid='link-research-lab']")
    WebElement researchLabBtn;
    @FindBy(css = "[data-testid='button-learn-more']")
    WebElement learnMoreBtn; // goes to partners page
    @FindBy(css = "[data-testid='button-see-work']")
    WebElement seeWorkBtn; // goes to idea center page
    @FindBy(css = "[data-testid='button-join-network']")
    WebElement joinNetworkBtn;
    @FindBy(css = "[data-testid='button-apply-join']")
    WebElement applyJoinBtn; // goes to contact us page
    // Elements used only for page verification
    @FindBy(css = "[data-testid='title-hero']")
    WebElement researchLabTitle;
    @FindBy(css = "[data-testid='heading-partner']")
    WebElement partnersTitle;
    @FindBy(css = "[data-testid='title-hero']")
    WebElement ideaCenterTitle;
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactUsTitle;

    public researchLabPage(WebDriver driver) {
        super(driver);
    }

    public void clickResearchLabBtn() {
        clickElement(researchLabBtn);
    }

    public void verifyResearchLabPage() {
        verifyDisplayed(researchLabTitle, "Research lab page opened");
    }

    public void clickLearnMoreBtn() {
        clickElement(learnMoreBtn);
    }

    public void verifyPartnersPageAndBack() {
        verifyDisplayed(partnersTitle, "Partners page opened");
        driver.navigate().back();
    }

    public void clickSeeWorkBtn() {
        clickElement(seeWorkBtn);
    }

    public void verifyIdeaCenterPageAndBack() {
        verifyDisplayed(ideaCenterTitle, "Idea center page opened");
        driver.navigate().back();
    }

    public void clickJoinNetworkBtn() {
        clickElement(joinNetworkBtn);
    }

    public void clickApplyJoinBtn() {
        clickElement(applyJoinBtn);
    }

    public void verifyContactUsPage() {
        verifyDisplayed(contactUsTitle, "Contact us page opened");
    }
}
