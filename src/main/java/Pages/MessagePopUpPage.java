package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public By getLoginErrorWrapper() {
        return By.cssSelector("div.error");
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("div.error li")).getText();
    }

    public WebElement getVerifyYourAccountMsg() {
        return driver.findElement(By.xpath("//div[text()=' IMPORTANT: Verify your account ']"));
    }

    public By getSuccessfulAddedOrEditedCityPopupText() {
        return By.xpath("//div[text()=' Saved successfully ']");
    }

    public By getNewOrEditCityPopupMsg() {
        return By.cssSelector("div.dlgNewEditItem ");
    }

    public WebElement getSuccessfulEditedCityPopupMsg() {
        return driver.findElement(By.cssSelector("div.success"));
    }

    public WebElement getDeletePopupWrapper() {
        return driver.findElement(By.cssSelector("div.v-dialog__content--active > div >div"));
    }

    public WebElement getDeletePopupDeleteButton() {
        return driver.findElement(By.cssSelector("button.red--text"));
    }

    public WebElement getSuccessfulDeletePopupMsg() {
        return driver.findElement(By.cssSelector("div.success > div.v-snack__content"));
    }
}
