import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class stockExchange {
    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void dataTable(){
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        WebElement table = driver.findElement(By.className("floatThead-wrapper"));
        List<WebElement> rows = driver.findElements(By.tagName("tbody"));
        int i =0;
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells){
                i++;
                System.out.println("num [" + i + "]" + cell.getText());
            }

        }




    }
}
