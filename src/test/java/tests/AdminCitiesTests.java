package tests;

import Retry.RetryTests;
import org.openqa.selenium.Keys;
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
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getNewOrEditCityPopupMsg()));
        Assert.assertEquals(citiesPage.getNewOrEditItemInputField().getAttribute("type"),
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
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getNewOrEditCityPopupMsg()));
        citiesPage.getNewOrEditItemInputField().sendKeys(city);
        citiesPage.getNewOrEditItemSaveButton().click();
        wait
                .withMessage("Message should be displayed but it isn't")
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getSuccessfulAddedOrEditedCityPopupText()));
    }

    @Test(priority = 4, retryAnalyzer = RetryTests.class)
    public void editCity() {
        oldCityName = generatedUsername + "'s City";
        newUsername = fakerHelper.generateUserName();
        newCityName = newUsername + "'s City Edited";

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
        citiesPage.getCitySearchInputField().sendKeys(oldCityName);

        wait
                .withMessage("|||Number of displayed cities should be 1 bit it isn't|||")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getNumberOfCityTableRows(), 1));

        citiesPage.getEditCityButton().click();

        wait
                .withMessage("|||Edit city popup dialog did not appear but it should have|||")
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getNewOrEditCityPopupMsg()));

        //this clears the element because .clear() selenium function isn't working for some reason
        citiesPage.getNewOrEditItemInputField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        citiesPage.getNewOrEditItemInputField().sendKeys(newCityName);
        citiesPage.getNewOrEditItemSaveButton().click();

        wait
                .withMessage("Dialog field for creating or editing cities did not appear")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getSuccessfulEditedCityPopupMsg()));

        //cannot be done with assert because the test fails since the text in the div loads slightly after the popup div wrapper
        wait
                .withMessage("Message should be displayed but it isn't")
                .until(ExpectedConditions.presenceOfElementLocated(messagePopUpPage.getSuccessfulAddedOrEditedCityPopupText()));
    }

    @Test(priority = 5, retryAnalyzer = RetryTests.class)
    public void searchCity() {
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

        citiesPage.getCitySearchInputField().sendKeys(newCityName);

        wait
                .withMessage("|||Number of displayed cities should be 1 bit it isn't|||")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getNumberOfCityTableRows(), 1));

        Assert.assertEquals(citiesPage.getCityNameFromNameColumn().getText(),
                newCityName,
                "The text from the search field does not match the city name from the name column");
    }

    @Test(priority = 6, retryAnalyzer = RetryTests.class)
    public void deleteCity() {
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

        citiesPage.getCitySearchInputField().sendKeys(newCityName);

        wait
                .withMessage("|||Number of displayed cities should be 1 bit it isn't|||")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getNumberOfCityTableRows(), 1));

        Assert.assertEquals(citiesPage.getCityNameFromNameColumn().getText(),
                newCityName,
                "The text from the search field does not match the city name from the name column");

        citiesPage.getDeleteButton().click();

        wait
                .withMessage("|||Delete popup wrapper does not appear but it should|||")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getDeletePopupWrapper()));

        wait
                .withMessage("|||Delete button in the delete popup wrapper does not appear but it should|||")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getDeletePopupDeleteButton()));

        messagePopUpPage.getDeletePopupDeleteButton().click();

        wait
                .withMessage("|||Text ' Deleted successfully ' does not appear in the popup message but it should")
                .until(ExpectedConditions.textToBePresentInElement(messagePopUpPage.getSuccessfulDeletePopupMsg(),
                        "Deleted successfully"));
    }
}
