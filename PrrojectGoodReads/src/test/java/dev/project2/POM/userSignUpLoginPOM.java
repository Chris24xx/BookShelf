package dev.project2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userSignUpLoginPOM {
    private WebDriver webDriver;

    public userSignUpLoginPOM(WebDriver webDriver){
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "loginPageSignUpButton")
    public WebElement signUpButton;

    @FindBy(id = "firstNameInput")
    public WebElement firstNameInput;

    @FindBy(id = "lastNameInput")
    public WebElement lastNameInput;

    @FindBy(id = "emailInput")
    public WebElement emailInput;

    @FindBy(id = "passwordInput")
    public WebElement passwordInput;

    @FindBy(id = "signUpButton")
    public WebElement createAccountButton;

    @FindBy(id = "backToLoginButton")
    public WebElement backToLoginButton;

    @FindBy(id = "homeLogoutButton")
    public WebElement homeLogoutButton;

    @FindBy(id = "users")
    public WebElement profileSearchButton;

    @FindBy(id = "makeModButton2")
    public WebElement makeModButton;
}
