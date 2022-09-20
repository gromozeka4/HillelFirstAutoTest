package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MobileTopUpScreen {
    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By presetsList = By.xpath("//button[@data-qa-node='amount-hot-spot']");
    By paymentCardField = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By submitButton = By.xpath("//button[@data-qa-node='submit']");
    String mobileTopUpUrl = "https://next.privat24.ua/mobile";

    private static WebDriver driver;

    public MobileTopUpScreen (WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get(mobileTopUpUrl);
    }

    public void fillPhoneNumber(String phoneNumber){
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);

    }

    public void fillAmount(String amount){
        driver.findElement(this.amount).click();

        while(!driver.findElement(this.amount).getAttribute("value").equals("")){
            driver.findElement(this.amount).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(this.amount).sendKeys(amount);
    }

    public void fillPaymentCard(String paymentCard){
        driver.findElement(paymentCardField).sendKeys(paymentCard);
    }

    public void fillExpiredDate(String expiredDate){
        driver.findElement(this.expiredDate).sendKeys(expiredDate);
    }

    public void fillCvv(String cvv){
        driver.findElement(this.cvv).sendKeys(cvv);
    }

    public void submitButtonClick(){
        driver.findElement(submitButton).submit();
    }

    public void fillForm(String phoneNumber, String amount, String card, String monthYear, String cvv) throws InterruptedException {
        fillPhoneNumber(phoneNumber);
        fillAmount(amount);
        fillPaymentCard(card);
        fillExpiredDate(monthYear);
        fillCvv(cvv);
        submitButtonClick();
        Thread.sleep(3000); // Just for visualisation
    }
}
