package dev.project2.runner;

import dev.project2.POM.POM;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

// this lets us use the Cucumber testing framework with Junit
@RunWith(Cucumber.class)


@CucumberOptions(features = "classpath:features", glue = "dev/project2/steps")
public class TestRunner{
    public static WebDriver webDriver;
    public static POM pom;
    public static WebDriverWait explicitWait;

    @BeforeClass
    public static void setup(){
        File file = new File("src/main/resources/msedgedriver.exe");
        System.setProperty("webdriver.edge.webDriver", file.getAbsolutePath());
        webDriver = new EdgeDriver();
        pom = new POM(webDriver);
        System.out.println("setup complete!");
        //SETUP IMPLICIT WAIT
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown(){
        //end the driver
        webDriver.quit();
        System.out.println("teardown complete!");
    }

}
