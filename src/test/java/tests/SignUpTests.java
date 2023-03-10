package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTests extends BaseTest{
    private SignUpPage signUpPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
    }
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.signUpOption();
    }

    @Test
    public void signUpPageTest() {
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"));
    }
    @Test
    public void inputTypeTest() {
        Assert.assertEquals(signUpPage.getEmailAttribute(), "email");
        Assert.assertEquals(signUpPage.getPasswordAttribute(), "password");
        Assert.assertEquals(signUpPage.getConfirmPasswordAttribute(), "password");
    }
    @Test
    public void alreadySignUpTest() {
        signUpPage.signUp("Test Test", "admin@admin.com", "123654", "123654");

        Assert.assertEquals(signUpPage.getEmailExistsMessage(), "E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"));
    }
    @Test
    public void validDatesSignUp() {
        signUpPage.signUp("Katarina Ljubinkovic", faker.internet().emailAddress(), "12345", "12345");

        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"),
                "IMPORTANT: Verify your account"));
        Assert.assertTrue(homePage.getVerifyMessage().contains("IMPORTANT: Verify your account"));
    }
}
