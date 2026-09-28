package pages.OurResource;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class ideaCenterPage extends BasePage {
    // Idea Center
    @FindBy(css = "[data-testid='item-idea-center']")
    WebElement ideaCenterBtn;
    @FindBy(css = "[data-testid='title-hero']")
    WebElement ideaCenterTitle;
    @FindBy(css = "[data-testid='button-start-staging']")
    WebElement startStagingBtn; // navigates to the AI virtual staging editor.
    @FindBy(css = "[data-testid='example-0']")
    WebElement livingRoomHover;
    @FindBy(css = "[data-testid='example-1']")
    WebElement bedroomHover;
    @FindBy(css = "[data-testid='example-2']")
    WebElement diningRoomHover;
    @FindBy(css = "[data-testid='example-3']")
    WebElement kitchenHover;
    @FindBy(css = "[data-testid='example-4']")
    WebElement officeHover;
    @FindBy(css = "[data-testid='example-5']")
    WebElement masterBedroomHover;
    @FindBy(css = "[data-testid='button-view-gallery']")
    WebElement viewGalleryBtn;
    // Gallery page
    @FindBy(css = "[data-testid='heading-gallery']")
    WebElement galleryTitle;
    @FindBy(css = "[data-testid='thumbnail-coastal']")
    WebElement coastalStyleBtn;
    @FindBy(css = "[data-testid='thumbnail-farmhouse']")
    WebElement farmhouseStyleBtn;
    @FindBy(css = "[data-testid='thumbnail-industrial']")
    WebElement industrialStyleBtn;
    @FindBy(css = "[data-testid='thumbnail-luxury']")
    WebElement luxuryStyleBtn;
    @FindBy(css = "[data-testid='thumbnail-scandinavian']")
    WebElement scandinavianStyleBtn;
    @FindBy(css = "[data-testid='button-start-staging']")
    WebElement startNowBtn;
    @FindBy(css = "[data-testid='button-get-started']")
    WebElement getStartedBtn; // navigates to the AI virtual staging editor.
    @FindBy(css = "[data-testid='button-view-pricing']")
    WebElement viewPricingBtn; // navigates to pricing
    // Virtual staging and pricing pages
    @FindBy(css = "[data-testid='tab-virtual-staging']")
    WebElement virtualStagingTab;
    @FindBy(css = "[data-testid='hero-title']")
    WebElement pricingTitle;

    public ideaCenterPage(WebDriver driver) {
        super(driver);
    }

    // This page reveals several elements (gallery/pricing CTAs) only once scrolled into
    // the viewport (scroll-reveal animation), so click/verify scroll to the element first
    // here only, instead of changing basePage for every other page.
    private void scrollIntoView(final WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        } catch (Exception ignored) {
            // element not attached yet or scroll failed; the wait in clickElement/verifyDisplayed will still retry
        }
    }

    @Override
    public void clickElement(final WebElement element) {
        scrollIntoView(element);
        super.clickElement(element);
    }

    @Override
    public void verifyDisplayed(final WebElement element, final String text) {
        scrollIntoView(element);
        super.verifyDisplayed(element, text);
    }

    public void clickIdeaCenterBtn() {
        clickElement(ideaCenterBtn);
    }

    public void verifyIdeaCenterPage() {
        verifyDisplayed(ideaCenterTitle, "Idea center page opened");
    }

    public void clickStartStagingBtn() {
        clickElement(startStagingBtn);
    }

    public void verifyVirtualStagingPage() {
        verifyDisplayed(virtualStagingTab, "Virtual staging page opened");
    }

    public void verifyVirtualStagingPageAndBack() {
        verifyVirtualStagingPage();
        driver.navigate().back();
    }

    private void hoverAndVerify(WebElement element, String text) {
        new Actions(driver).moveToElement(element).perform();
        verifyDisplayed(element, text);
    }

    public void hoverRoomPhotos() {
        hoverAndVerify(livingRoomHover, "Living room hover");
        hoverAndVerify(bedroomHover, "Bedroom hover");
        hoverAndVerify(diningRoomHover, "Dining room hover");
        hoverAndVerify(kitchenHover, "Kitchen hover");
        hoverAndVerify(officeHover, "Office hover");
        hoverAndVerify(masterBedroomHover, "Master bedroom hover");
    }

    public void clickViewGalleryBtn() {
        clickElement(viewGalleryBtn);
    }

    public void verifyGalleryPage() {
        verifyDisplayed(galleryTitle, "Gallery page opened");
    }

    public void chooseRoomStyles() {
        clickElement(coastalStyleBtn);
        clickElement(farmhouseStyleBtn);
        clickElement(industrialStyleBtn);
        clickElement(luxuryStyleBtn);
        clickElement(scandinavianStyleBtn);
    }

    public void clickStartNowBtn() {
        clickElement(startNowBtn);
    }

    // If we came here through the gallery, more than one "back" is needed to reach idea center.
    public void backToIdeaCenter() {
        for (int i = 0; i < 3; i++) {
            driver.navigate().back();
            try {
                new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("/idea-center"));
                return;
            } catch (TimeoutException e) {
                LOGGER.debug("Not back to idea center yet, navigating back again");
            }
        }
    }

    public void clickGetStartedBtn() {
        clickElement(getStartedBtn);
    }

    public void clickViewPricingBtn() {
        clickElement(viewPricingBtn);
    }

    public void verifyPricingPage() {
        verifyDisplayed(pricingTitle, "Pricing page opened");
    }
}
