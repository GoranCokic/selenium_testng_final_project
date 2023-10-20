package tests;

import Retry.RetryTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void visitsTheSignupPage(){
        String urlExtend="/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
    }

    @Test(priority = 2, retryAnalyzer = RetryTests.class)
    public void checksInputTypes(){
        String urlExtend="/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"),"email",
                "Type field should be 'email' but isn't");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"),"password",
                "Type field should be 'password' but isn't");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"),"password",
                "Type field should be 'password' but isn't");
    }
}
