package TestPages;

import Pages.FlipkartPages.FlipkartCartPage;
import Pages.FlipkartPages.FlipkartHomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript1 extends TestBaseClass {

    FlipkartHomePage flipkartHomePage;
    FlipkartCartPage flipkartCartPage;

    @BeforeMethod
    public void initObject(){
        flipkartHomePage = new FlipkartHomePage(getDriver());
        flipkartCartPage = new FlipkartCartPage(getDriver());
    }

    @Test
    public void selectItemTest(){
        flipkartHomePage.selectItem();
        flipkartHomePage.fgetItemAmount();
        flipkartHomePage.addtoCartItem();
        flipkartCartPage.cartPage();
    }

}
