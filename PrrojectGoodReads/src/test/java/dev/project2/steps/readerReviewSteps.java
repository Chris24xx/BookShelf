package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class readerReviewSteps {
    Actions actions = new Actions(TestRunner.webDriver);

    @Given("reader is on the homepage")
    public void readerIsOnTheHomepage() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/home-page.html");
    }

    @When("the reader selects the book tab")
    public void theReaderSelectsTheBookTab() {
        TestRunner.pom.bookTab.click();
    }

    @When("the user selects a title")
    public void theUserSelectsATitle() {
        TestRunner.pom.clickableText.click();
    }

    @Then("a list is returned with approved reviews from books tab")
    public void aListIsReturnedWithApprovedReviewsFromBooksTab() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#books-reviews-table > tr:nth-child(3) > td:nth-child(1)")));
        Assert.assertTrue(result.isDisplayed());
    }

    @When("the reader selects the movie tab")
    public void theReaderSelectsTheMovieTab() {
        TestRunner.pom.movieTab.click();
    }

    @Then("a list is returned with approved reviews from movies tab")
    public void aListIsReturnedWithApprovedReviewsFromMoviesTab() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#movie-review-table > tr > td:nth-child(1)")));
        Assert.assertTrue(result.isDisplayed());
    }

    @When("the reader selects the game tab")
    public void theReaderSelectsTheGameTab() {
        TestRunner.pom.gameTab.click();
    }

    @Then("a list is returned with approved reviews from game tab")
    public void aListIsReturnedWithApprovedReviewsFromGameTab() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#game-review-table > tr > td:nth-child(1)")));
    }

    @When("the user selects a title from the movie tab")
    public void theUserSelectsATitleFromTheMovieTab() {
        // might need to change selector type after repeated test or may fail
        TestRunner.webDriver.findElement(By.cssSelector("#movies-info > tr:nth-child(1) > td:nth-child(1)")).click();
    }

    @When("the user selects a title from the games tab")
    public void theUserSelectsATitleFromTheGamesTab() {
        //may fail due to multiple test being ran and info moved
        TestRunner.webDriver.findElement(By.cssSelector("#games-info > tr:nth-child(4) > td:nth-child(1)")).click();
    }

    @When("reader selects profile tab")
    public void readerSelectsProfileTab() {
        TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("profile"))).click();
    }

    @When("reader selects add review")
    public void readerSelectsAddReview() {
        TestRunner.webDriver.findElement(By.cssSelector("#user-media-body > tr:nth-child(1) > td:nth-child(6)")).click();
    }

    @When("reader scrolls down to new review")
    public void readerScrollsDownToNewReview() {
        actions.moveToElement(TestRunner.pom.ratingField);
    }

    @When("user enters rating in the rating field")
    public void userEntersRatingInTheRatingField() {
        TestRunner.pom.ratingField.sendKeys("5");
    }

    @When("user enters review in the review field")
    public void userEntersReviewInTheReviewField() {
        TestRunner.pom.userReviewField.sendKeys("selenium test");
    }

    @When("user submits Review")
    public void userSubmitsReview() {
        TestRunner.pom.newReviewButton.click();
    }

    @Then("user gets an alert")
    public void userGetsAnAlert() {
        Alert alert = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Success",alert.getText());
        alert.accept();
    }

    @When("reader selects a piece of media title")
    public void readerSelectsAPieceOfMediaTitle() {
        TestRunner.webDriver.findElement(By.xpath("//*[@id='user-media-body']/tr[7]/td[2]")).click();
    }

    @Then("a list is generated for the user")
    public void aListIsGeneratedForTheUser() {
        WebElement webElement = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-review-table > tr:nth-child(3) > td:nth-child(1)")));
        Assert.assertTrue(webElement.isDisplayed());
    }
}
