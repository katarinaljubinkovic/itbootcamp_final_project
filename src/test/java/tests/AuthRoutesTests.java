package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    public void forbidsVisitToHomeTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void forbidsVisitToProfileTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void forbidsVisitToAdminCitiesTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities ");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void forbidsVisitToAdminUsersTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users ");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
