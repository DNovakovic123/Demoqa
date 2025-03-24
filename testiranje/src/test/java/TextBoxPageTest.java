import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextBoxPageTest {


    WebDriver driver;
    TextBoxPage textBoxPage;


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        textBoxPage=new TextBoxPage(driver);
    }

    @Test
    public void test1(){

        textBoxPage.setName("Srdjan");
        textBoxPage.setEmail("srdjan@imi.pmf.kg.ac.rs");
        textBoxPage.setCurrentAddress("Radoja Domanovica 12");
        textBoxPage.setPermanentAddress("Radoja Domanovica 12, Kragujevac");
        textBoxPage.Submit();
        assertEquals(textBoxPage.getName(),"Name:Srdjan");
        assertEquals(textBoxPage.getEmail(),"Email:srdjan@imi.pmf.kg.ac.rs");
        assertEquals(textBoxPage.getCurrent(),"Current Address :Radoja Domanovica 12");
        assertEquals(textBoxPage.getPermanent(),"Permananet Address :Radoja Domanovica 12, Kragujevac");
    }

    @AfterMethod
    public void posle(){
        driver.quit();
    }

}