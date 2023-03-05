package test02.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ComonPage {
    public WebDriver driver ;
    public ComonPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputValueToField(By webElement, String value){
        WebElement element = driver.findElement(webElement);
        if(element.isDisplayed()){
            element.sendKeys(value);
        }
    }
    public void clickOnButon(By webElement){
        WebElement element = driver.findElement(webElement);
        if(element.isDisplayed()){
            element.click();
        }
    }
   public String getTitle(){
        return driver.getTitle();
   }
   public String getAttribute(By webElement, String attribute){
       String text = driver.findElement(webElement).getAttribute(attribute);
       System.out.println("Log value of attribute: " + text);
       return text;
   }
   public void waitFluent(int second, int milis, By element){
       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(second))
               .pollingEvery(Duration.ofMillis(milis))
               .ignoring(NoSuchElementException.class);
       wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }
}
