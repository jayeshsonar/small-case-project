package Pages.FlipkartPages;

import Pages.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class FlipkartHomePage extends BaseClass {

    By searchBox = By.cssSelector("input._3704LK");
    By serachBoxClick = By.xpath("//button[@type='submit']");
    By selectSearch = By.xpath("//div[@class='_4rR01T'][1]");
    By priceofItem = By.cssSelector("div._30jeq3._16Jk6d");
    By popupWindow = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    By productNameText = By.cssSelector("span.B_NuCI");
    By addtoCartButton = By.cssSelector("button[class*='_3v1-ww']");
    String parentWindowHandle;
    public String flipkartProductPrice;
    public Integer fProductPrice;
    
    public FlipkartHomePage(WebDriver driver) {
        super(driver);
    }

    public void selectItem()
    {
        parentWindowHandle = driver.getWindowHandle();
        waitForPresentofElement(popupWindow);
        clickElement(popupWindow);
        sendText(searchBox,"iphone 12");
        clickElement(serachBoxClick);
        driverWait();
        clickElement(selectSearch);
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle : handles)
        {
            if(!windowHandle.equals(parentWindowHandle))
            {
                driver.switchTo().window(windowHandle);
                flipkartProductPrice = getText(priceofItem).replaceFirst("₹","");
                System.out.println("The Price of the selected Item is : " +flipkartProductPrice);
                System.out.println("The Name of the Product is : " +getText(productNameText));
                }
        }
    }

    public Integer fgetItemAmount(){
        try {
            fProductPrice = Integer.parseInt(flipkartProductPrice);
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }
        return fProductPrice;
    }

    public FlipkartCartPage addtoCartItem(){
        clickElement(addtoCartButton);
        return new FlipkartCartPage(driver);
    }


}
