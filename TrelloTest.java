import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TrelloTest{
//    private String baseUrl;
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //        baseUrl = "https://trello.com/login/";
        driver = new FirefoxDriver();
//    WebDriver driver = new InternetExplorerDriver();
        driver.get("https://trello.com/login/");
        driver.manage().timeouts().implicitlyWait(101, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDrop() throws Exception {
    driver.findElement(By.id("user")).sendKeys("elenaelena@mail.ru");
    driver.findElement(By.id("password")).sendKeys("elenaelena");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.xpath(".//span[@class=\"board-tile-details-name\" and @title=\"Wellcome board\"]")).click();
    WebElement source = driver.findElement(By.xpath(".//a[text()=\"Second card\" and @class=\"list-card-title js-card-name\"]"));
    WebElement target = driver.findElement(By.xpath("//textarea[contains(text(),'Advanced')]"));
    Actions actions = new Actions(driver);
    actions.dragAndDrop(source,target).perform();
    source = driver.findElement(By.xpath(".//a[text()=\"Second card\" and @class=\"list-card-title js-card-name\"]"));
    target = driver.findElement(By.xpath("//textarea[contains(text(),'Basics')]"));
    actions.dragAndDrop(source,target).perform();
   }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.findElement(By.cssSelector(".member-initials")).click();
        driver.findElement(By.linkText("Log Out")).click();
        driver.quit();
    }
};
