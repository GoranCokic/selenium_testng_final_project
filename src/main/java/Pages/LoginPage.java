package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.xpath("//input[@type='email']"));
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.xpath("//input[@type='password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
}
