package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CitiesPage;
import pages.LoginPage;

public class CitiesTests extends BaseTest{
    private LoginPage loginPage;
    private CitiesPage citiesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver);
        citiesPage = new CitiesPage(driver);
    }
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginOption();
        loginPage.login("admin@admin.com", "12345");
        homePage.adminCities();
    }

    @Test
    public void adminCityPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.getLogoutButton().click();
    }
    @Test
    public void createNewCity() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        Assert.assertTrue(citiesPage.getMessage().contains("Saved successfully"));
        homePage.getLogoutButton().click();
    }
    @Test
    public void editCityTest() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully"));
        citiesPage.search(city);
        citiesPage.edit();
        Assert.assertTrue(citiesPage.getMessage().contains("Saved successfully"));
        homePage.getLogoutButton().click();
    }
    @Test
    public void searchCityTest() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully"));
        citiesPage.search(city);
        citiesPage.edit();
        String editedCity = city + " - edited";
        Assert.assertTrue(citiesPage.containsSearchString(editedCity));
        homePage.getLogoutButton().click();
    }
    @Test
    public void deleteCityTest() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully"));
        citiesPage.search(city);
        explicitWait.until(ExpectedConditions.numberOfElementsToBe((By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")), 1));
        Assert.assertTrue(citiesPage.containsSearchString(city));
        citiesPage.delete(city);
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Deleted successfully"));

        Assert.assertTrue(citiesPage.getMessage().contains("Deleted successfully"));
        homePage.getLogoutButton().click();
    }

}
