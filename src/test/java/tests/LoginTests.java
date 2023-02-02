package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest{
    private LoginPage loginPage;
    private Faker faker;
    private final String EMAIL = "admin@admin.com";
    private final String PASSWORD = "12345";

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginOption();
    }
    @Test
    public void LoginPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void InputTypeTest() {
        Assert.assertEquals(loginPage.emailAttribute(), "email");
        Assert.assertEquals(loginPage.passwordAttribute(), "password");
    }
    @Test
    public void InvalidDatesLoginTest() {
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());

        Assert.assertEquals(loginPage.getWrongDatesMessage(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login") );
    }
    @Test
    public void InvalidPasswordLoginTest() {
        loginPage.login(EMAIL, faker.internet().password());

        Assert.assertEquals(loginPage.getWrongPasswordMessage(), "Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void ValidDatesLoginTest() {
        loginPage.login(EMAIL, PASSWORD);

        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[2]/div[1]/a"),
                        "Buy me a coffee"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }
    @Test
    public void LogoutTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());

        loginPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
