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

    public WebElement getNewOrEditItemInputField() {
        return driver.findElement(By.cssSelector("input#name"));
    }

    public WebElement getNewOrEditItemSaveButton() {
        return driver.findElement(By.cssSelector("button.btnSave "));
    }

    public WebElement getCitySearchInputField() {
        return driver.findElement(By.cssSelector("input#search"));
    }

    public WebElement getEditCityButton() {
        return driver.findElement(By.cssSelector("button#edit"));
    }

    public By getNumberOfCityTableRows() {
        return By.cssSelector("tbody tr");
    }
}
