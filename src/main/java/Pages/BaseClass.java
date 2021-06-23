package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        }

    public void waitForPresentofElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public void sendText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void driverWait() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


}
