import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test
    public void searchKeyword(String keyword, WebDriver driver) throws InterruptedException {
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys(keyword);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("algolia-autocomplete-listbox-0")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".algolia-docsearch-suggestion__main"))).click();

    }
}
