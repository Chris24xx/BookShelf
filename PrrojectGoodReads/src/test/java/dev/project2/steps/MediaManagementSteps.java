package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MediaManagementSteps {

    @Given("the user is on the login page.")
    public void the_user_is_on_the_login_page() {
        TestRunner.webDriver.get("C:/Users/kckar/Desktop/Revature/Project-2/PrrojectGoodReads/src/main/java/dev/" +
                "project2/Website/login.html");
    }

    @When("the user enters wherever@yahoo.com in the email field.")
    public void the_user_enters_wherever_yahoo_com_in_the_email_field() {
        TestRunner.pom.emailField.sendKeys("whatever@yahoo.com");
    }

    @When("the user enters password in the password field.")
    public void the_user_enters_password_in_the_password_field() {
        TestRunner.pom.passwordField.sendKeys("password");
    }

    @When("the user clicks the login button.")
    public void the_user_clicks_the_login_button() {
        TestRunner.pom.loginButton.click();
    }

    @Then("the user is redirected to the home page.")
    public void the_user_is_redirected_to_the_home_page() {
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Home");
    }



    @Given("the user clicks on the profile tab.")
    public void the_user_clicks_on_the_profile_tab() {
        TestRunner.pom.profileTab.click();
    }

    @When("the user clicks on add new media button.")
    public void the_user_clicks_on_add_new_media_button() {
        TestRunner.pom.newMediaButton.click();
    }

    @When("the user selects type from the drop down options.")
    public void the_user_selects_type_from_the_drop_down_options() {
        TestRunner.pom.mediaType.isSelected();
    }

    @When("the user enters Snow White in the input field.")
    public void the_user_enters_snow_white_in_the_input_field() {
        TestRunner.pom.titleInput.sendKeys("Snow White");
    }

    @When("the user enters Walt Disney in the input field.")
    public void the_user_enters_walt_disney_in_the_input_field() {
        TestRunner.pom.creatorInput.sendKeys("Walt Disney");
    }

    @When("the user enters Children's Adventure in the input field.")
    public void the_user_enters_children_s_adventure_in_the_input_field() {
        TestRunner.pom.genreInput.sendKeys("Children's Adventure");
    }

    @When("the user enters Sleeping princess rescued from tower in the textarea field.")
    public void the_user_enters_sleeping_princess_rescued_from_tower_in_the_textarea_field() {
        TestRunner.pom.synopsis.sendKeys("Sleeping princess rescued from tower");
    }

    @When("the user clicks submit new media button.")
    public void the_user_clicks_submit_new_media_button() {
        TestRunner.pom.addMediaButton.click();
    }

    @Then("assert message that new media has been added.")
    public void assert_message_that_new_media_has_been_added() {
        String message = TestRunner.pom.addedMediaMessage.getText();
        Assert.assertEquals(message, "Your media has been added and is awaiting approval");
    }




    @Given("the moderator is on the moderator page.")
    public void the_moderator_is_on_the_moderator_page() {
        TestRunner.webDriver.get("C:/Users/kckar/Desktop/Revature/Project-2/PrrojectGoodReads/src/main/java/dev/" +
                "project2/Website/moderator.html");
    }

    @When("the moderator clicks the pending media button.")
    public void the_moderator_clicks_the_pending_media_button() {
        TestRunner.pom.pendingMediaTab.click();
    }

    @When("the moderator fills in media id {int} in the input field.")
    public void the_moderator_fills_in_approved_media_id_in_the_input_field(Integer int1) {
        TestRunner.pom.mediaIdInput.sendKeys("17");
    }

    @When("the moderator clicks the approve button.")
    public void the_moderator_clicks_the_approve_button() {
        TestRunner.pom.approveMediaButton.click();
    }

    @Then("assert message that media has been approved.")
    public void assert_message_that_media_has_been_approved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("the moderator fills in media id {int} in the input field.")
    public void the_moderator_fills_in_denied_media_id_in_the_input_field(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the moderator clicks the deny button.")
    public void the_moderator_clicks_the_deny_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("assert message that media has been denied.")
    public void assert_message_that_media_has_been_denied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @Then("assert past media populates.")
    public void assert_past_media_populates() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
