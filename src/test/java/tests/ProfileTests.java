package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.SignUpPage;

public class ProfileTests extends BaseTest {
    private SignUpPage signUpPage;
    private ProfilePage profilePage;
    private Faker faker;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        faker = new Faker();

    }
    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.signUpOption();
        signUpPage.signUp("Katarina Ljubinkovic", faker.internet().emailAddress(), "12456", "12456");
    }
    @Test
    public void editProfileTest() throws InterruptedException{
        homePage.getMyProfile().click();
        String name = faker.name().firstName();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String city = "New York";
        String country = faker.country().name();
        String twitterAccount = "https://www." + name.toLowerCase() + ".com";
        String gitHubAccount = "https://github.com/" + name.
                toLowerCase();
        profilePage.editProfile(name, phoneNumber, city, country, twitterAccount, gitHubAccount);

        Assert.assertTrue(profilePage.getAlertMessage().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getNameAttribute(), name);
        Assert.assertEquals(profilePage.getPhoneAttribute(), phoneNumber);
        Assert.assertEquals(profilePage.getCityAttribute(), city);
        Assert.assertEquals(profilePage.getCountryAttribute(), country);
        Assert.assertEquals(profilePage.getTwitterAttribute(), twitterAccount);
        Assert.assertEquals(profilePage.getGitHubAttribute(), gitHubAccount);
    }
}
