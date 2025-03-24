import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage extends BasePage{


    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private  WebElement currentAddress;

    @FindBy(xpath="//textarea[@id='permanentAddress']")
    private  WebElement permanentAddress;

    @FindBy(id="submit")
    private  WebElement submit;

    @FindBy(xpath ="//p[@id='name']")
    private WebElement name;

    @FindBy(xpath ="//p[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private  WebElement currentAddress1;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    private  WebElement permanentAddress1;

    public void setName(String name){
        userName.sendKeys(name);
    }

    public void setEmail(String email){
        userEmail.sendKeys(email);
    }

    public void setCurrentAddress(String current){

        scrollElement(currentAddress,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(currentAddress));

        element.sendKeys(current);
    }

    public void setPermanentAddress(String permanent){

        scrollElement(permanentAddress,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(permanentAddress));
        element.sendKeys(permanent);

    }

    public void Submit(){

        scrollElement(submit,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(submit));
        element.click();
    }


    public String getName(){
        scrollElement(name,driver);


        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(name));
        return  element.getText();
    }

    public String getEmail(){
        scrollElement(email,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(email));
        return  element.getText();
    }

    public String getCurrent(){
        scrollElement(currentAddress1,driver);
        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(currentAddress1));

        return  element.getText();
    }

    public String getPermanent(){
        scrollElement(permanentAddress1,driver);

        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element=driverWait.until(ExpectedConditions.visibilityOf(permanentAddress1));

        return  element.getText();
    }
}
