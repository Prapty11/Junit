import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class guestRegister {
    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void fillup(){
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        driver.findElement(By.id("first_name")).sendKeys("testFirst");
        driver.findElement(By.id("user_email")).sendKeys("prapty@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("notun@pass12");
        driver.findElement(By.id("last_name")).sendKeys("testLast");
        //Gender
        WebElement ratio= driver.findElement(By.id("radio_1665627729_Female"));
        ratio.click();
        //Phone
        List <WebElement> phone = driver.findElements(By.id("phone_1665627880"));
        phone.get(1).sendKeys("012837483903");
        //Emergency phone
        List<WebElement> emphn = driver.findElements(By.id("phone_1665627865"));
        emphn.get(1).sendKeys("017263890808");
        // Nationality
        driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");

        //Country
        Select select = new Select(driver.findElement(By.id("country_1665629257")));
        select.selectByVisibleText("Bangladesh");
        //Length of stay
        driver.findElement(By.id("number_box_1665629930")).sendKeys("3");
        //Room number
        driver.findElement(By.id("input_box_1665630010")).sendKeys("1012");
        // Occupation
        driver.findElement(By.id("textarea_1665630078")).sendKeys("SQA Engineer-It farm");
        Select select1 = new Select(driver.findElement(By.id("select_1665628361")));
        select1.selectByVisibleText("Town Hall");

        //Parking
        WebElement ratio1 = driver.findElement(By.id("radio_1665627931_No"));
        ratio1.click();

        //room preference
        WebElement ratio2 =driver.findElement(By.id("radio_1665627997_Single Room"));
        ratio2.click();

        //dietian
        WebElement ratio3= driver.findElement(By.id("radio_1665628131_Lactose Allergy"));
        ratio3.click();

        //checkbox
        WebElement checkbox =driver.findElement(By.id("privacy_policy_1665633140"));
        checkbox.isSelected();
        // for(int i= 0; i<2 ; i++){
        checkbox.click();
        System.out.println(checkbox.isSelected());
        // }
        List<WebElement> btn = driver.findElements(By.tagName("button"));
        Actions action = new Actions(driver);
        action.click(btn.get(4)).perform();
       //Assertion
        List<WebElement> confirmation = driver.findElements(By.tagName("ul"));
       String actualMessage = confirmation.get(9).getText();
        String expectedMessage = "User successfully registered.";
       Assertions.assertTrue(actualMessage.equals(expectedMessage));

    }
}

