package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public abstract class BasicTest {
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    protected void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    @BeforeMethod
    protected void beforeMethod() {
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void afterMethod(ITestResult testResult) throws IOException {
        if(testResult.getStatus() == ITestResult.FAILURE) {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy_hh:mm:ss");
            String strDate = dateFormat.format(date);
            String strPath = "Screenshots/screenshot_" + strDate + ".jpg";
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(f, new File(strPath));
        }
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) (driver)).executeScript(String.format("window.localStorage.removeItem('%s');", "cart-contents"));
    }

    @AfterClass
    protected void afterClass() {
        driver.quit();
    }
}
