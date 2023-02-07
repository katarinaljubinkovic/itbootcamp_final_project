package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;

public class CitiesPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItem;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement saveMessage;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div/i")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editButton;

    @FindBy(id = "name")
    private WebElement editNameField;

    @FindBy(className = "btnSave")
    private WebElement save;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;

    @FindAll({@FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")})
    private List<WebElement> cityList;

    @FindBy(className = "v-dialog")
    private WebElement deleteWindow;

    @FindBy (css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement messageDeleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement popUpWindow;

    public CitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public void createCity(String city) {
        newItem.click();
        this.name.sendKeys(city);
        saveButton.click();
    }
    public String getSaveMessage(){
        return saveMessage.getText();
    }
    public void search(String city) {
        searchField.clear();
        searchField.sendKeys(city);
        searchButton.click();
    }
    public void edit(String city) {
        editButton.click();
        editNameField.sendKeys(  " - edited");
        save.click();
    }
    public String getMessage() {
        return message.getText();
    }
    public boolean containsSearchString(String searchString) {
        for (WebElement city : cityList) {
            WebElement cityLink = city.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
            if (!cityLink.getText().contains(searchString)) {
                return false;
            }
        }
        return true;
    }
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getMessageDeleteButton() {
        return messageDeleteButton;
    }

    public WebElement getDeleteWindow() {
        return deleteWindow;
    }
    public String getPopUpWindow() {
        return popUpWindow.getText();
    }

}
