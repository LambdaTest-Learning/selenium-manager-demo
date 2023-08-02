import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SeleniumWebDriverManagerTests {


    private WebDriver driver;

    @Test
    public void testOnChromeOldVersionWithSeleniumManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("114");
        driver = new ChromeDriver(options);
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
        System.out.println(driver.getTitle());
    }

    @Test
    public void testChromeLatestVersionWithSeleniumManager() {
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testChromeStableWithSeleniumManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("stable");
        System.out.println(options.getBrowserVersion());
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testChromeBetaWithSeleniumManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("beta");
        System.out.println(options.getBrowserVersion());
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testChromeDevWithSeleniumManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("dev");
        System.out.println(options.getBrowserVersion());
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testChromeCanaryWithSeleniumManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("canary");
        System.out.println(options.getBrowserVersion());
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnChromeOldVersionWithWebDriverManager() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("113");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
        System.out.println(driver.getTitle());
    }

    @Test
    public void testChromeLatestVersionWithWebDriverManager() {
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnChromeBySettingEnvVariablePath() {

        //Provide the chromedriver.exe path in the Environment variable before running this test.
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

    }

    @Test
    public void testOnChromeBySettingBinaryPathUsingSetProperty() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(driver.getTitle(), "Your Store");
    }


    @AfterMethod(alwaysRun = true)

    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
