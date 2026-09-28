package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;

// "Create AI Virtual Tour" page (/en/virtual-tour).
// The main content has no data-testid, so the locators rely on English label texts; they break on /tr, /ru etc.
public class virtualTourCreatePage extends BasePage {

    public virtualTourCreatePage(WebDriver driver) {
        super(driver);
    }

    // Header Products mega menu (used to navigate to this page)
    @FindBy(css = "[data-testid='nav-link-products']")
    WebElement productsHoverMenuBtn; // hover with Actions.
    @FindBy(css = "[data-testid='mega-menu-card-ai-virtual-tour']")
    WebElement aiVirtualTourMenuBtn;

    // Title and source tabs
    @FindBy(xpath = "//h1[normalize-space()='Create AI Virtual Tour']")
    WebElement pageTitle;
    @FindBy(xpath = "//button[normalize-space()='Upload From Files']")
    WebElement uploadFromFilesTab;
    @FindBy(xpath = "//button[normalize-space()='Import From My Creations']")
    WebElement importFromMyCreationsTab;

    // Upload From Files
    @FindBy(css = "[role='button'][aria-label='Browse files']")
    WebElement dropzone;
    @FindBy(css = "input[type='file'][accept='image/jpeg,image/png']")
    WebElement imagesFileInput; // hidden (display:none), accepts multiple files.
    // NOT VERIFIED: the section is only visible after an image is uploaded. Shows "1 / 20".
    @FindBy(xpath = "//*[not(*) and normalize-space()='Selected images']/following::*[not(*) and contains(normalize-space(),'/ 20')][1]")
    WebElement selectedImagesCounter;

    // Settings (Radix Select)
    @FindBy(xpath = "//label[normalize-space()='Resolution']/following-sibling::button[@role='combobox']")
    WebElement resolutionSelect;
    @FindBy(xpath = "//label[normalize-space()='Orientation']/following-sibling::button[@role='combobox']")
    WebElement orientationSelect;

    // Customise panel
    @FindBy(xpath = "//button[normalize-space()='Customise']")
    WebElement customiseToggle; // no aria-expanded; the panel is open when introTextArea is visible.
    @FindBy(xpath = "//label[normalize-space()='Font Style']/following-sibling::button[@role='combobox']")
    WebElement fontStyleSelect;
    @FindBy(xpath = "//label[normalize-space()='Background Audio']/following-sibling::div/button")
    WebElement backgroundAudioDropdown; // custom dropdown, not Radix.
    @FindBy(css = "textarea[maxlength='200']")
    WebElement introTextArea;
    @FindBy(xpath = "//label[normalize-space()='Intro Text']/following-sibling::span")
    WebElement introTextCounter;

    // Branding
    @FindBy(xpath = "//label[normalize-space()='Agent Name']/following-sibling::input")
    WebElement agentNameInput;
    @FindBy(css = "input[type='tel']")
    WebElement phoneInput;
    @FindBy(xpath = "//label[normalize-space()='Email']/following-sibling::input")
    WebElement brandingEmailInput; // input[type='email'] also matches the footer newsletter input.
    // Fragile: the two inputs have no distinguishing attribute. 1st = Profile Image, 2nd = Logo.
    @FindBy(xpath = "(//input[@type='file'][@accept='image/*'])[1]")
    WebElement profileImageFileInput;
    @FindBy(xpath = "(//input[@type='file'][@accept='image/*'])[2]")
    WebElement logoFileInput;

    // Action
    // NOT VERIFIED: the credit cost text was not in the locator report. Shows "6 credits (1 × 6)".
    @FindBy(xpath = "//*[not(*) and normalize-space()='Credit cost']/following::*[not(*) and contains(normalize-space(),'credits')][1]")
    WebElement creditCostText;
    @FindBy(xpath = "//button[normalize-space()='Create Virtual Tour']")
    WebElement createVirtualTourBtn; // disabled until an image is uploaded.

