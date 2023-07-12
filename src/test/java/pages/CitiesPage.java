package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage{
    @FindBy(className = "btnNewItem")
    private WebElement newItemButton;

    @FindBy(id = "name")
    private WebElement cityName;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement alertMessage;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div/i")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editButton;

    @FindBy(id = "name")
    private WebElement editNameInput;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindAll({@FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")})
    private List<WebElement> cityList;

    @FindBy (css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement confirmDelete;

    public CitiesPage(WebDriver driver) {
        super(driver);
    }

    public void createCity(String city) {
        newItemButton.click();
        cityName.clear();
        cityName.sendKeys(city);
        saveButton.click();
    }
    public String getMessage(){
        return alertMessage.getText();
    }
    public void search(String city) {
        searchField.clear();
        searchField.sendKeys(city);
        searchButton.click();
    }
    public void edit() {
        editButton.click();
        editNameInput.sendKeys(  " - edited");
        saveButton.click();
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
    public void delete(String city) {
        deleteButton.click();
        confirmDelete.click();
    }

}
