package test02.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetup {

        private WebDriver driver;

        static String driverPath = "test02\\driver\\";
        public WebDriver getDriver() {
            return driver;
        }

        private void setDriver(String browserType, String appURL) {
            switch (browserType) {
                case "chrome":
                    driver = initChromeDriver(appURL);
                    break;
                default:
                    System.out.println("Browser: " + browserType + ": chrome is defautl");
                    driver = initChromeDriver(appURL);
            }
        }

        private static WebDriver initChromeDriver(String appURL) {
            System.out.println("Start to Chrome browser...");
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(appURL);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        }

        @Parameters({ "browserType", "appURL" })
        @BeforeClass
        public void initializeTestBaseSetup(String browserType, String appURL) {
            try {
                setDriver(browserType, appURL);
            } catch (Exception e) {
                System.out.println("Error..." + e.getStackTrace());
            }
        }

        @AfterClass
        public void tearDown() throws Exception {
            Thread.sleep(2000);
            driver.quit();
        }
    }

