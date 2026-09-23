package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MyCreationsPage extends BasePage {

    public MyCreationsPage(WebDriver driver) {
        super(driver);
    }

    private static final Duration ELEMENT_TIMEOUT      = Duration.ofSeconds(15);
    private static final Duration PAGE_TIMEOUT         = Duration.ofSeconds(30);
    private static final Duration REGENERATION_TIMEOUT = Duration.ofSeconds(60);
    private static final Duration DOWNLOAD_TIMEOUT     = Duration.ofSeconds(30);

    private static final DateTimeFormatter CARD_DATE = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
    private static final Pattern DATE_IN_TEXT   = Pattern.compile("[A-Z][a-z]{2} \\d{1,2}, \\d{4}");
    private static final Pattern RESULT_COUNT   = Pattern.compile("(\\d+)\\s+results?");
    private static final Pattern CAPTION_LINE   = Pattern.compile("[A-Z][a-z]{2} \\d{1,2}, \\d{4}[^\\n]*");

    @FindBy(css = "[data-testid='nav-link-my-creations']")
    List<WebElement> myCreationsMenus;
    @FindBy(css = "[data-testid='photo-credits']")
    List<WebElement> creditValues;
    @FindBy(css = "[data-testid='dropdown-my-creations']")
    List<WebElement> myCreationsDropdowns;
    @FindBy(css = "[data-testid='dropdown-link-my-photos']")
    List<WebElement> myPhotosLinks;
    @FindBy(css = "[data-testid='dropdown-link-my-videos']")
    List<WebElement> myVideosLinks;
    @FindBy(css = "[data-testid='text-my-photos-title']")
    WebElement myPhotosHeading;
    @FindBy(css = "[data-testid='photos-grid']")
    WebElement photosGrid;
    @FindBy(css = "[data-testid^='photo-card-']")
    List<WebElement> photoCards;
    @FindBy(css = "[data-testid='photo-modal']")
    List<WebElement> photoModals;
    @FindBy(css = "[data-testid='img-photo-preview']")
    WebElement previewImage;
    @FindBy(css = "[data-testid='button-download-modal']")
    WebElement downloadBtn;
    @FindBy(css = "[data-testid='button-continue-editing']")
    WebElement continueEditingBtn;
    @FindBy(css = "[data-testid='button-regenerate']")
    WebElement regenerateBtn;
    @FindBy(css = "[data-testid='button-regenerate-submit']")
    List<WebElement> generateNewDesignBtns;
    @FindBy(css = "[data-testid='button-close-modal']")
    WebElement closeModalBtn;
    @FindBy(css = "[data-testid^='button-download-strip-']")
    List<WebElement> variantDownloadIcons;
    @FindBy(css = "[data-testid='text-my-videos-title']")
    WebElement myVideosHeading;
    @FindBy(css = "[data-testid='videos-grid']")
    WebElement videosGrid;
    @FindBy(css = "[data-testid^='video-card-']")
    List<WebElement> videoCards;
    @FindBy(css = "h1")
    WebElement virtualTourHeading;
    @FindBy(css = "video")
    List<WebElement> videoPlayers;

    private String textOf(WebElement element) {

        return element.getText().trim().replaceAll("\\s+", " ");
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

    private void scrollToCenter(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", element);
    }

    private void waitForPhotoCards() {
        waitFor(PAGE_TIMEOUT).until(d -> !photoCards.isEmpty() && photoCards.get(0).isDisplayed());
    }

    private void waitForVideoCards() {
        waitFor(PAGE_TIMEOUT).until(d -> !videoCards.isEmpty() && videoCards.get(0).isDisplayed());
    }

    private LocalDate parseDateIn(String text) {
        Matcher m = DATE_IN_TEXT.matcher(text);
        if (!m.find()) {
            throw new IllegalStateException("No date found in: " + text);
        }
        return LocalDate.parse(m.group(), CARD_DATE);
    }

    private boolean isOrderedNewestFirst(List<LocalDate> dates) {
        for (int i = 1; i < dates.size(); i++) {
            if (dates.get(i).isAfter(dates.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    public void hoverMyCreationsMenu() {
        new Actions(driver).moveToElement(firstVisible(myCreationsMenus)).perform();
        waitFor(ELEMENT_TIMEOUT).until(
                d -> !myPhotosLinks.isEmpty() && myPhotosLinks.get(0).isDisplayed());
    }

    public int getMyCreationsMenuOptionCount() {
        int count = 0;
        if (!myPhotosLinks.isEmpty()) count++;
        if (!myVideosLinks.isEmpty()) count++;
        return count;
    }

    public void clickMyPhotosOption() {
        clickMenuOption(myPhotosLinks);
    }

    public void clickMyVideosOption() {
        clickMenuOption(myVideosLinks);
    }

    private void clickMenuOption(List<WebElement> links) {
        new Actions(driver)
                .moveToElement(firstVisible(myCreationsMenus))
                .moveToElement(links.get(0))
                .click()
                .perform();
    }

    public String getCreditBalance() {
        return textOf(firstVisible(creditValues));
    }

    public String getMyPhotosHeading() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(myPhotosHeading));
        return textOf(myPhotosHeading);
    }

    public int getPhotoCardCount() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(photosGrid));
        waitForPhotoCards();
        return photoCards.size();
    }

    public boolean everyPhotoCardHasImageTitleAndDate() {
        for (WebElement card : photoCards) {
            String id = cardId(card, "photo-card-");
            if (driver.findElements(By.cssSelector("[data-testid='img-photo-" + id + "']")).isEmpty()) return false;
            List<WebElement> title = driver.findElements(By.cssSelector("[data-testid='text-photo-title-" + id + "']"));
            if (title.isEmpty() || textOf(title.get(0)).isEmpty()) return false;
            if (!DATE_IN_TEXT.matcher(textOf(card)).find()) return false;
        }
        return true;
    }

    public boolean arePhotoCardsOrderedNewestFirst() {
        return isOrderedNewestFirst(photoCards.stream().map(c -> parseDateIn(textOf(c))).toList());
    }

    public String openFirstPhotoCard() {
        waitForPhotoCards();
        return openPhotoCard(photoCards.get(0));
    }
    private String openPhotoCard(WebElement card) {
        String id = cardId(card, "photo-card-");
        scrollToCenter(card);
        card.click();
        waitFor(ELEMENT_TIMEOUT).until(d -> !photoModals.isEmpty() && photoModals.get(0).isDisplayed());
        return id;
    }

    public String getFirstPhotoCardId() {
        waitForPhotoCards();
        return cardId(photoCards.get(0), "photo-card-");
    }

    public LocalDate getFirstPhotoCardDate() {
        waitForPhotoCards();
        return parseDateIn(textOf(photoCards.get(0)));
    }

    public int getPhotoCardResultCount(String cardId) {
        WebElement card = driver.findElement(By.cssSelector("[data-testid='photo-card-" + cardId + "']"));
        Matcher m = RESULT_COUNT.matcher(textOf(card));
        return m.find() ? Integer.parseInt(m.group(1)) : 1;
    }

    private String cardId(WebElement card, String prefix) {
        return card.getDomAttribute("data-testid").substring(prefix.length());
    }

    public boolean isPhotoModalOpen() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(d -> !photoModals.isEmpty() && photoModals.get(0).isDisplayed());
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForPhotoModalClosed() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(d -> photoModals.isEmpty() || !photoModals.get(0).isDisplayed());
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isPreviewImageDisplayed() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOf(previewImage)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPreviewCaption() {
        Matcher m = CAPTION_LINE.matcher(photoModals.get(0).getText());
        if (!m.find()) {
            throw new IllegalStateException("No caption with a date found in the modal");
        }
        return m.group().trim();
    }

    public LocalDate getPreviewDate() {
        return parseDateIn(getPreviewCaption());
    }

    public boolean areModalButtonsClickable() {
        return Stream.of(downloadBtn, continueEditingBtn, regenerateBtn)
                .allMatch(b -> b.isDisplayed() && b.isEnabled());
    }

    public String getPreviewImageSource() {
        return previewImage.getDomAttribute("src");
    }

    public void selectVariant(String title) {
        WebElement modal = photoModals.get(0);
        WebElement variant = modal.findElement(By.cssSelector("button[title='" + title + "']"));
        scrollToCenter(variant);
        variant.click();
    }

    public boolean waitForPreviewImageToChange(String previousSource) {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(d -> !getPreviewImageSource().equals(previousSource));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public int getVariantCount() {
        return variantDownloadIcons.size();
    }

    public String getFirstVariantLink() {
        return variantDownloadIcons.get(0).getDomAttribute("href");
    }

    public void clickRegenerateButton() {
        scrollToCenter(regenerateBtn);
        regenerateBtn.click();
    }

    public boolean isGenerateNewDesignDisplayed() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(
                    d -> !generateNewDesignBtns.isEmpty() && generateNewDesignBtns.get(0).isDisplayed());
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickGenerateNewDesign() {
        WebElement submit = generateNewDesignBtns.get(0);
        scrollToCenter(submit);
        submit.click();
    }

    public boolean waitForRegeneration(int previousVariantCount) {
        try {
            return waitFor(REGENERATION_TIMEOUT).until(d -> getVariantCount() > previousVariantCount);
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickDownloadButton() {
        scrollToCenter(downloadBtn);
        downloadBtn.click();
    }

    public void clickContinueEditingButton() {
        scrollToCenter(continueEditingBtn);
        continueEditingBtn.click();
    }

    public void closePhotoModal() {
        closeModalBtn.click();
    }

    public void pressEscape() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public void clickOutsideModal() {
        WebElement backdrop = driver.findElements(By.cssSelector("body > div")).stream()
                .filter(d -> d.getDomAttribute("class") != null && d.getDomAttribute("class").contains("bg-black/80"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Modal backdrop not found"));
        Dimension size = backdrop.getSize();
        new Actions(driver)
                .moveToElement(backdrop, -size.getWidth() / 2 + 5, -size.getHeight() / 2 + 5)
                .click()
                .perform();
    }

    public boolean isGenerateNewDesignPresent() {
        return !generateNewDesignBtns.isEmpty();
    }

    public String getMyVideosHeading() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(myVideosHeading));
        return textOf(myVideosHeading);
    }

    public int getVideoCardCount() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(videosGrid));
        waitForVideoCards();
        return videoCards.size();
    }

    public boolean everyVideoCardHasRequiredInfo() {
        for (WebElement card : videoCards) {
            String text = textOf(card);
            if (card.findElements(By.cssSelector("img")).isEmpty()) return false;
            if (!DATE_IN_TEXT.matcher(text).find()) return false;
            if (!text.toLowerCase().contains("credits")) return false;
        }
        return true;
    }

    public boolean areVideoCardsOrderedNewestFirst() {
        return isOrderedNewestFirst(videoCards.stream().map(c -> parseDateIn(textOf(c))).toList());
    }

    public void openFirstVideoCard() {
        waitForVideoCards();
        WebElement card = videoCards.get(0);
        scrollToCenter(card);
        card.click();
    }

    public String getVirtualTourHeading() {
        waitFor(PAGE_TIMEOUT).until(ExpectedConditions.visibilityOf(virtualTourHeading));
        return textOf(virtualTourHeading);
    }

    public boolean isVideoPlayerDisplayed() {
        try {
            return waitFor(ELEMENT_TIMEOUT).until(d -> !videoPlayers.isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String waitForUrlToContain(String part) {
        try {
            waitFor(PAGE_TIMEOUT).until(ExpectedConditions.urlContains(part));
        } catch (TimeoutException e) {
        }
        return driver.getCurrentUrl();
    }

    public void navigateBackToMyPhotos() {
        driver.navigate().back();
        WebDriverWait wait = waitFor(PAGE_TIMEOUT);
        wait.until(ExpectedConditions.urlContains("/my-photos"));
        wait.until(ExpectedConditions.visibilityOf(myPhotosHeading));
    }

    public void navigateBackToMyVideos() {
        driver.navigate().back();
        WebDriverWait wait = waitFor(PAGE_TIMEOUT);
        wait.until(ExpectedConditions.urlContains("/my-videos"));
        wait.until(ExpectedConditions.visibilityOf(myVideosHeading));
    }

    // Chrome'a "indirdigin dosyalari su klasore koy" der. Normalde bu ayar ChromeOptions ile
    // surucu olusturulurken yapilir ama orasi BaseDriver'da, ortak dosyaya dokunmamak icin
    // CDP komutuyla surucu ayaga kalktiktan sonra ayarliyoruz. Sadece Chrome/Edge'de calisir.
    public void enableDownloadsTo(Path directory) {
        if (!(driver instanceof ChromiumDriver chromium)) {
            throw new IllegalStateException("Download redirection needs a Chromium browser, this run uses " + driver.getClass().getSimpleName());
        }
        chromium.executeCdpCommand("Browser.setDownloadBehavior", Map.of(
                "behavior", "allow",
                "downloadPath", directory.toAbsolutePath().toString()));
    }

    public boolean waitForDownloadedFile(Path directory, String prefix, String suffix) {
        try {
            return waitFor(DOWNLOAD_TIMEOUT).until(d -> findDownload(directory, prefix, suffix) != null);
        } catch (TimeoutException e) {
            return false;
        }
    }

    private Path findDownload(Path directory, String prefix, String suffix) {
        try (Stream<Path> files = Files.list(directory)) {
            return files.filter(p -> {
                        String name = p.getFileName().toString();
                        return name.startsWith(prefix) && name.endsWith(suffix);
                    })
                    .findFirst()
                    .orElse(null);
        } catch (IOException e) {
            return null;
        }
    }
}
