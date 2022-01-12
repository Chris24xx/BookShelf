package dev.project2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "movies")
    public WebElement movieTab;

    @FindBy(id = "games")
    public WebElement gameTab;

    @FindBy(id = "books")
    public WebElement bookTab;

    @FindBy(id = "user-review-table")
    public WebElement reviewTable;

    @FindBy(id = "rating")
    public WebElement ratingField;

    @FindBy(id = "userReview")
    public WebElement userReviewField;

    @FindBy(id = "books-reviews-table")
    public WebElement bookTable;

    @FindBy(id = "movie-review-table")
    public WebElement movieTable;

    @FindBy(id = "game-review-table")
    public WebElement gameTable;

    @FindBy(id = "submit-new-review")
    public WebElement newReviewButton;

    @FindBy(css ="#books-info > tr:nth-child(4) > td:nth-child(1)")
    public WebElement clickableText;



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


    // create contact us request
    @FindBy(id = "contact")
    public WebElement openContactUsRequestPageButton;
    @FindBy(id = "contactUsCreateButton")
    public WebElement createContactUsRequestsSubmitButton;
    @FindBy(id = "contactUsEmailInput")
    public WebElement inputEmailForCreateContactRequest;
    @FindBy(id = "contactUsNameInput")
    public WebElement inputNameForCreateContactRequest;
    @FindBy(id = "contactUsIssueInput")
    public WebElement inputIssueForCreateContactRequest;

    // view pending and completed contact requests
    @FindBy(id = "pending-messages-table")
    public WebElement pendingContactUsRequests;
    @FindBy(id = "completed-messages-table")
    public WebElement completedContactUsRequests;

    // update pending contact request
    @FindBy(id = "updateCRButton")
    public WebElement updateContactUsRequestsButton;
    @FindBy(id = "pendingIdInput")
    public WebElement updateContactUsRequestsInput;


    // delete completed contact request
    @FindBy(id = "deleteCRButton")
    public WebElement deleteContactUsRequestButton;
    @FindBy(id = "deleteIdInput")
    public WebElement deleteContactUsRequestInput;

}
