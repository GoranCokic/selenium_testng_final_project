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

    public WebElement getNavigationMenuLogin() {
        return driver.findElement(By.cssSelector("a.btnLogin"));
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.xpath("//input[@type='email']"));
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.xpath("//input[@type='password']"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public By getLoginErrorWrapper(){
        return By.cssSelector("div.error");
    }
    public String getErrorMessage(){
        return driver.findElement(By.cssSelector("div.error li")).getText();
    }
}
