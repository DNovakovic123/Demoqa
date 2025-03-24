import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonPage extends  BasePage{


    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement radio;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p")
    private WebElement recenica;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/p/span")
    private WebElement rec;
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void Klikni(){
        radio.click();
    }


    public String Recenica( ){
        scrollElement(recenica,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement recenica1=driverWait.until(ExpectedConditions.visibilityOf(recenica));
        return  recenica1.getText();

    }

    public String Boja( ){
        scrollElement(rec,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement rec1=driverWait.until(ExpectedConditions.visibilityOf(rec));
        return  rec1.getCssValue("color");

    }



}
