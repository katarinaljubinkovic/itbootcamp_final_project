package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;

public abstract class BaseTest {
    protected final String URL = "https://vue-demo.daniel-avellaneda.com/";
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected HomePage homePage;
    protected Faker faker;


    @BeforeClass
    public void beforeClass() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        faker = new Faker();
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
