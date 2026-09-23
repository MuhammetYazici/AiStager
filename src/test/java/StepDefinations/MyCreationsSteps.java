package StepDefinations;

import Utilities.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.MyCreationsPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

public class MyCreationsSteps {

    private static final Logger LOGGER = LogManager.getLogger(MyCreationsSteps.class);

    MyCreationsPage myCreationsPage = new MyCreationsPage(BaseDriver.getDriver());

    private static final Path DOWNLOAD_DIR = Paths.get("target", "downloads");

    private String recordedCredits;
    private String openedCardId;
    private int recordedResultCount;
    private int recordedVariantCount;
    private String recordedFirstVariantLink;
    private String previewSourceBefore;

    @When("the user hovers over the my creations menu")
    public void theUserHoversOverTheMyCreationsMenu() {
        LOGGER.info("the user hovers over the my creations menu");
        myCreationsPage.hoverMyCreationsMenu();
    }

    @Then("the my creations menu lists two options")
    public void theMyCreationsMenuListsTwoOptions() {
        LOGGER.info("the my creations menu lists two options");
        Assert.assertEquals(myCreationsPage.getMyCreationsMenuOptionCount(), 2,
                "The my creations menu does not list two options");
    }

    @When("the user clicks the my photos option")
    public void theUserClicksTheMyPhotosOption() {
        LOGGER.info("the user clicks the my photos option");
        myCreationsPage.clickMyPhotosOption();
    }

    @When("the user clicks the my videos option")
    public void theUserClicksTheMyVideosOption() {
        LOGGER.info("the user clicks the my videos option");
        myCreationsPage.clickMyVideosOption();
    }

    @Then("the my photos heading is {string}")
    public void theMyPhotosHeadingIs(String expected) {
        LOGGER.info("the my photos heading is {}", expected);
        Assert.assertEquals(myCreationsPage.getMyPhotosHeading(), expected, "My Photos heading is not as expected");
    }

    @Then("the photo grid lists at least one card")
    public void thePhotoGridListsAtLeastOneCard() {
        LOGGER.info("the photo grid lists at least one card");
        Assert.assertTrue(myCreationsPage.getPhotoCardCount() > 0, "No photo card is listed");
    }

    @Then("every photo card shows an image, a title and a date")
    public void everyPhotoCardShowsAnImageATitleAndADate() {
        LOGGER.info("every photo card shows an image, a title and a date");
        Assert.assertTrue(myCreationsPage.everyPhotoCardHasImageTitleAndDate(),
                "A photo card is missing its image, title or date");
    }

    @Then("the photo cards are ordered by date, newest first")
    public void thePhotoCardsAreOrderedByDateNewestFirst() {
        LOGGER.info("the photo cards are ordered by date, newest first");
        Assert.assertTrue(myCreationsPage.arePhotoCardsOrderedNewestFirst(),
                "Photo cards are not ordered newest first");
    }

    // Karti acmadan once iki deger kaydedilir: kartin sonuc sayisi ve kimligi. Yeniden uretimden
    // sonra "bir artti" ve "bu kart basa gecti" kontrolleri bu degerlerle yapilir.
    @When("the user opens the first photo card")
    public void theUserOpensTheFirstPhotoCard() {
        LOGGER.info("the user opens the first photo card");
        recordedResultCount = myCreationsPage.getPhotoCardResultCount(myCreationsPage.getFirstPhotoCardId());
        openedCardId = myCreationsPage.openFirstPhotoCard();
    }

    @When("the user reopens the first photo card")
    public void theUserReopensTheFirstPhotoCard() {
        LOGGER.info("the user reopens the first photo card");
        myCreationsPage.openFirstPhotoCard();
    }

    @Then("the regenerated card is first in the grid")
    public void theRegeneratedCardIsFirstInTheGrid() {
        LOGGER.info("the regenerated card is first in the grid");
        Assert.assertEquals(myCreationsPage.getFirstPhotoCardId(), openedCardId,
                "The regenerated card did not move to the top of the grid");
    }

    @Then("the first photo card date is today")
    public void theFirstPhotoCardDateIsToday() {
        LOGGER.info("the first photo card date is today");
        Assert.assertEquals(myCreationsPage.getFirstPhotoCardDate(), LocalDate.now(),
                "The first card's date is not today");
    }

    @Then("the first photo card result count increased by one")
    public void theFirstPhotoCardResultCountIncreasedByOne() {
        LOGGER.info("the first photo card result count increased by one");
        Assert.assertEquals(myCreationsPage.getPhotoCardResultCount(openedCardId), recordedResultCount + 1,
                "The card's result count did not go up by one");
    }

    @Then("the photo modal is open")
    public void thePhotoModalIsOpen() {
        LOGGER.info("the photo modal is open");
        Assert.assertTrue(myCreationsPage.isPhotoModalOpen(), "The preview modal did not open");
    }

    @Then("the preview image is displayed")
    public void thePreviewImageIsDisplayed() {
        LOGGER.info("the preview image is displayed");
        Assert.assertTrue(myCreationsPage.isPreviewImageDisplayed(), "The preview image is not displayed");
    }

