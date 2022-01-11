package dev.project2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM {
    private WebDriver webDriver;

    public POM(WebDriver webDriver){
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath = "/html/body/header/nav/button[3]")
    public WebElement reviewButton;

    @FindBy(id = "pending-review-table")
    public WebElement pendingReviewList;

    @FindBy(id = "approved-review-table")
    public WebElement approveReviewList;

    @FindBy(id = "updateReview")
    public WebElement reviewInputField;

    @FindBy(id = "Approve")
    public WebElement approveButton;

    @FindBy(id = "Deny")
    public WebElement denyButton;


    // MEDIA POM
    // To log in (needed for temp testing of creating media items)
    @FindBy(id = "loginEmailInput")
    public WebElement emailField;

    @FindBy(id = "loginPasswordInput")
    public WebElement passwordField;

    @FindBy(id = "loginButton")
    public WebElement loginButton;


    // To create new media
    @FindBy(id = "profile")
    public WebElement profileTab;

    @FindBy(id = "media-button")
    public WebElement newMediaButton;

    @FindBy(id = "movie-type")
    public WebElement mediaType;

    @FindBy(id = "media-title")
    public WebElement titleInput;

    @FindBy(id = "media-creator")
    public WebElement creatorInput;

    @FindBy(id = "media-genre")
    public WebElement genreInput;

    @FindBy(id = "synopsis")
    public WebElement synopsis;

    @FindBy(id = "add-a-new-title")
    public WebElement addMediaButton;

    @FindBy(id = "submit-message")
    public WebElement addedMediaMessage;


    // To approve and deny media insertions
    @FindBy(id = "pending-media")
    public WebElement pendingMediaTab;

    @FindBy(id = "media-id-input")
    public WebElement mediaIdInput;

    @FindBy(id = "media-approval-btn")
    public WebElement approveMediaButton;

    @FindBy(id = "media-deny-btn")
    public WebElement denyMediaButton;

    @FindBy(id = "approve-deny-message")
    public WebElement approveDenyMessage;

}
