package pages;

import org.openqa.selenium.By;
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

public class PricingPage extends BasePage {

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    private static final Duration ANIMATION_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration ELEMENT_TIMEOUT   = Duration.ofSeconds(15);
    private static final Duration PAGE_TIMEOUT      = Duration.ofSeconds(30);

    @FindBy(css = "[data-testid='nav-link-pricing']")
    WebElement pricingLink;
    @FindBy(css = "[data-testid='button-language-switcher']")
    List<WebElement> languageSwitchers;
    @FindBy(css = "[data-testid='option-language-tr']")
    List<WebElement> turkishOptions;
    @FindBy(css = "[data-testid='hero-title']")
    WebElement heroTitle;
    @FindBy(css = "[data-testid='text-plan-name-standard']")
    WebElement standardName;
    @FindBy(css = "[data-testid='text-price-standard']")
    WebElement standardPrice;
    @FindBy(css = "[data-testid='text-photos-standard']")
    WebElement standardPhotos;
    @FindBy(css = "[data-testid='button-cta-standard']")
    WebElement standardBtn;
    @FindBy(css = "[data-testid='text-plan-name-advanced']")
    WebElement advancedName;
    @FindBy(css = "[data-testid='text-price-advanced']")
    WebElement advancedPrice;
    @FindBy(css = "[data-testid='text-photos-advanced']")
    WebElement advancedPhotos;
    @FindBy(css = "[data-testid='button-cta-advanced']")
    WebElement advancedBtn;
    @FindBy(css = "[data-testid='card-plan-advanced'] div[class*='-top-4'] span")
    WebElement advancedBadge;
    @FindBy(css = "[data-testid='text-plan-name-premium']")
    WebElement premiumName;
    @FindBy(css = "[data-testid='text-price-premium']")
    WebElement premiumPrice;
    @FindBy(css = "[data-testid='text-photos-premium']")
    WebElement premiumPhotos;
    @FindBy(css = "[data-testid='button-cta-premium']")
    WebElement premiumBtn;
    @FindBy(css = "[data-testid='text-plan-name-enterprise']")
    WebElement enterpriseName;
    @FindBy(css = "[data-testid='button-cta-enterprise']")
    WebElement enterpriseBtn;
    @FindBy(css = "[data-testid='card-plan-enterprise'] div[class*='-top-4'] span")
    WebElement enterpriseBadge;
    @FindBy(css = "[data-testid='modal-title']")
    WebElement modalTitle;
    @FindBy(css = "[data-testid='modal-confirm']")
    WebElement modalConfirmBtn;
    @FindBy(css = "[data-testid='modal-cancel']")
    WebElement modalCancelBtn;
    @FindBy(css = "div[class*='border-dashed']")
    WebElement topUpCard;
    @FindBy(css = "[data-testid='button-topup-credits']")
    WebElement topUpBtn;
    @FindBy(css = "[data-testid='comparison-title']")
    WebElement comparisonTitle;
    @FindBy(css = "table th")
    List<WebElement> tableHeaderCells;
    @FindBy(css = "table tbody tr")
    List<WebElement> tableBodyRows;
    @FindBy(css = "[data-testid='faq-title']")
    WebElement faqTitle;
    @FindBy(css = "[data-testid^='faq-question-']")
    List<WebElement> faqQuestions;
    @FindBy(css = "[data-testid='faq-answer-2'] a")
    WebElement refundPolicyLink;
    @FindBy(css = "[data-testid='input-newsletter-email']")
    WebElement newsletterInput;
    @FindBy(css = "[data-testid='button-subscribe']")
    WebElement subscribeBtn;
    @FindBy(css = "[data-testid='product-summary-name']")
    WebElement stripeProductName;
    @FindBy(css = "[data-testid='product-summary-total-amount']")
    WebElement stripeAmount;
    @FindBy(css = "[data-testid='heading-contact']")
    WebElement contactHeading;
    @FindBy(css = "[data-testid='input-subject']")
    WebElement contactSubjectInput;
    @FindBy(css = "a[href^='mailto:']")
    WebElement supportLink;

