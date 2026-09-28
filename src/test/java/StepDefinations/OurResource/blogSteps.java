package StepDefinations.OurResource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.OurResource.blogPage;
import Utilities.BaseDriver;

public class blogSteps {

    WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(blogSteps.class);

    blogPage blogpage;

    // Driver is created in Hooks (after the browser is read from testng.xml); that's why the page is created on first use.
    private blogPage page() {
        if (blogpage == null) {
            driver = BaseDriver.getDriver();
            blogpage = new blogPage(driver);
        }
        return blogpage;
    }

    @When("click the blog button")
    public void click_the_blog_button() {
        page().clickBlogBtn();
    }

    @Then("verify that the blog page has opened")
    public void verify_that_the_blog_page_has_opened() {
        page().verifyBlogPage();
    }

    @When("click to read the Sarahs article")
    public void click_to_read_the_sarahs_article() {
        page().clickSarahsArticle();
    }

    @Then("verify that the Sarahs page opened")
    public void verify_that_the_sarahs_page_opened() {
        page().verifySarahsPage();
    }

    @When("click the back to log button")
    public void click_the_back_to_log_button() {
        page().clickBackToLog();
    }

    @Then("verify that the blog page")
    public void verify_that_the_blog_page() {
        page().verifyBlogPage();
    }

    @When("click the more articles button")
    public void click_the_more_articles_button() {
        page().clickMoreArticlesBtn();
    }

    @Then("verify the other articles are visible")
    public void verify_the_other_articles_are_visible() {
        page().verifySixthArticleVisible();
    }

    @When("click on the articles one by one.")
    public void click_on_the_articles_one_by_one() {
      page().clickArticle1();
      page().clickArticle2();
      page().clickArticle3();
      page().clickArticle4();
      page().clickArticle5();
      page().clickArticle6();
    }
}
