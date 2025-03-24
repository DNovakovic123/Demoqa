import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected WebElement scrollElement(WebElement element,WebDriver driver){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",element);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        return  wait.until(ExpectedConditions.visibilityOf(element));

    }


}
