import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v133.filesystem.model.File;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class digitalUnite {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void fillupform(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-name")).sendKeys("Test name");
        driver.findElement(By.id("edit-number")).sendKeys("01754333333");
        driver.findElement(By.id("edit-date")).sendKeys("02/23/2024");
        driver.findElement(By.id("edit-email")).sendKeys("test@gmail.com");

        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("hello");

        WebElement file = driver.findElement(By.id("edit-uploadocument-upload"));
        file.sendKeys("D:\\SQA Course\\Junit assignment\\JunitAssignment\\src\\test\\resources\\test.pdf");

        List<WebElement>checkbox= driver.findElements(By.tagName("label"));
        checkbox.get(6).isSelected();
        // for(int i= 0; i<2 ; i++){
        checkbox.get(6).click();
        System.out.println(checkbox.get(6).isSelected());
        // }

        WebElement btn = driver.findElement(By.id("edit-submit"));
        Actions action = new Actions(driver);
        action.click(btn).perform();

        //Assertion
        List<WebElement> confirmation = driver.findElements(By.tagName("input"));
        String actualMessage = confirmation.get(12).getText();
        String expectedMessage = "User successfully registered.";
        Assertions.assertTrue(actualMessage.equals(expectedMessage));

    }



}

