package Pages.AmazonPages;

import Pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage extends BaseClass {

    By amazonPriceofItem = By.cssSelector("span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap span");
    public String amazonProductPrice;
    public Integer aProductPrice;

    public AmazonCartPage(WebDriver driver) {
        super(driver);
    }

    public void amazonCartPage(){
        waitForElement(amazonPriceofItem);
        amazonProductPrice = getText(amazonPriceofItem).replaceFirst("₹","");;
        System.out.println("Total Amount of the Item is : " + amazonPriceofItem);
    }

    public Integer agetItemAmount(){
        try {
            aProductPrice = Integer.parseInt(amazonProductPrice);
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }
        return aProductPrice;
    }

}
