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

    @Test(priority = 2, retryAnalyzer =  RetryTests.class)
    public void checksInputTypes(){
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"),"email",
                "Type attribute does not equal 'email' but it should");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"),"password",
                "Type attribute does not equal 'password' but it should");
    }
}

