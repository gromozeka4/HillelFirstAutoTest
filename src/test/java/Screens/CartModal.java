package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartModal {
    By fromCard = By.xpath("//td[@data-qa-node='card']");
    By amount = By.xpath("//div[@data-qa-node='amount']");
    By commission = By.xpath("//span[@data-qa-node='commission']");
    private static WebDriver driver;

    public CartModal (WebDriver driver){
        this.driver = driver;
    }

    public String getTestCardValue(){
        return driver.findElement(fromCard).getText();
    }

    public String getAmount(){
        return driver.findElement(amount).getText();
    }

    public String getCommission(){
        return driver.findElement(commission).getText();
    }

    public void checkTestCardValue(String testCardValue){
        Assert.assertEquals(testCardValue, getTestCardValue());
    }

    public void checkAmount(String amount){
        Assert.assertEquals(amount, getAmount());
    }

    public void checkCommission(String commission){
        Assert.assertEquals(commission, getCommission());
    }

    public void checkCartScreen(String testCardValue, String amount, String commission){
        checkTestCardValue(testCardValue);
        checkAmount(amount + " UAH");
        checkCommission(commission);
    }
}
