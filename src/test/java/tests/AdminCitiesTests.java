package tests;

import Retry.RetryTests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryTests.class)
    public void visitsTheAdminCitiesPageAndListCities() {
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
        navPage.getAdminButton().click();
        navPage.getAdminDropdownCitiesButton().click();

        urlExtend = "/admin/cities";
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
    }

    @Test(priority = 2, retryAnalyzer = RetryTests.class)
    public void checksInputTypesForCreateAndEditNewCity() {
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
        navPage.getAdminButton().click();
        navPage.getAdminDropdownCitiesButton().click();

        urlExtend = "/admin/cities";
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));

        citiesPage.getNewItemButton().click();
        wait
                .withMessage("Dialog field for creating or editing cities did not appear")
                .until(ExpectedConditions.presenceOfElementLocated(citiesPage.getDialogForCreatingOrEditingCities()));
        Assert.assertEquals(citiesPage.getNewItemInputField().getAttribute("type"),
                "text",
                "Attribute should be 'text' but isn't");
    }

    @Test(priority = 3, retryAnalyzer = RetryTests.class)
    public void createNewCity() {
        String email = "admin@admin.com";
        String password = "12345";
        String urlExtend = "/home";
        String city = generatedUsername + "'s City";
        navPage.getNavigationMenuLogin().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));
        navPage.getAdminButton().click();
        navPage.getAdminDropdownCitiesButton().click();

        urlExtend = "/admin/cities";
        wait
                .withMessage("|||Wrong URL, should be" + baseUrl + urlExtend + "but is " + urlPage.getUrl() + "|||")
                .until(ExpectedConditions.urlToBe(baseUrl + urlExtend));

        citiesPage.getNewItemButton().click();
        wait
                .withMessage("Dialog field for creating or editing cities did not appear")
                .until(ExpectedConditions.presenceOfElementLocated(citiesPage.getDialogForCreatingOrEditingCities()));
        citiesPage.getNewItemInputField().sendKeys(city);
        citiesPage.getNewItemSaveButton().click();
        wait
                .withMessage("Message should be displayed but it isn't")
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getSuccessfulAddedCityPopupMsg()));
    }
}
