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
}
