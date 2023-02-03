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

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement popUpWindow;

    @FindBy(className = "btnAdmin")
    private WebElement admin;

    @FindBy(className = "btnAdminCities")
    private WebElement cities;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void loginOption() {
        loginField.click();
    }
    public void signUpOption() {
        signUpField.click();
    }
    public String getPopUpMessage() {
        return popUpWindow.getText();
    }
    public WebElement getAdmin() {
        return admin;
    }

    public WebElement getCities() {
        return cities;
    }
}
