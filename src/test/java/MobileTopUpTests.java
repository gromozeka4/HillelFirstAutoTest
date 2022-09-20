import Screens.CartModal;
import Screens.MobileTopUpScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MobileTopUpTests {
    private WebDriver driver;
    private MobileTopUpScreen mobileTopUpScreen;
    private CartModal cartModal;
    String ukrPhoneNumber = "672204510";
    String minAmount = "1";
    String maxAmount = "8 000";
    String testDebitCard = "5168742720441819";
    String monthYear = "1224";
    String cvvNumber = "123";
    String fromCardValue = "5168 **** **** 1819";
    String minCommission = "2";
    String maxCommission = "4";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        mobileTopUpScreen = new MobileTopUpScreen(driver);
        cartModal = new CartModal(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mobileTopUpScreen.navigate();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTopUpMinSum() throws InterruptedException {
        mobileTopUpScreen.fillForm(ukrPhoneNumber, minAmount, testDebitCard, monthYear, cvvNumber);
        cartModal.checkCartScreen(fromCardValue, minAmount, minCommission);
    }

    @Test
    public void checkTopUpMaxSum() throws InterruptedException {
        mobileTopUpScreen.fillForm(ukrPhoneNumber, maxAmount, testDebitCard, monthYear, cvvNumber);
        cartModal.checkCartScreen(fromCardValue, maxAmount, maxCommission);
    }
}