    @Then("the preview caption shows a date and a title")
    public void thePreviewCaptionShowsADateAndATitle() {
        LOGGER.info("the preview caption shows a date and a title");
        String caption = myCreationsPage.getPreviewCaption();
        Assert.assertTrue(caption.contains("·"),
                "The caption does not carry both a date and a title: " + caption);
    }

    @Then("the download, continue editing and regenerate buttons are clickable")
    public void theModalButtonsAreClickable() {
        LOGGER.info("the download, continue editing and regenerate buttons are clickable");
        Assert.assertTrue(myCreationsPage.areModalButtonsClickable(),
                "One of the modal action buttons is not clickable");
    }

    @When("the user selects the {string} variant")
    public void theUserSelectsTheVariant(String title) {
        LOGGER.info("the user selects the {} variant", title);
        previewSourceBefore = myCreationsPage.getPreviewImageSource();
        myCreationsPage.selectVariant(title);
    }

    @Then("the preview image changes")
    public void thePreviewImageChanges() {
        LOGGER.info("the preview image changes");
        Assert.assertTrue(myCreationsPage.waitForPreviewImageToChange(previewSourceBefore),
                "The preview image did not change after selecting the variant");
    }

    @When("the credit balance is recorded")
    public void theCreditBalanceIsRecorded() {
        LOGGER.info("the credit balance is recorded");
        recordedCredits = myCreationsPage.getCreditBalance();
    }

    @Then("the credit balance is numeric")
    public void theCreditBalanceIsNumeric() {
        LOGGER.info("the credit balance is numeric");
        Assert.assertTrue(recordedCredits.matches("\\d+"),
                "The credit value is not numeric: " + recordedCredits);
    }

    @When("the user clicks the regenerate button")
    public void theUserClicksTheRegenerateButton() {
        LOGGER.info("the user clicks the regenerate button");
        myCreationsPage.clickRegenerateButton();
    }

    @Then("the generate new design button is displayed")
    public void theGenerateNewDesignButtonIsDisplayed() {
        LOGGER.info("the generate new design button is displayed");
        Assert.assertTrue(myCreationsPage.isGenerateNewDesignDisplayed(),
                "The Generate New Design button is not displayed");
    }

    @When("the user starts the regeneration")
    public void theUserStartsTheRegeneration() {
        LOGGER.info("the user starts the regeneration");
        recordedVariantCount = myCreationsPage.getVariantCount();
        recordedFirstVariantLink = myCreationsPage.getFirstVariantLink();
        myCreationsPage.clickGenerateNewDesign();
    }

    @Then("the regeneration completes")
    public void theRegenerationCompletes() {
        LOGGER.info("the regeneration completes");
        Assert.assertTrue(myCreationsPage.waitForRegeneration(recordedVariantCount),
                "The regeneration did not finish in time");
    }

    @Then("the variant count increased by one")
    public void theVariantCountIncreasedByOne() {
        LOGGER.info("the variant count increased by one");
        Assert.assertEquals(myCreationsPage.getVariantCount(), recordedVariantCount + 1,
                "The number of thumbnails did not go up by one");
    }

    @Then("the new variant is first in the strip")
    public void theNewVariantIsFirstInTheStrip() {
        LOGGER.info("the new variant is first in the strip");
        Assert.assertNotEquals(myCreationsPage.getFirstVariantLink(), recordedFirstVariantLink,
                "The first thumbnail is still the one from before the regeneration");
    }

    @Then("the preview date is today")
    public void thePreviewDateIsToday() {
        LOGGER.info("the preview date is today");
        Assert.assertEquals(myCreationsPage.getPreviewDate(), LocalDate.now(),
                "The preview date is not today");
    }

    @Then("the credit balance is unchanged")
    public void theCreditBalanceIsUnchanged() {
        LOGGER.info("the credit balance is unchanged");
        Assert.assertEquals(myCreationsPage.getCreditBalance(), recordedCredits,
                "The credit balance changed although the regeneration should not spend a credit");
    }

    @When("the user closes the photo modal")
    public void theUserClosesThePhotoModal() {
        LOGGER.info("the user closes the photo modal");
        myCreationsPage.closePhotoModal();
    }

    @Then("the photo modal is closed")
    public void thePhotoModalIsClosed() {
        LOGGER.info("the photo modal is closed");
        Assert.assertTrue(myCreationsPage.waitForPhotoModalClosed(), "The preview modal did not close");
    }

    @When("the user presses escape")
    public void theUserPressesEscape() {
        LOGGER.info("the user presses escape");
        myCreationsPage.pressEscape();
    }

    @When("the user clicks outside the modal")
    public void theUserClicksOutsideTheModal() {
        LOGGER.info("the user clicks outside the modal");
        myCreationsPage.clickOutsideModal();
    }

    @When("the variant count is recorded")
    public void theVariantCountIsRecorded() {
        LOGGER.info("the variant count is recorded");
        recordedVariantCount = myCreationsPage.getVariantCount();
    }

