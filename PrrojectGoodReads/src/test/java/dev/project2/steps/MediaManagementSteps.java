package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class MediaManagementSteps {

    @Given("the user is on the login page.")
    public void the_user_is_on_the_login_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/login.html");
    }

    @When("the user enters wherever@yahoo.com in the email field.")
    public void the_user_enters_wherever_yahoo_com_in_the_email_field() {
        TestRunner.pom.emailField.sendKeys("wherever@yahoo.com");
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
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Bookshelf Home"));
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Home");
    }



    @Given("the user is on the home page.")
    public void the_user_is_on_the_home_page() {
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Home");
    }

    @When("the user clicks the books tab.")
    public void the_user_clicks_the_books_tab() {
        TestRunner.pom.booksTab.click();
    }

    @Then("the user is redirected to the books section.")
    public void the_user_is_redirected_to_the_media_section_with_id_general_books() {
        String message = TestRunner.pom.bookHeader.getText();
        Assert.assertEquals(message, "BOOK TITLES");
    }

    @When("the user clicks the movies tab.")
    public void the_user_clicks_the_movies_tab() {
        TestRunner.pom.moviesTab.click();
    }

    @Then("the user is redirected to the movies section.")
    public void the_user_is_redirected_to_the_media_section_with_id_general_movies() {
        String message = TestRunner.pom.movieHeader.getText();
        Assert.assertEquals(message, "MOVIE TITLES");
    }

    @When("the user clicks the games tab.")
    public void the_user_clicks_the_games_tab() {
        TestRunner.pom.gamesTab.click();
    }

    @Then("the user is redirected to the games section.")
    public void the_user_is_redirected_to_the_media_section_with_id_general_games() {
        String message = TestRunner.pom.gameHeader.getText();
        Assert.assertEquals(message, "GAME TITLES");
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
//        TestRunner.explicitWait.until(ExpectedConditions.elementSelectionStateToBe(TestRunner.pom.mediaType, true));
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
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement(TestRunner.pom.addedMediaMessage,
                "Your media has been added and is awaiting approval."));
        String message = TestRunner.pom.addedMediaMessage.getText();
        Assert.assertEquals(message, "Your media has been added and is awaiting approval.");
    }




    @Given("the moderator is on the moderator page.")
    public void the_moderator_is_on_the_moderator_page() {
        TestRunner.webDriver.get("file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/moderator.html");
    }

    @When("the moderator clicks the pending media button.")
    public void the_moderator_clicks_the_pending_media_button() {
        TestRunner.pom.pendingMediaTab.click();
    }

    @When("the moderator fills in approved media id in the input field.")
    public void the_moderator_fills_in_approved_media_id_in_the_input_field() {
        TestRunner.pom.mediaIdInput.sendKeys("65");
    }

    @When("the moderator clicks the approve button.")
    public void the_moderator_clicks_the_approve_button() {
        TestRunner.pom.approveMediaButton.click();
    }

    @Then("assert message that media has been approved.")
    public void assert_message_that_media_has_been_approved() {
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement(TestRunner.pom.approveDenyMessage,
                "This title has been approved."));
        String message = TestRunner.pom.approveDenyMessage.getText();
        Assert.assertEquals(message, "This title has been approved.");
    }


    @When("the moderator fills in denied media id in the input field.")
    public void the_moderator_fills_in_denied_media_id_in_the_input_field() {
        TestRunner.pom.mediaIdInput.sendKeys("64");
    }

    @When("the moderator clicks the deny button.")
    public void the_moderator_clicks_the_deny_button() {
        TestRunner.pom.denyMediaButton.click();
    }

    @Then("assert message that media has been denied.")
    public void assert_message_that_media_has_been_denied() {
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement(TestRunner.pom.approveDenyMessage,
                "This title has been denied."));
        String message = TestRunner.pom.approveDenyMessage.getText();
        Assert.assertEquals(message, "This title has been denied.");
    }




    @Then("assert past media populates.")
    public void assert_past_media_populates() {
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Moderator Home");
    }



    @When("the moderator goes to the pending media tab.")
    public void the_moderator_goes_to_the_pending_media_tab() {
        TestRunner.pom.pendingMediaTab.click();
    }

    @When("the moderator fills in the wrong media id in the input field.")
    public void the_moderator_fills_in_the_wrong_media_id_in_the_input_field() {
        TestRunner.pom.mediaIdInput.sendKeys("100");
    }

    @When("the moderator clicks the approve button with the wrong id.")
    public void the_moderator_clicks_the_approve_button_with_the_wrong_id() {
        TestRunner.pom.approveMediaButton.click();
    }

    @Then("the title does not exist message will appear.")
    public void a_does_not_exist_message_will_appear() {
        TestRunner.explicitWait.until(ExpectedConditions.textToBePresentInElement(TestRunner.pom.approveDenyMessage,
                "This title does not exist."));
        String message = TestRunner.pom.approveDenyMessage.getText();
        Assert.assertEquals(message, "This title does not exist.");
    }



}