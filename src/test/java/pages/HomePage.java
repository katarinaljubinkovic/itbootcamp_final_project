package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement signUpField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyMessage;

    @FindBy(className = "btnAdmin")
    private WebElement admin;

    @FindBy(className = "btnAdminCities")
    private WebElement cities;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(className = "btnES")
    private WebElement localeES;

    @FindBy(className = "btnEN")
    private WebElement localeEN;

    @FindBy(className = "btnFR")
    private WebElement localeFR;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement titleES;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]")
    private WebElement titleEN;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]")
    private WebElement titleFR;

    @FindBy(className = "btnProfile")
    private WebElement myProfile;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void loginOption() {
        loginField.click();
    }
    public void signUpOption() {
        signUpField.click();
    }
    public String getVerifyMessage() {
        return verifyMessage.getText();
    }
    public void adminCities() {
        admin.click();
        cities.click();
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public void chooseLanguage(Language language) {
        languageButton.click();
        switch (language) {
            case EN:
                localeEN.click(); break;
            case ES:
                localeES.click(); break;
            case FR:
                localeFR.click(); break;
        }
    }
    public String getTitleES() {
        return titleES.getText();
    }
    public String getTitleEN() {
        return titleEN.getText();
    }
    public String getTitleFR() {
        return titleFR.getText();
    }
    public WebElement getMyProfile() {
        return myProfile;
    }

}
