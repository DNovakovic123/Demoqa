import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class SliderBageTest {

    WebDriver driver;
   SliderPage sliderPage;
    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethods(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/slider");
        sliderPage=new SliderPage(driver);
    }


    @Parameters("sliderVrednost")
    @Test
    public void test14( int sliderVrednost) {


        sliderPage.setSliderVrednost(sliderVrednost);


        int actualSliderVrendost = sliderPage.getSliderVrednost();
        assertEquals(actualSliderVrendost, sliderVrednost);

        int displayedVrednost = sliderPage.getDisplayedVrednost();
        assertEquals(displayedVrednost, sliderVrednost);


    }

    @AfterMethod
    public void posle(){
        driver.quit();
    }

}