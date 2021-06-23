package TestPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBaseClass {

    private WebDriver driver;

    public WebDriver getDriver(){
        this.driver = driver;
        return driver;
    }

    @BeforeClass
    public void initializeDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getProperties().getProperty("flipkart_URL"));
    }

    @BeforeSuite
    public Properties getProperties() throws IOException{
        File file = new File(System.getProperty("user.dir")+"/src/test/java/utilities/configuration.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fis);
        return properties;
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
