import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTablesPage extends BasePage{
    @FindBy(id = "searchBox")
    private WebElement search;

    @FindBy(css = ".rt-tbody .rt-tr-group")
    private List<WebElement> elementi;

    @FindBy(id = "addNewRecordButton")
    private WebElement add;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "salary")
    private WebElement salary;

    @FindBy(id = "department")
    private WebElement department;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id="delete-record-3")
    private WebElement delete;

    @FindBy(xpath = "//table[@class='rt-table']/div/div/div/div/table/tbody/tr")
    List<WebElement> rowsBeforeDelete;

    @FindBy(xpath = "//table[@class='rt-table']/div/div/div/div/table/tbody/tr")
    List<WebElement> rowsAfterDelete;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public boolean Pretraga() {

        search.sendKeys("200");

        // Sačekaj da se filtrirani rezultati učitaju
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".rt-tbody .rt-tr-group"), 0));

        int br=0;
        for (WebElement row : elementi) {
            scrollElement(row, driver); // Skroluj da se osigura vidljivost
            String rowText = row.getText();

            if (rowText.contains("Alden")) {
                br++;
            }
            if (rowText.contains("Kierra")) {
                br++;
            }
        }

       if(br==2)
           return  true;
       else
           return  false;
    }

public void Add(){
  add.click();
  firstName.sendKeys("Srdjan");
  lastName.sendKeys("Todorovic");
  userEmail.sendKeys("srdjan@pmf.kg.ac.rs");
  age.sendKeys("23");
  salary.sendKeys("-1");
  department.sendKeys("Informatika");
  submit.click();
}


    public void Ispravno(){
        add.click();
        firstName.sendKeys("Srdjan");
        lastName.sendKeys("Todorovic");
        userEmail.sendKeys("srdjan@pmf.kg.ac.rs");
        age.sendKeys("23");
        salary.sendKeys("25000");
        department.sendKeys("Informatika");
        submit.click();
    }

    public boolean Add1() {
        boolean ind = false;

        for (WebElement row : elementi) {
            scrollElement(row, driver);  // Skroluj do elementa kako bi bio vidljiv
            if (row.getText().contains("Todorovic") || row.getText().contains("25000")) {
                ind = true;
                break;
            }
        }

        return ind;
    }

public String Boja(){
        return  salary.getCssValue("border-color");
}

    public boolean Delete() {
        boolean ind = false;

        scrollElement(delete, driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(delete));
        deleteButton.click();

        int originalRowCount = rowsBeforeDelete.size();


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tr[last()]")));

        int newRowCount = rowsAfterDelete.size();


        if (newRowCount != (originalRowCount - 1)) {
            ind = true;
        }

        return ind;
    }
}
