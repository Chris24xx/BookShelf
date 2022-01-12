package dev.project2.steps;
import dev.project2.runner.TestRunner;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class managerReviewSteps {
    @Given("Moderator is on the moderator home page")
    public void moderator_is_on_the_moderator_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.webDriver.get("file:///C:/Users/chris/OneDrive/Desktop/" +
                "Revature/Project-2/PrrojectGoodReads/" +
                "src/main/java/dev/project2/Website/moderator.html");
    }
    @When("the Moderator clicks the pending review tab")
    public void the_moderator_clicks_the_pending_review_tab() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.pom.reviewButton.click();
    }
    @Then("a pending list is returned to the moderator")
    public void a_pending_list_is_returned_to_the_moderator() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#pending-review-table > tr:nth-child(3) > td:nth-child(1)")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Then("an approved list is returned to the moderator")
    public void an_approved_list_is_returned_to_the_moderator() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#approved-review-table > tr:nth-child(3)")));
        Assert.assertTrue(result.isDisplayed());
    }


    @When("the moderator inputs a mediaId into a field")
    public void theModeratorInputsAMediaIdIntoAField() {
        Actions actions = new Actions(TestRunner.webDriver);
        actions.moveToElement(TestRunner.pom.reviewInputField);
        TestRunner.pom.reviewInputField.sendKeys("22");
    }

    @When("the moderator clicks the approve button")
    public void theModeratorClicksTheApproveButton() {
        TestRunner.pom.approveButton.click();
    }

    @Then("an alert will appear")
    public void anAlertWillAppear() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Success", result.getText());
        result.accept();
    }


    @When("the moderator inputs a mediaId into a field to be deleted")
    public void theModeratorInputsAMediaIdIntoAFieldToBeDeleted() {
        TestRunner.pom.reviewInputField.sendKeys("23");
    }

    @When("the moderator clicks the deny button")
    public void theModeratorClicksTheDenyButton() {
        TestRunner.pom.denyButton.click();
    }
}
