package Pages.AmazonPages;

import Pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class AmazonHomePage extends BaseClass {

    By amazonSearchBox = By.cssSelector("input#twotabsearchtextbox");
    By amazonSearchBoxClick = By.cssSelector("input#nav-search-submit-button");
    By amazonSelectSearch = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]");
    By amazonSelectProduct = By.xpath("//p[@class='a-text-left a-size-base'][1]");
    By amazonAddtoCartButton = By.id("add-to-cart-button");
    //By amazonAddtoCartButton = By.cssSelector("input#add-to-cart-button.a-button-input.attach-dss-atc");
    By amazonCartButton = By.cssSelector("a#nav-cart.nav-a.nav-a-2.nav-progressive-attribute");
    String parentWindowHandle;



    public AmazonHomePage (WebDriver driver) {
        super(driver);
    }

    public void amazonSearchItem(){
        driver.get("https://www.amazon.in/");
    }

    public void amazonSelectItem()
    {
        parentWindowHandle = driver.getWindowHandle();
        sendText(amazonSearchBox,"IPhone 12");
        clickElement(amazonSearchBoxClick);
        driverWait();
        clickElement(amazonSelectSearch);
        Set<String> handles = driver.getWindowHandles();
        for(String windowHandle : handles)
        {
            if(!windowHandle.equals(parentWindowHandle))
            {
                driver.switchTo().window(windowHandle);
                clickElement(amazonSelectProduct);
                driverWait();
                clickElement(amazonAddtoCartButton);
            }
        }
    }

    public AmazonCartPage amazonAddtoCartItem(){
        clickElement(amazonCartButton);
        driverWait();
        return new AmazonCartPage(driver);
    }

}
