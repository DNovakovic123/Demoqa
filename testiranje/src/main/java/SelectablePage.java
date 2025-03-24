import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SelectablePage extends  BasePage{

    @FindBy(xpath = "//*[@id=\"listContainer\"]/h1")
    private WebElement naslov;

    @FindBy(tagName = "title")
    private WebElement title1;

    @FindBy(id = "demo-tab-grid")
    private WebElement grid;

    @FindBy(xpath = "//*[@id=\"row1\"]/li[3]")
    private WebElement tri;

    @FindBy(xpath = "//*[@id=\"row2\"]/li[2]")
    private WebElement pet;


    @FindBy(xpath = "//*[@id=\"row3\"]/li[1]")
    private WebElement sedam;
    public SelectablePage(WebDriver driver) {
        super(driver);
    }


    public String Provera1(){
        return  naslov.getText();
    }

    public String Provera2(){
        return  title1.getText();
    }

    public void Grid(){

        grid.click();
        scrollElement(tri,driver);
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement el1=wait.until(ExpectedConditions.visibilityOf(tri));
        el1.click();

        scrollElement(pet,driver);
        WebElement el2=wait.until(ExpectedConditions.visibilityOf(pet));
        el2.click();

        scrollElement(sedam,driver);
        WebElement el3=wait.until(ExpectedConditions.visibilityOf(sedam));
        el3.click();

    }

    public String Boja1()
    {
        return tri.getCssValue("background-color");

    }

    public String Boja2()
    {
        return pet.getCssValue("background-color");

    }

    public String Boja3()
    {
        return sedam.getCssValue("background-color");

    }
}
