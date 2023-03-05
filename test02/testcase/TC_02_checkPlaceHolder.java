package test02.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test02.base.BaseSetup;
import test02.page.LoginPage;

public class TC_02_checkPlaceHolder extends BaseSetup {
    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test()
    public void verifyPlaceHolder() {
        loginPage = new LoginPage(driver);
        loginPage.verifyEmailPlaceHolder();
        loginPage.clickRememberMe();
        loginPage.verifyCheckedCheckbox();
    }
    @Test()
    public void verifyClicked() {
        loginPage = new LoginPage(driver);
        loginPage.clickRememberMe();
        loginPage.verifyCheckedCheckbox();
    }

}
