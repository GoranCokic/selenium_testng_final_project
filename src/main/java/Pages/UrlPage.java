package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrlPage extends BasicPage {
    public UrlPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
