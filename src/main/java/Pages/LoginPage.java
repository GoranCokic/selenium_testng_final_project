package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguagesButton() {
        return driver.findElement(By.cssSelector("button.btnLocaleActivation "));
    }

    public WebElement getEnglishLanguageButton() {
        return driver.findElement(By.cssSelector("div.btnEN"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("a.btnLogin"));
    }
}
