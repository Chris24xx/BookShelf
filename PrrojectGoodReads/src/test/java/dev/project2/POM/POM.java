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

}
