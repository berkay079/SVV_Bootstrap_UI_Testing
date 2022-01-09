import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "/Users/mervebaykara/Downloads/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://getbootstrap.com");

    }

    @Test
    public void getStartedTest() throws InterruptedException {
        String testState = "";
        String introductionUrl = "https://getbootstrap.com/docs/5.1/getting-started/introduction/";

        WebElement getStartedButton = driver.findElement(new By.ByLinkText("Get started"));
        getStartedButton.click();

        String URL = driver.getCurrentUrl();
        boolean isURLIntroduction =  URL.equals(introductionUrl);

        String actualTitle = driver.findElement(By.id("content")).getText();
        boolean isTitleIntroduction = actualTitle.contains("Introduction");

        if(isURLIntroduction && isTitleIntroduction) {
            testState = "Test Passed";
        }
        else {
            testState = "Test Failed";
        }
        Assert.assertEquals(testState,"Test Passed");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.urlToBe(introductionUrl));

        SearchTest searchTest = new SearchTest();
        searchTest.searchKeyword("Download",driver);

    }





   /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/

}
