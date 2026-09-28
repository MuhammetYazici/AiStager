package pages.BusinessSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class tutorialsPage extends BasePage {
    // Tutorials
    @FindBy(css = "[data-testid='link-tutorials']")
    WebElement tutorialsBtn;
    @FindBy(css = "[data-testid='button-open-editor']")
    WebElement openStagingEditorBtn; // navigates to the AI virtual staging editor.
    @FindBy(css = "[data-testid='button-join-research']")
    WebElement joinResearchBtn; // navigates to the research network page
    // Elements used only for page verification
    @FindBy(css = "[data-testid='tab-virtual-staging']")
    WebElement virtualStagingTab;
    @FindBy(css = "[data-testid='heading-hero']")
    WebElement researchNetworkTitle;

    public tutorialsPage(WebDriver driver) {
        super(driver);
    }

    public void clickTutorialsBtn() {
        clickElement(tutorialsBtn);
    }

    public void clickOpenStagingEditorBtn() {
        clickElement(openStagingEditorBtn);
    }

    public void verifyVirtualStagingPageAndBack() {
        verifyDisplayed(virtualStagingTab, "Virtual staging page opened");
        driver.navigate().back();
    }

    public void clickJoinResearchBtn() {
        clickElement(joinResearchBtn);
    }

    public void verifyResearchNetworkPage() {
        verifyDisplayed(researchNetworkTitle, "Research network page opened");
    }
}
