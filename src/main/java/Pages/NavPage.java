package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguagesButton() {
        return driver.findElement(By.cssSelector("button.btnLocaleActivation "));
    }

    public WebElement getEnglishLanguageButton() {
        return driver.findElement(By.cssSelector("div.btnEN"));
    }

    public WebElement getNavigationMenuLogin() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items :nth-child(3)"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector("button.btnLogout "));
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("div.v-toolbar__items :nth-child(4)"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.cssSelector("button.btnAdmin"));
    }

    public WebElement getAdminDropdownCitiesButton() {
        return driver.findElement(By.cssSelector("a.btnAdminCities"));
    }
}
