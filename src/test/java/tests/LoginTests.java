package tests;

import Retry.RetryTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void visitsTheLoginPage() {
        loginPage.getLanguagesButton().click();
        loginPage.getEnglishLanguageButton().click();
        loginPage.getLoginButton().click();
        String urlExtend = "/login";
        Assert.assertEquals(loginPage.getUrl(), baseUrl + urlExtend,
                "url should be ||| " + baseUrl + urlExtend + " ||| but is " + loginPage.getUrl());
    }
}

