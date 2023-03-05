package test02.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test02.base.BaseSetup;
import test02.page.LoginPage;

public class TC_01_Login_Success extends BaseSetup {
    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test()
    public void signIn() {
        System.out.println(driver);
        loginPage = new LoginPage(driver);
        System.out.println("Do login to the website");
        loginPage.signIn("admin@phptravels.com", "demoadmin");
    }
}
