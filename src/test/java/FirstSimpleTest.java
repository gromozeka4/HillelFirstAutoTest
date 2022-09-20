import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstSimpleTest {
    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By presetsList = By.xpath("//button[@data-qa-node='amount-hot-spot']");
    By paymentCardField = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By submitButton = By.xpath("//button[@data-qa-node='submit']");

    By fromCard = By.xpath("//td[@data-qa-node='card']");

    String ukrPhoneNumber = "672204510";
    String minAmount = "1";
    String maxAmount = "9999";
    String testDebitCard = "5168742720441819";
    String monthYear = "1224";
    String cvvNumber = "123";

    String fromCardValue = "5168 **** **** 1819";

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/mobile");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTopUpMinSum() throws InterruptedException {
        driver.findElement(phoneNumber).sendKeys(ukrPhoneNumber);
        driver.findElement(amount).click();

        while(!driver.findElement(amount).getAttribute("value").equals("")){
            driver.findElement(amount).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(amount).sendKeys(minAmount);

        driver.findElement(paymentCardField).sendKeys(testDebitCard);
        driver.findElement(expiredDate).sendKeys(monthYear);
        driver.findElement(cvv).sendKeys(cvvNumber);
        driver.findElement(submitButton).submit();

        Thread.sleep(3000);
        Assert.assertEquals(fromCardValue, driver.findElement(fromCard).getText());
    }
}
