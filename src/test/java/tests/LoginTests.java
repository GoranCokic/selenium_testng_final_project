package tests;

import Retry.RetryTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void visitsTheLoginPage() {
        navPage.getLanguagesButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getNavigationMenuLogin().click();
        String urlExtend = "/login";
        Assert.assertEquals(urlPage.getUrl(), baseUrl + urlExtend,
                "url should be ||| " + baseUrl + urlExtend + " ||| but is " + urlPage.getUrl());
    }

    @Test(priority = 2, retryAnalyzer = RetryTests.class)
    public void checksInputTypes() {
        navPage.getNavigationMenuLogin().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), "email",
                "Type attribute does not equal 'email' but it should");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), "password",
                "Type attribute does not equal 'password' but it should");
    }

    @Test(priority = 3, retryAnalyzer = RetryTests.class)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        String urlExtend = "/login";
        navPage.getNavigationMenuLogin().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        wait
                .withMessage("|||Login wrapper did not appear|||")
                .until(ExpectedConditions.visibilityOfElementLocated(messagePopUpPage.getLoginErrorWrapper()));
        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "User does not exists",
                "Error message should be 'User does not exists' but isn't");
        Assert.assertEquals(urlPage.getUrl(), baseUrl + urlExtend,
                "url should be ||| " + baseUrl + urlExtend + " ||| but is " + urlPage.getUrl());
    }

    @Test(priority = 4, retryAnalyzer = RetryTests.class)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        String urlExtend = "/login";
        navPage.getNavigationMenuLogin().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        wait
                .withMessage("|||Login wrapper did not appear|||")
                .until(ExpectedConditions.visibilityOfElementLocated(messagePopUpPage.getLoginErrorWrapper()));
        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "Wrong password",
                "Error message should be 'User does not exists' but isn't");
        Assert.assertEquals(urlPage.getUrl(), baseUrl + urlExtend,
                "url should be ||| " + baseUrl + urlExtend + " ||| but is " + urlPage.getUrl());
    }

    @Test(priority = 5, retryAnalyzer = RetryTests.class)
    public void login() {
        String email = "admin@admin.com";
        String password = "12345";
        String urlExtend = "/home";
        navPage.getNavigationMenuLogin().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
    }

    @Test(priority = 6, retryAnalyzer = RetryTests.class)
    public void logout() {
        String email = "admin@admin.com";
        String password = "12345";
        String urlExtend = "/home";
        navPage.getNavigationMenuLogin().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        navPage.getLogoutButton().isDisplayed();
        navPage.getLogoutButton().click();
    }
}

