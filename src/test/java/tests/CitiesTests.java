package tests;

import com.github.javafaker.Faker;
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
        loginPage = new LoginPage(driver, driverWait);
        citiesPage = new CitiesPage(driver, driverWait);
    }
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginOption();
        loginPage.login("admin@admin.com", "12345");
        homePage.adminCities();
    }

    @Test(priority = 1)
    public void adminCityPageTest() {

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/admin/cities"));
        Assert.assertTrue(citiesPage.getLogoutButton().isDisplayed());
        citiesPage.getLogoutButton().click();
    }
    @Test(priority = 2)
    public void createNewCity() {
        String city = faker.address().city();
        citiesPage.createCity(city);

        Assert.assertTrue(citiesPage.getSaveMessage().contains("Saved successfully"));
        citiesPage.getLogoutButton().click();
    }
    @Test(priority = 3)
    public void editCityTest() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        citiesPage.edit(city);

        Assert.assertTrue(citiesPage.getMessage().contains("Saved successfully"));
        citiesPage.getLogoutButton().click();
    }
    @Test(priority = 4)
    public void searchCityTest() {
        String city = faker.address().city();
        String editedCity = city + " - edited";
        citiesPage.createCity(city);
        citiesPage.edit(city);

        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully"));
        citiesPage.search(editedCity);

        Assert.assertTrue(citiesPage.containsSearchString(editedCity));
        citiesPage.getLogoutButton().click();
    }
    @Test(priority = 5)
    public void deleteCityTest() {
        String city = faker.address().city();
        citiesPage.createCity(city);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
        citiesPage.search(city);

        Assert.assertTrue(citiesPage.containsSearchString(city));

        citiesPage.getDeleteButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(citiesPage.getDeleteButton()));
        citiesPage.getMessageDeleteButton().click();
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Deleted successfully"));

        Assert.assertTrue(citiesPage.getPopUpWindow().contains("Deleted successfully"));
    }

}
