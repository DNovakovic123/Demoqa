import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage extends  BasePage{


    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    WebElement home;


    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[3]")
    WebElement doucments;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")
    WebElement doucments1;


    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }


    public void Klik1(){
        home.click();
        scrollElement(doucments,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(doucments));
        element.click();
    }

    public boolean CekiranoSve(){
        home.click();
        scrollElement(doucments,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(doucments));
        element.click();
        doucments1.click();
        boolean ind=false;
        List<WebElement >elementi=driver.findElements(By.tagName("li"));
        for (WebElement element1 :elementi){
            if(element1.isSelected())
                ind=true;
            else
                ind=false;
            }
        return  ind;
    }
}
