import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkPageTest {


    WebDriver driver;
    LinkPage linkPage;


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/links");
        linkPage=new LinkPage(driver);
    }

    @Test
    public void test6(){
        String link= linkPage.LinkKlik();
        assertEquals(link,"Link has responded with staus 400 and status text Bad Request");
    }

    @AfterMethod
    public  void posele(){
        driver.quit();
    }
}