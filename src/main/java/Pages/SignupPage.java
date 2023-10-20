package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.cssSelector("#email"));
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.cssSelector("#password"));
    }

    public WebElement getConfirmPasswordInputField() {
        return driver.findElement(By.cssSelector("#confirmPassword"));
    }
}