    @Then("the variant count is unchanged")
    public void theVariantCountIsUnchanged() {
        LOGGER.info("the variant count is unchanged");
        Assert.assertEquals(myCreationsPage.getVariantCount(), recordedVariantCount,
                "A new variant was created although the regeneration was never submitted");
    }

    @Then("the generate new design button is not displayed")
    public void theGenerateNewDesignButtonIsNotDisplayed() {
        LOGGER.info("the generate new design button is not displayed");
        Assert.assertFalse(myCreationsPage.isGenerateNewDesignPresent(),
                "The regeneration panel is still open after reopening the modal");
    }

    @When("the user clicks the continue editing button")
    public void theUserClicksTheContinueEditingButton() {
        LOGGER.info("the user clicks the continue editing button");
        myCreationsPage.clickContinueEditingButton();
    }

    @When("the user clicks the download button")
    public void theUserClicksTheDownloadButton() throws IOException {
        LOGGER.info("the user clicks the download button");
        Files.createDirectories(DOWNLOAD_DIR);
        clearDownloadDir();
        myCreationsPage.enableDownloadsTo(DOWNLOAD_DIR);
        myCreationsPage.clickDownloadButton();
    }

    @Then("a file starting with {string} and ending with {string} is downloaded")
    public void aFileIsDownloaded(String prefix, String suffix) {
        LOGGER.info("a file starting with {} and ending with {} is downloaded", prefix, suffix);
        Assert.assertTrue(myCreationsPage.waitForDownloadedFile(DOWNLOAD_DIR, prefix, suffix),
                "No file named " + prefix + "*" + suffix + " appeared in " + DOWNLOAD_DIR);
    }

    @After("@MyCreations")
    public void removeDownloads() {
        clearDownloadDir();
    }

    private void clearDownloadDir() {
        if (!Files.isDirectory(DOWNLOAD_DIR)) {
            return;
        }
        try (Stream<Path> files = Files.list(DOWNLOAD_DIR)) {
            files.forEach(file -> {
                try {
                    Files.deleteIfExists(file);
                } catch (IOException ignored) {
                }
            });
        } catch (IOException ignored) {
        }
    }

    @Then("the my videos heading is {string}")
    public void theMyVideosHeadingIs(String expected) {
        LOGGER.info("the my videos heading is {}", expected);
        Assert.assertEquals(myCreationsPage.getMyVideosHeading(), expected, "My Videos heading is not as expected");
    }

    @Then("the video grid lists at least one card")
    public void theVideoGridListsAtLeastOneCard() {
        LOGGER.info("the video grid lists at least one card");
        Assert.assertTrue(myCreationsPage.getVideoCardCount() > 0, "No video card is listed");
    }

    @Then("every video card shows an image, a title, a date and the credits used")
    public void everyVideoCardShowsRequiredInfo() {
        LOGGER.info("every video card shows an image, a title, a date and the credits used");
        Assert.assertTrue(myCreationsPage.everyVideoCardHasRequiredInfo(),
                "A video card is missing its image, title, date or credit information");
    }

    @Then("the video cards are ordered by date, newest first")
    public void theVideoCardsAreOrderedByDateNewestFirst() {
        LOGGER.info("the video cards are ordered by date, newest first");
        Assert.assertTrue(myCreationsPage.areVideoCardsOrderedNewestFirst(),
                "Video cards are not ordered newest first");
    }

    @When("the user opens the first video card")
    public void theUserOpensTheFirstVideoCard() {
        LOGGER.info("the user opens the first video card");
        myCreationsPage.openFirstVideoCard();
    }

    @Then("the url contains {string}")
    public void theUrlContains(String expected) {
        LOGGER.info("the url contains {}", expected);
        String actual = myCreationsPage.waitForUrlToContain(expected);
        Assert.assertTrue(actual.contains(expected),
                "URL does not contain the expected part. Expected: " + expected + " | Actual: " + actual);
    }

    @Then("the virtual tour heading is {string}")
    public void theVirtualTourHeadingIs(String expected) {
        LOGGER.info("the virtual tour heading is {}", expected);
        Assert.assertEquals(myCreationsPage.getVirtualTourHeading(), expected,
                "Virtual tour heading is not as expected");
    }

    @Then("a video player is displayed")
    public void aVideoPlayerIsDisplayed() {
        LOGGER.info("a video player is displayed");
        Assert.assertTrue(myCreationsPage.isVideoPlayerDisplayed(), "No video player is present on the page");
    }

    @When("the user returns to the my photos page")
    public void theUserReturnsToTheMyPhotosPage() {
        LOGGER.info("the user returns to the my photos page");
        myCreationsPage.navigateBackToMyPhotos();
    }

    @When("the user returns to the my videos page")
    public void theUserReturnsToTheMyVideosPage() {
        LOGGER.info("the user returns to the my videos page");
        myCreationsPage.navigateBackToMyVideos();
    }
}
