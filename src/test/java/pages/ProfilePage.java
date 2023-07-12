package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitter;

    @FindBy(id = "urlGitHub")
    private WebElement gitHub;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement alertMessage;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void extracted(WebElement element) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public void editProfile(String name, String phone, String city, String country, String twitter, String gitHub) throws InterruptedException {
        extracted(this.name);
        this.name.sendKeys(name);
        extracted(this.phone);
        this.phone.sendKeys(phone);
        extracted(this.city);
        this.city.sendKeys(city);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);
        extracted(this.country);
        this.country.sendKeys(country);
        extracted(this.twitter);
        this.twitter.sendKeys(twitter);
        extracted(this.gitHub);
        this.gitHub.sendKeys(gitHub);
        saveButton.click();
    }
    public String getAlertMessage() {
        return alertMessage.getText();
    }
    public String getNameAttribute() {
        return name.getAttribute("value");
    }
    public String getPhoneAttribute() {
        return phone.getAttribute("value");
    }
    public String getCityAttribute() {
        return city.getAttribute("value");
    }
    public String getCountryAttribute() {
        return country.getAttribute("value");
    }
    public String getTwitterAttribute() {
        return twitter.getAttribute("value");
    }
    public String getGitHubAttribute() {
        return gitHub.getAttribute("value");
    }
}

