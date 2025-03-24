import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WebTablesPageTest {


    WebDriver driver;
    WebTablesPage webTablesPage;


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/webtables");
        webTablesPage=new WebTablesPage(driver);
    }

    @Test
    public void test7(){
       boolean flag= webTablesPage.Pretraga();
       assertTrue(flag);
    }

    @Test
    public void test8(){
       webTablesPage.Add();
       String boja=webTablesPage.Boja();
       assertEquals(boja,"rgb(206, 208, 214)");
    }

    @Test
    public void test9(){
        webTablesPage.Ispravno();

        boolean flag1= webTablesPage.Add1();
        assertTrue(flag1);
    }

    @Test
    public void test10(){


        boolean flag2= webTablesPage.Delete();
        assertTrue(flag2);
    }

    @AfterMethod
    public  void posele(){
        driver.quit();
    }
}