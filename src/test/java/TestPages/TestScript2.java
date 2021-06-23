package TestPages;

import Pages.AmazonPages.AmazonCartPage;
import Pages.AmazonPages.AmazonHomePage;
import Pages.FlipkartPages.FlipkartHomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript2 extends TestBaseClass {

    AmazonHomePage amazonHomePage;
    AmazonCartPage amazonCartPage;
    FlipkartHomePage flipkartHomePage;

    @BeforeMethod
    public void initObject(){
        amazonHomePage = new AmazonHomePage(getDriver());
        amazonCartPage = new AmazonCartPage(getDriver());
        flipkartHomePage = new FlipkartHomePage(getDriver());
    }

    @Test
    public void amazonSelectItemTest(){
        amazonHomePage.amazonSearchItem();
        amazonHomePage.amazonSelectItem();
        amazonHomePage.amazonAddtoCartItem();
        amazonCartPage.amazonCartPage();
        amazonCartPage.agetItemAmount();

        if(flipkartHomePage.fgetItemAmount()<amazonCartPage.agetItemAmount()){
            System.out.println("The Item Iphone 12 is cheaper on Flipkart and has the price : " +flipkartHomePage.fProductPrice);
        }
        else
        System.out.println("The Item Iphone 12 is cheaper on Amazon and has the price : " +amazonCartPage.amazonProductPrice);
    }

}
