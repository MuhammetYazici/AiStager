package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ApiPage extends BasePage {

    public ApiPage(WebDriver driver) {
        super(driver);
    }

    private static final Duration ELEMENT_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration PAGE_TIMEOUT    = Duration.ofSeconds(30);

    @FindBy(css = "[data-testid='nav-link-products']")
    List<WebElement> productsMenus;
    @FindBy(css = "[data-testid='mega-menu-card-ai-virtual-staging']")
    List<WebElement> virtualStagingCards;
    @FindBy(css = "[data-testid='mega-menu-card-ai-virtual-tour']")
    List<WebElement> virtualTourCards;
    @FindBy(css = "[data-testid='mega-menu-card-virtual-staging-api']")
    List<WebElement> virtualStagingApiCards;
    @FindBy(css = "[data-testid='title-hero']")
    WebElement heroTitle;
    @FindBy(css = "[data-testid='button-get-in-touch']")
    WebElement heroGetInTouchBtn;
    @FindBy(css = "[data-testid='title-api-features']")
    WebElement apiFeaturesTitle;
    @FindBy(css = "[data-testid='button-learn-more-0']")
    WebElement virtualStagingLearnMoreBtn;
    @FindBy(css = "[data-testid='button-learn-more-1']")
    WebElement objectDetectionLearnMoreBtn;
    @FindBy(css = "[data-testid='button-contact-sales']")
    WebElement contactSalesBtn;
    @FindBy(css = "[data-testid='button-view-pricing']")
    WebElement viewPricingBtn;

    private String textOf(WebElement element) {

        return element.getText().trim();
    }

    private WebDriverWait waitFor(Duration timeout) {

        return new WebDriverWait(driver, timeout);
    }

    private WebElement firstVisible(List<WebElement> elements) {
        return elements.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No visible element among " + elements.size() + " matches"));
    }

    private void clickAfterScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", element);
        clickElement(element);
    }

    public void hoverProductsMenu() {
        new Actions(driver).moveToElement(firstVisible(productsMenus)).perform();
        waitFor(ELEMENT_TIMEOUT).until(
                d -> !virtualStagingApiCards.isEmpty() && virtualStagingApiCards.get(0).isDisplayed());
    }

    public int getProductMenuOptionCount() {
        int count = 0;
        if (!virtualStagingCards.isEmpty())    count++;
        if (!virtualTourCards.isEmpty())       count++;
        if (!virtualStagingApiCards.isEmpty()) count++;
        return count;
    }

    public void clickVirtualStagingApiOption() {
        new Actions(driver)
                .moveToElement(firstVisible(productsMenus))
                .moveToElement(virtualStagingApiCards.get(0))
                .click()
                .perform();
    }

    public String getHeroTitle() {
        waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(heroTitle));
        return textOf(heroTitle).replaceAll("\\s+", " ");
    }

    public boolean isHeroTitleVisible() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(heroTitle)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickHeroGetInTouchButton() {
        clickAfterScroll(heroGetInTouchBtn);
    }

    public void scrollToApiSuiteSection() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", apiFeaturesTitle);
    }

    public void clickVirtualStagingLearnMoreButton() {
        clickAfterScroll(virtualStagingLearnMoreBtn);
    }

    public void clickObjectDetectionLearnMoreButton() {
        clickAfterScroll(objectDetectionLearnMoreBtn);
    }

    public void clickContactSalesButton() {
        clickAfterScroll(contactSalesBtn);
    }

    public void clickViewPricingButton() {
        clickAfterScroll(viewPricingBtn);
    }

    public void navigateBackToApiPage() {
        driver.navigate().back();
        WebDriverWait wait = waitFor(PAGE_TIMEOUT);
        wait.until(ExpectedConditions.urlContains("/api"));
        wait.until(ExpectedConditions.visibilityOf(heroTitle));
    }
}
