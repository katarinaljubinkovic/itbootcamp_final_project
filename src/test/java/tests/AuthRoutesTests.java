package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    public void ForbidsVisitToHomeTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void ForbidsVisitToProfileTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void ForbidsVisitToAdminCitiesTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities ");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Test
    public void ForbidsVisitToAdminUsersTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users ");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
}
