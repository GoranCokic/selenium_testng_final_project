package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.cssSelector("button.btnNewItem "));
    }

    public By getDialogForCreatingOrEditingCities() {
        return By.cssSelector("div.dlgNewEditItem ");
    }

    public WebElement getNewItemInputField() {
        return driver.findElement(By.cssSelector("input#name"));
    }
}
