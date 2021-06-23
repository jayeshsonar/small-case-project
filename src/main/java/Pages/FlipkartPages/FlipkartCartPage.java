package Pages.FlipkartPages;

import Pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartCartPage extends BaseClass {

    By placeOrderButton = By.cssSelector("button._2KpZ6l._2ObVJD._3AWRsL");
    By increaseItemCount = By.xpath("//button[@class='_23FHuj'][2]");
    By totalAmount = By.cssSelector("div.Ob17DV._3X7Jj1 span");
    String totalAmountofItem;

    public FlipkartCartPage(WebDriver driver) {
        super(driver);
    }

    public void cartPage(){
            waitForElement(placeOrderButton);
            clickElement(increaseItemCount);
            driver.navigate().refresh();
            totalAmountofItem = getText(totalAmount);
            System.out.println("Total Amount of the Item is : " +totalAmountofItem);
    }

}
