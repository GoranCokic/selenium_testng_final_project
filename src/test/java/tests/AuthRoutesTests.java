package tests;

import Retry.RetryTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        String urlExtendWrong = "/home";
        String urlExtendCorrect = "/login";
        driver.navigate().to(baseUrl + urlExtendWrong);
        wait
                .withMessage("|||Url should be" + baseUrl + urlExtendCorrect + " but is " + baseUrl + urlExtendWrong)
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtendCorrect));
    }

    @Test(priority = 2, retryAnalyzer = RetryTests.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        String urlExtendWrong = "/profile";
        String urlExtendCorrect = "/login";
        driver.navigate().to(baseUrl + urlExtendWrong);
        wait
                .withMessage("|||Url should be" + baseUrl + urlExtendCorrect + " but is " + baseUrl + urlExtendWrong)
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtendCorrect));
    }

    @Test(priority = 3, retryAnalyzer = RetryTests.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        String urlExtendWrong = "/admin/cities";
        String urlExtendCorrect = "/login";
        driver.navigate().to(baseUrl + urlExtendWrong);
        wait
                .withMessage("|||Url should be" + baseUrl + urlExtendCorrect + " but is " + baseUrl + urlExtendWrong)
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtendCorrect));
    }

    @Test(priority = 4, retryAnalyzer = RetryTests.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        String urlExtendWrong = "/admin/users";
        String urlExtendCorrect = "/login";
        driver.navigate().to(baseUrl + urlExtendWrong);
        wait
                .withMessage("|||Url should be" + baseUrl + urlExtendCorrect + " but is " + baseUrl + urlExtendWrong)
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtendCorrect));
    }
}
