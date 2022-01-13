package dev.project2.steps;

import dev.project2.runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class userSignUpLoginSteps {
    String compFilePath = "file:///C:/Users/track/OneDrive/Desktop/Revature/project2/Project-2/PrrojectGoodReads/src/main/java/dev/project2/Website/";

    @Given("the user is on the Login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.webDriver.get(compFilePath + "login.html");
    }
    @When("the user clicks on the sign up button")
    public void the_user_clicks_on_the_sign_up_button() {
        TestRunner.signUpPOM.signUpButton.click();

    }

    @When("the user inputs their first name in the First Name field")
    public void the_user_inputs_their_first_name_in_the_first_name_field() {
        TestRunner.signUpPOM.firstNameInput.sendKeys("Selenium");
    }

    @When("the user inputs their last name in the Last Name field")
    public void the_user_inputs_their_last_name_in_the_last_name_field() {
        TestRunner.signUpPOM.lastNameInput.sendKeys("Selenium");
    }

    @When("the user inputs their email in the Email field")
    public void the_user_inputs_their_email_in_the_email_field() {
        TestRunner.signUpPOM.emailInput.sendKeys("reallasjdflsfgh;adfj@testemail.com");
    }

    @When("the user inputs their password in the Password field")
    public void the_user_inputs_their_password_in_the_password_field() {
        TestRunner.signUpPOM.passwordInput.sendKeys("SeleniumPassword");
    }

    @When("the user clicks the Sign Up button")
    public void the_user_clicks_the_sign_up_button() {
        TestRunner.signUpPOM.createAccountButton.click();
    }

    @Then("the user has created their account and redirected to the Home page")
    public void the_user_has_created_their_account_and_redirected_to_the_home_page() {
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Bookshelf Home"));
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Home");
    }

    @Given("the user is on the Sign Up page")
    public void the_user_is_on_the_sign_up_page(){
        TestRunner.webDriver.get(compFilePath + "sign-up.html");

    }

    @When("the user clicks on the Already have an account button")
    public void the_user_clicks_on_the_already_have_an_account_button(){
        TestRunner.signUpPOM.backToLoginButton.click();
    }

    @Then("the user gets redirected to the Login page")
    public void the_user_gets_redirected_to_the_login_page(){
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Sign In");
    }

    @When("the user inputs email in the Email field")
    public void the_user_inputs_email_in_the_email_field() {
        TestRunner.pom.emailField.sendKeys("a@email.com");
    }
    @When("the user inputs a wrong password in the Password field")
    public void the_user_inputs_a_wrong_password_in_the_password_field() {
        TestRunner.pom.passwordField.sendKeys("WRONG");
    }
    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        TestRunner.pom.loginButton.click();
    }
    @Then("alert shows up stating Incorrect email or Password")
    public void alert_shows_up_stating_incorrect_email_or_password() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Incorrect email or Password", result.getText());
        result.accept();
    }

    @When("the user doesn't input something into the information fields")
    public void the_user_doesn_t_input_something_into_the_information_fields() {
        TestRunner.signUpPOM.emailInput.sendKeys("newerSelenium@email.com");
    }
    @Then("alert shows up stating One of the inputs is empty")
    public void alert_shows_up_stating_one_of_the_inputs_is_empty() {
        Alert result = TestRunner.explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("One of the inputs is empty", result.getText());
        result.accept();
    }

    @Given("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        TestRunner.webDriver.get(compFilePath + "home-page.html");

    }
    @When("the user clicks the Logout button")
    public void the_user_clicks_the_logout_button() {
        TestRunner.signUpPOM.homeLogoutButton.click();
    }
    @Then("get redirected to the Login page")
    public void get_redirected_to_the_login_page() {
        String title = TestRunner.webDriver.getTitle();
        Assert.assertEquals(title, "Bookshelf Sign In");
    }
}
