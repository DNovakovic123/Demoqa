import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectablePageTest {

    WebDriver driver;
    SelectablePage selectablePage;
    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/selectable");
        selectablePage=new SelectablePage(driver);
    }



    @Test
    public void test11(){

        String naslov=selectablePage.Provera1();
        assertEquals(naslov,"Selectable");

    }

    @Test
    public void test12(){

        String tit=selectablePage.Provera2();
        assertEquals(tit,"Selectable");

    }

    @Test
    public void test13(){

      selectablePage.Grid();

      String s1=selectablePage.Boja1();
      String s2=selectablePage.Boja2();
      String s3=selectablePage.Boja3();

      assertEquals(s1,"rgba(0, 123, 255, 1)");
      assertEquals(s2,"rgba(0, 123, 255, 1)");
      assertEquals(s3,"rgba(0, 123, 255, 1)");

    }

    @AfterMethod
    public void posle(){
        driver.quit();
    }


}