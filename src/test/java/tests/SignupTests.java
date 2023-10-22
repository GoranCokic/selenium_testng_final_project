package tests;

import Retry.RetryTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void visitsTheSignupPage() {
        String urlExtend = "/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
    }

    @Test(priority = 2, retryAnalyzer = RetryTests.class)
    public void checksInputTypes() {
        String urlExtend = "/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"), "email",
                "Type field should be 'email' but isn't");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"), "password",
                "Type field should be 'password' but isn't");
        Assert.assertEquals(signupPage.getConfirmPasswordInputField().getAttribute("type"), "password",
                "Type field should be 'password' but isn't");
    }

    @Test(priority = 3, retryAnalyzer = RetryTests.class)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        String urlExtend = "/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        wait
                .withMessage("|||Error wrapper did not appear|||")
                .until(ExpectedConditions.visibilityOfElementLocated(messagePopUpPage.getLoginErrorWrapper()));
        Assert.assertEquals(messagePopUpPage.getErrorMessage(), "E-mail already exists",
                "Error message should be 'E-mail already exists' but isn't");
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
    }

    @Test(priority = 4, retryAnalyzer = RetryTests.class)
    public void signup() {
        String name = generatedUsername;
        String email = name + "@admin.com";
        String password = "123456";
        String confirmPassword = "123456";
        String urlExtend = "/signup";
        navPage.getSignupButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();

        urlExtend = "/home";
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        urlPage.refreshPage();
        messagePopUpPage.getVerifyYourAccountMsg().isDisplayed();
        signupPage.getClosePopupMsgButton().click();
        navPage.getLogoutButton().click();
    }
}
