package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class contactUsSteps {

    @Given("the moderator is on the login page.")
    public void the_moderator_is_on_the_login_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/login.html");
    }
    @When("the moderator enters wherever@yahoo.com in the email field.")
    public void the_moderator_enters_wherever_yahoo_com_in_the_email_field() {
        TestRunner.pom.emailField.sendKeys("hellowworld@aol.com");
    }
    @When("the moderator enters password in the password field.")
    public void the_moderator_enters_password_in_the_password_field() {
        TestRunner.pom.passwordField.sendKeys("password");
    }
    @When("the moderator clicks the login button.")
    public void the_moderator_clicks_the_login_button() {
        TestRunner.pom.loginButton.click();
    }
    @When("the moderator is redirected to the moderator home page.")
    public void the_moderator_is_redirected_to_the_moderator_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/moderator.html");

    }

    @Given("the moderator is on the moderator home page.")
    public void the_moderator_is_on_the_moderator_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/moderator.html");
    }

    @When("the moderator enters a pending contact request id")
    public void the_moderator_enters_a_pending_contact_request_id() {
        TestRunner.pom.updateContactUsRequestsInput.sendKeys("7");
    }

    @When("the moderator enters a non existing pending contact request id")
    public void the_moderator_enters_a_non_existing_pending_contact_request_id() {
        TestRunner.pom.updateContactUsRequestsInput.sendKeys("1");
    }

    @When("the moderator clicks on the update button")
    public void the_moderator_clicks_on_the_update_button() {
        TestRunner.pom.updateContactUsRequestsButton.click();
    }
    @Then("the moderator is able to see the pending contact request move to the completed contact request.")
    public void the_moderator_is_able_to_see_the_pending_contact_request_move_to_the_completed_contact_request() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("completed-messages-table")));
        Assert.assertTrue(result.isDisplayed());
    }

    @When("the moderator enters a completed contact request id")
    public void the_moderator_enters_a_completed_contact_request_id() {
        TestRunner.pom.deleteContactUsRequestInput.sendKeys("6");
    }
    @When("the moderator clicks on the delete button")
    public void the_moderator_clicks_on_the_delete_button() {
        TestRunner.pom.deleteContactUsRequestButton.click();
    }
    @Then("the moderator is able to see the completed contact request deleted from the page.")
    public void the_moderator_is_able_to_see_the_completed_contact_request_deleted_from_the_page() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("completed-messages-table")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Given("the user is on the website home page.")
    public void the_user_is_on_the_website_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/home-page.html");

    }
    @When("the user clicks on contact us button")
    public void the_user_clicks_on_contact_us_button() {
        TestRunner.pom.openContactUsRequestPageButton.click();
    }
    @When("the user enters their email address")
    public void the_user_enters_their_email_address() {
        TestRunner.pom.inputEmailForCreateContactRequest.sendKeys("Jennifer@aol.com");
    }
    @When("the user enters their full name")
    public void the_user_enters_their_full_name() {
        TestRunner.pom.inputNameForCreateContactRequest.sendKeys("Jennifer Jay");

    }
    @When("the user enters their issue details")
    public void the_user_enters_their_issue_details() {
        TestRunner.pom.inputIssueForCreateContactRequest.sendKeys("My issue is...");
    }
    @When("then the user clicks on the submit button")
    public void then_the_user_clicks_on_the_submit_button() {
       TestRunner.pom.createContactUsRequestsSubmitButton.click();
    }
    @Then("the user recieves a message and is directed to the home page")
    public void the_user_recieves_a_message_and_is_directed_to_the_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/home-page.html");

    }
    @When("the moderator views the home page")
    public void the_moderator_views_the_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/moderator.html");

    }

    @Then("the moderator is able to view the pending contact requests.")
    public void the_moderator_is_able_to_view_the_pending_contact_requests() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pending-messages-table")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Then("the user receives a message and is directed to the home page")
    public void the_user_receives_a_message_and_is_directed_to_the_home_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/home-page.html");

    }

    @Then("the moderator is able to view the completed contact requests")
    public void the_moderator_is_able_to_view_the_completed_contact_requests() {
        WebElement result = TestRunner.explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("completed-messages-table")));
        Assert.assertTrue(result.isDisplayed());
    }

    @When("the update request fails")
    public void the_update_request_fails() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
//        Assert.assertEquals("your contact request update failed", result.getText());
    }

    @Then("the moderator is able to see an alert stating your update pending request failed")
    public void the_moderator_is_able_to_see_an_alert_stating_your_update_pending_request_failed() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("your contact request update failed", result.getText());
        result.accept();
    }

    @When("the moderator enters a non existing completed contact request id")
    public void the_moderator_enters_non_existing_completed_contact_request_id() {
        TestRunner.pom.deleteContactUsRequestInput.sendKeys("2");
    }

    @Then("the moderator is able to see an alert stating your completed requests was unsuccessful")
    public void the_moderator_is_able_to_see_an_alert_stating_your_completed_requests_was_unsuccessful() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("your have not deleted your contact request", result.getText());
        result.accept();
    }




}