    private String textOf(WebElement element) {
        return element.getText().trim();
    }
    private WebDriverWait waitFor(Duration timeout) {
        return new WebDriverWait(driver, timeout);
    }
    public void verifyPricingLink() {
        verifyDisplayed(pricingLink, "pricing link is displayed");
    }
    public void clickPricingLink() {
        clickElement(pricingLink);
    }
    public void switchLanguageToTurkish() {
        new Actions(driver).moveToElement(firstVisible(languageSwitchers)).perform();
        WebElement turkish = waitFor(ELEMENT_TIMEOUT).until(
                d -> turkishOptions.stream().filter(WebElement::isDisplayed).findFirst().orElse(null));
        turkish.click();
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.urlContains("/tr/"));
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(standardName));
    }
    private WebElement firstVisible(List<WebElement> elements) {
        return elements.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No visible element among " + elements.size() + " matches"));
    }
    public String getHeroTitle() {
        return textOf(heroTitle);
    }
    public String getPlanName(String plan) {
        return textOf(planName(plan));
    }
    public String getPlanPrice(String plan) {
        return textOf(planPrice(plan));
    }
    public String getPlanQuota(String plan) {
        return textOf(planPhotos(plan));
    }
    public String getPlanBadge(String plan) {
        return textOf(planBadge(plan));
    }
    public void clickPlanButton(String plan) {
        clickElement(planBtn(plan));
    }
    private WebElement planName(String plan) {
        switch (plan.toLowerCase()) {
            case "standard":   return standardName;
            case "advanced":   return advancedName;
            case "premium":    return premiumName;
            case "enterprise": return enterpriseName;
            default: throw new IllegalArgumentException("Unknown plan: " + plan);
        }
    }
    private WebElement planPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "standard": return standardPrice;
            case "advanced": return advancedPrice;
            case "premium":  return premiumPrice;
            default: throw new IllegalArgumentException("This plan has no price: " + plan);
        }
    }
    private WebElement planPhotos(String plan) {
        switch (plan.toLowerCase()) {
            case "standard": return standardPhotos;
            case "advanced": return advancedPhotos;
            case "premium":  return premiumPhotos;
            default: throw new IllegalArgumentException("This plan has no quota: " + plan);
        }
    }
    private WebElement planBtn(String plan) {
        switch (plan.toLowerCase()) {
            case "standard":   return standardBtn;
            case "advanced":   return advancedBtn;
            case "premium":    return premiumBtn;
            case "enterprise": return enterpriseBtn;
            default: throw new IllegalArgumentException("Unknown plan: " + plan);
        }
    }
    private WebElement planBadge(String plan) {
        switch (plan.toLowerCase()) {
            case "advanced":   return advancedBadge;
            case "enterprise": return enterpriseBadge;
            default: throw new IllegalArgumentException("This plan has no badge: " + plan);
        }
    }
    public String getModalTitle() {
        waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(modalTitle));
        return textOf(modalTitle);
    }
    public void clickConfirmButton() {
        clickElement(modalConfirmBtn);
    }
    public void clickCancelButton() {
        clickElement(modalCancelBtn);
    }
    public boolean waitForModalClosed() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.invisibilityOf(modalTitle));
        } catch (TimeoutException e) {
            return false;
        }
    }
    public String getTopUpCardText() {
        return textOf(topUpCard);
    }
    public void clickTopUpButton() {
        clickElement(topUpBtn);
    }
    public String getComparisonTitle() {
        return textOf(comparisonTitle);
    }
    public List<String> getTableHeader() {
        return tableHeaderCells.stream().map(this::textOf).toList();
    }

    public List<String> getRowValues(String rowName) {
        for (WebElement row : tableBodyRows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            if (!cells.isEmpty() && textOf(cells.get(0)).equals(rowName)) {
                return cells.subList(1, cells.size()).stream().map(this::textOf).toList();
            }
        }
        throw new IllegalArgumentException("Row not found: " + rowName);
    }
    public String getFaqTitle() {
        return textOf(faqTitle);
    }

    public int getFaqQuestionCount() {
        return faqQuestions.size();
    }

    public void clickFaqQuestion(int index) {
        WebElement question = driver.findElement(faqQuestion(index));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", question);
        waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(question));
        question.click();
    }

    public boolean waitForFaqAnswerExpanded(int index) {
        return waitForFaqAnswerHeight(index, true);
    }

    public boolean waitForFaqAnswerCollapsed(int index) {
        return waitForFaqAnswerHeight(index, false);
    }

    public boolean areAllFaqAnswersCollapsed() {
        for (int i = 0; i < faqQuestions.size(); i++) {
            if (isFaqAnswerExpanded(i)) {
                return false;
            }
        }
        return true;
    }

    public void clickRefundPolicyLink() {
        clickElement(refundPolicyLink);
    }
    private By faqQuestion(int index) {
        return By.cssSelector("[data-testid='faq-question-" + index + "']");
    }

    private By faqAnswer(int index) {
        return By.cssSelector("[data-testid='faq-answer-" + index + "']");
    }

    private boolean waitForFaqAnswerHeight(int index, boolean expanded) {
        try {
            return waitFor(ANIMATION_TIMEOUT).until(d -> isFaqAnswerExpanded(index) == expanded);
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean isFaqAnswerExpanded(int index) {
        WebElement answer = driver.findElement(faqAnswer(index));
        Long height = (Long) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].parentElement.offsetHeight;", answer);
        return height != null && height > 0;
    }

    public void typeNewsletterEmail(String email) {
        sendKeysToElement(newsletterInput, email);
    }

    public String getNewsletterValue() {
        return newsletterInput.getDomProperty("value");
    }

    public boolean isSubscribeButtonClickable() {
        return subscribeBtn.isDisplayed() && subscribeBtn.isEnabled();
    }
    public boolean isStripeCheckoutOpen() {
        try {
            return waitFor(PAGE_TIMEOUT).until(ExpectedConditions.urlContains("checkout.stripe.com"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getStripeProductName() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(stripeProductName));
        return textOf(stripeProductName);
    }

    public String getStripeAmount() {
        return textOf(stripeAmount).replaceAll("\\s+", " ");
    }

    public String getContactHeading() {
        waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(contactHeading));
        return textOf(contactHeading);
    }

    public String getContactSubject() {
        return contactSubjectInput.getDomProperty("value");
    }
    public String getSupportLinkHref() {
        return supportLink.getDomAttribute("href");
    }

    public void navigateBack() {
        driver.navigate().back();
        waitForPricingPageReady();
    }

    public void returnToPricingPage() {
        driver.navigate().back();
        waitForPricingPageReady();
    }

    public String waitForUrlToEndWith(String suffix) {
        try {
            waitFor(PAGE_TIMEOUT).until(d -> d.getCurrentUrl().endsWith(suffix));
        } catch (TimeoutException e) {
        }
        return driver.getCurrentUrl();
    }

    private void waitForPricingPageReady() {
        WebDriverWait wait = waitFor(PAGE_TIMEOUT);
        wait.until(ExpectedConditions.urlContains("/pricing"));
        wait.until(ExpectedConditions.visibilityOf(standardName));
    }
}