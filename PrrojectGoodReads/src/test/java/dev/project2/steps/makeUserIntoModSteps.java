package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class makeUserIntoModSteps {
    @Given("the moderator is on the Moderator Page")
    public void theModeratorIsOnTheModeratorPage() {
        TestRunner.webDriver.get("C:/Users/arroy/Desktop/RevatureProjects/Project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/moderator.html");
    }

    @When("the moderator clicks the Profile Search button")
    public void theModeratorClicksTheProfileSearchButton() {
        TestRunner.signUpPOM.profileSearchButton.click();
    }

    @When("the moderator clicks the Make Moderator button for a User")
    public void theModeratorClicksTheMakeModeratorButtonForAUser() {
        TestRunner.signUpPOM.makeModButton.click();
    }

    @Then("alert shows up stating you made that user into a moderator")
    public void alertShowsUpStatingYouMadeThatUserIntoAModerator() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("With Great Power Comes Great Responsibility", result.getText());
        result.accept();
    }
}
