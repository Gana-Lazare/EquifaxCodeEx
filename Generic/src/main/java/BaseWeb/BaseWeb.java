package BaseWeb;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseWeb {
    public static WebDriver driver;

    //MEthod to get driver without extending the base class in StepDefinitions Class
    public WebDriver getdriver() {
        return driver;
    }



    public WebDriver Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

    //Method use Select by visible text in drop down
    public void clickOnSelectDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void ExplicitelyWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void moveToAnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    // capture screeen shot when test is fail
    // a listner Class is user user TestNGLIstner
    // where when test fail is Overriden
    public void captureScreenShot(WebDriver driver,String screenshotName , ITestResult result) throws IOException {
        DateFormat df = new SimpleDateFormat("(yyMMddHHmmssZ)");
        //DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
if (result.getStatus()==ITestResult.FAILURE) {
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File dest = new File(System.getProperty("user.dir") + "/Capture/" + screenshotName + " " + df.format(date) + ".png");

    FileHandler.copy(src,dest);
}
    }


}
