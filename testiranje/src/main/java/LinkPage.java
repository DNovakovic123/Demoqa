import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkPage extends  BasePage{
    @FindBy(partialLinkText = "Bad")
    WebElement link;

    @FindBy(xpath = "//p[@id=\"linkResponse\"]")
    WebElement odgovor;
    public LinkPage(WebDriver driver) {
        super(driver);
    }

    public String LinkKlik(){
        scrollElement(link,driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement el=wait.until(ExpectedConditions.visibilityOf(link));
        el.click();


        WebElement el1=wait.until(ExpectedConditions.visibilityOf(odgovor));

        return  el1.getText();

    }

}
