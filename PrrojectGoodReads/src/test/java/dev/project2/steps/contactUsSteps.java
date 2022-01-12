package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
        TestRunner.pom.updateContactUsRequestsInput.sendKeys("6");
    }
    @When("the moderator clicks on the update button")
    public void the_moderator_clicks_on_the_update_button() {
        TestRunner.pom.updateContactUsRequestsButton.click();
    }
    @Then("the moderator is able to see the pending contact request move to the completed contact request.")
    public void the_moderator_is_able_to_see_the_pending_contact_request_move_to_the_completed_contact_request() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the moderator enters a completed contact request id")
    public void the_moderator_enters_a_completed_contact_request_id() {
        TestRunner.pom.deleteContactUsRequestInput.sendKeys("12");
    }
    @When("the moderator clicks on the delete button")
    public void the_moderator_clicks_on_the_delete_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the moderator is able to see the completed contact request deleted from the page.")
    public void the_moderator_is_able_to_see_the_completed_contact_request_deleted_from_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the user is on the website home page.")
    public void the_user_is_on_the_website_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on contact us button")
    public void the_user_clicks_on_contact_us_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters their email address")
    public void the_user_enters_their_email_address() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters their full name")
    public void the_user_enters_their_full_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters their issue details")
    public void the_user_enters_their_issue_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("then the user clicks on the submit button")
    public void then_the_user_clicks_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user recieves a message and is directed to the home page")
    public void the_user_recieves_a_message_and_is_directed_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the moderator views the home page")
    public void the_moderator_views_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the moderator is able to view the pending contact requests.")
    public void the_moderator_is_able_to_view_the_pending_contact_requests() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user receives a message and is directed to the home page")
    public void the_user_receives_a_message_and_is_directed_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the moderator is able to view the completed contact requests")
    public void the_moderator_is_able_to_view_the_completed_contact_requests() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the update request fails")
    public void the_update_request_fails() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the moderator is able to see an alert stating your update pending request failed")
    public void the_moderator_is_able_to_see_an_alert_stating_your_update_pending_request_failed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the page does not load correctly")
    public void the_page_does_not_load_correctly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the moderator is able to see an alert stating your pending requests did not load")
    public void the_moderator_is_able_to_see_an_alert_stating_your_pending_requests_did_not_load() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
