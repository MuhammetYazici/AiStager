package pages.OurResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ResourcesPage extends BasePage {

    public ResourcesPage(WebDriver driver) {
        super(driver);
    }

    // data-testid is built from the translated label (nav-link-resources on /en), so the href is used to stay language independent.
    @FindBy(css = "[data-testid^='nav-link-'][href$='/resources']")
    WebElement resourcesHeaderLink;

    public void clickResourcesHeaderLink() {
        clickElement(resourcesHeaderLink);
    }
}
