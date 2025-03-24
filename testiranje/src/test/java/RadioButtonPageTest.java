import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RadioButtonPageTest {

    WebDriver driver;
    RadioButtonPage radioButtonPage;


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");
        radioButtonPage=new RadioButtonPage(driver);
    }



    @Test
    public void test4(){
        radioButtonPage.Klikni();

        String boja= radioButtonPage.Recenica();

        assertEquals(boja,"You have selected Impressive");

    }

    @Test
    public void test5(){
        radioButtonPage.Klikni();

        String boja= radioButtonPage.Boja();

       assertEquals(boja,"rgba(40, 167, 69, 1)");

    }


    @AfterMethod
    public void posle(){
        driver.quit();
    }
}