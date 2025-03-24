import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckBoxPageTest {

    WebDriver driver;
    CheckBoxPage checkBoxPage;


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/checkbox");
        checkBoxPage=new CheckBoxPage(driver);
    }

    @Test
    public void test2(){
        checkBoxPage.Klik1();
    }

    @Test
    public void test3(){
       boolean ind=checkBoxPage.CekiranoSve();
       assertTrue(ind);
    }

    @AfterMethod
    public void posle(){
        driver.quit();
    }


}