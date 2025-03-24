import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends  BasePage{


    public SliderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@type='range']")
    WebElement  slider;
    @FindBy(xpath = "//input[@id=\"sliderValue\"]")
    WebElement  sliderVrednostDisplay;

    public void setSliderVrednost(int value) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'))", slider, value);
    }


    public int getSliderVrednost() {
        return Integer.parseInt(slider.getAttribute("value"));
    }


    public int getDisplayedVrednost() {
        return Integer.parseInt(sliderVrednostDisplay.getAttribute("value"));
    }

}
