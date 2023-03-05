package test02.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends ComonPage {
    ComonPage commonPage = new ComonPage(driver);

    private By email = By.name("email");
    private By passWord = By.name("password");
    private String title = "Dashboard";
    private By loginButton = By.xpath("//span[text()='Login']");
    private String emailPlaceHolder = "Email";
    private String pwPlaceHolder = "Password";
    private String attribute = "placeholder";
    private By checkBox = By.xpath("//div[contains(@class,'icheckbox_square-grey')]");
    private By person = By.xpath("//i[text()='person']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void signIn(String valueEmail, String valuePassword) {
        commonPage.waitFluent(10,1000, email);
        commonPage.inputValueToField(email, valueEmail);
        commonPage.inputValueToField(passWord, valuePassword);
        commonPage.clickOnButon(loginButton);
        commonPage.waitFluent(10, 1000, person);
        Assert.assertEquals(commonPage.getTitle(), title);
        System.out.println("Login success");
    }
    public void verifyEmailPlaceHolder() {
        Assert.assertEquals(commonPage.getAttribute(email, attribute), emailPlaceHolder);
        Assert.assertEquals(commonPage.getAttribute(passWord, attribute), pwPlaceHolder);
        System.out.println("Compare placeholder success");
    }
    public void clickRememberMe() {
        waitFluent(30,1000,checkBox);
        commonPage.clickOnButon(checkBox);
        System.out.println("Click on checkbox done");
    }
    public void verifyCheckedCheckbox() {
        waitFluent(30,1000,checkBox);
        String isChecked = commonPage.getAttribute(checkBox, "class");
        Assert.assertTrue(isChecked.contains("checked"));
        System.out.println("Verify checkbox was checked done!");
    }
}