    // Dynamic options can't be @FindBy fields, so they are built from the option text.
    // Radix option text is written twice in nested spans ("Oswald Oswald"), so the span is checked too.
    private static final String SELECT_OPTION =
            "//*[@role='listbox']//*[@role='option'][normalize-space()='%1$s' or .//span[normalize-space()='%1$s']]";
    private static final String BACKGROUND_AUDIO_OPTION =
            "//label[normalize-space()='Background Audio']/following-sibling::div//div[span[normalize-space()='%s']]";

    public void hoverProductsMenu() {
        new Actions(driver).moveToElement(productsHoverMenuBtn).perform();
    }

    public void verifyAiVirtualTourCardDisplayed() {
        verifyDisplayed(aiVirtualTourMenuBtn, "AI Virtual Tour card is visible");
    }

    public void clickAiVirtualTourCard() {
        clickElement(aiVirtualTourMenuBtn);
    }

    // Opens the Products mega menu and navigates to the AI Virtual Tour page from it.
    public void openAiVirtualTour() {
        hoverProductsMenu();
        clickAiVirtualTourCard();
    }

    public void verifyCreatePageOpened() {
        verifyDisplayed(pageTitle, "Create AI Virtual Tour page opened");
    }

    public void clickUploadFromFilesTab() {
        clickElement(uploadFromFilesTab);
        verifyDisplayed(dropzone, "Upload From Files content is visible");
    }

    public void uploadImages(String filePath) {
        uploadFile(imagesFileInput, filePath);
    }

    public void verifyImageSelected() {
        verifyDisplayed(selectedImagesCounter, "Selected images counter is visible");
        // The counter is updated after the image is processed, so wait for "1 / 20" instead of reading it once.
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(selectedImagesCounter, "1 /"));
        } catch (org.openqa.selenium.TimeoutException e) {
            Assert.fail("Expected 1 selected image but was: " + selectedImagesCounter.getText());
        }
    }

    public void selectResolution(String option) {
        selectRadixOption(resolutionSelect, option);
    }

    public void selectOrientation(String option) {
        selectRadixOption(orientationSelect, option);
    }

    public void selectFontStyle(String option) {
        selectRadixOption(fontStyleSelect, option);
    }

    public void selectBackgroundAudio(String option) {
        clickElement(backgroundAudioDropdown);
        clickElement(driver.findElement(By.xpath(String.format(BACKGROUND_AUDIO_OPTION, option))));
        LOGGER.info("{} selected as background audio", option);
    }

    // Clicking the toggle while the panel is open would close it.
    public void openCustomiseSection() {
        if (driver.findElements(By.cssSelector("textarea[maxlength='200']")).stream().noneMatch(WebElement::isDisplayed)) {
            clickElement(customiseToggle);
        }
        verifyDisplayed(introTextArea, "Customise panel is open");
    }

    public void enterIntroText(String text) {
        sendKeysToElement(introTextArea, text);
    }

    public void enterAgentName(String text) {
        sendKeysToElement(agentNameInput, text);
    }

    public void enterPhone(String text) {
        sendKeysToElement(phoneInput, text);
    }

    public void enterEmail(String text) {
        sendKeysToElement(brandingEmailInput, text);
    }

    public void uploadProfileImage(String filePath) {
        uploadFile(profileImageFileInput, filePath);
    }

    public void uploadLogo(String filePath) {
        uploadFile(logoFileInput, filePath);
    }

    public void verifyCreditCostDisplayed() {
        verifyDisplayed(creditCostText, "Credit cost is visible");
        LOGGER.info("Credit cost: {}", creditCostText.getText());
    }

    public void clickCreateVirtualTourBtn() {
        clickElement(createVirtualTourBtn); // clickElement waits until the button is enabled.
    }

    private void selectRadixOption(WebElement select, String option) {
        clickElement(select);
        By optionLocator = By.xpath(String.format(SELECT_OPTION, option));
        clickElement(wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[role='listbox']")));
        LOGGER.info("{} selected", option);
    }

    // File inputs are display:none; the dropzone/Upload image buttons open the OS dialog, so the path is sent to the input directly.
    private void uploadFile(WebElement fileInput, String filePath) {
        String absolutePath = new File(filePath).getAbsolutePath();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);
        fileInput.sendKeys(absolutePath);
        LOGGER.info("File uploaded: {}", absolutePath);
    }
}
