package pages.OurResource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class blogPage extends BasePage {
    // Blog
    @FindBy(css = "[data-testid='link-blog']")
    WebElement blogButton;
    @FindBy(css = "[data-testid='button-read-featured']")
    WebElement readFeaturedBtn;
    @FindBy(css = "[data-testid='button-back-bottom']")
    WebElement backToBlogBtn;
    @FindBy(css = "[data-testid='button-load-more']")
    WebElement loadMoreBtn;
    @FindBy(css = "[data-testid='title-virtual-staging-roi-guide']")
    WebElement article1Btn;
    @FindBy(css = "[data-testid='title-2025-design-trends-staging']")
    WebElement article2Btn;
    @FindBy(css = "[data-testid='title-luxury-condo-case-study']")
    WebElement article3Btn;
    @FindBy(css = "[data-testid='title-ai-design-process-behind-scenes']")
    WebElement article4Btn;
    @FindBy(css = "[data-testid='title-before-after-gallery']")
    WebElement article5Btn;
    @FindBy(css = "[data-testid='title-photography-tips-staging']")
    WebElement article6Btn;
    @FindBy(css = "[data-testid='img-featured-post']")
    WebElement featuredPostImg;
    @FindBy(xpath = "//p[@data-testid='name-author' and text()='Sarah Johnson']")
    WebElement sarahJohnsonName;

    public blogPage(WebDriver driver) {
        super(driver);
    }

    public void clickBlogBtn() {
        clickElement(blogButton);
    }

    public void verifyBlogPage() {
        verifyDisplayed(featuredPostImg, "Blog page opened");
    }

    public void clickSarahsArticle() {
        clickElement(readFeaturedBtn);
    }
    public void verifySarahsPage(){verifyDisplayed(sarahJohnsonName,"Sarah's article opened");}

    public void clickBackToLog(){clickElement(backToBlogBtn);}

    public void clickMoreArticlesBtn(){clickElement(loadMoreBtn);}
    public void verifySixthArticleVisible(){verifyDisplayed(article6Btn,"Article 6 is visible");}
    public void clickArticle1(){clickElement(article1Btn);
        driver.navigate().back();
    }
    public void clickArticle2(){clickElement(article2Btn);
        driver.navigate().back();
    }
    public void clickArticle3(){clickElement(article3Btn);
        driver.navigate().back();
    }
    // Going back resets the list; articles 4-6 need "load more" clicked again.
    private void loadMoreArticlesIfNeeded() {
        By article6 = By.cssSelector("[data-testid='title-photography-tips-staging']");
        if (driver.findElements(article6).isEmpty()) {
            clickElement(loadMoreBtn);
        }
    }

    public void clickArticle4(){
        loadMoreArticlesIfNeeded();
        clickElement(article4Btn);
        driver.navigate().back();
    }
    public void clickArticle5(){
        loadMoreArticlesIfNeeded();
        clickElement(article5Btn);
        driver.navigate().back();
    }
    public void clickArticle6(){
        loadMoreArticlesIfNeeded();
        clickElement(article6Btn);
        driver.navigate().back();
    }
}
