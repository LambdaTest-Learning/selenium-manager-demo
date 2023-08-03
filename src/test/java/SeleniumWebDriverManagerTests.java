import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SeleniumWebDriverManagerTests {
    private WebDriver driver;

    @Test
    public void testOnChromeOldVersionWithSeleniumManager() {
        final ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("114");
        this.driver = new ChromeDriver(options);
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
        System.out.println(this.driver.getTitle());
    }

    @Test
    public void testChromeLatestVersionWithSeleniumManager() {
        this.driver = new ChromeDriver();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @DataProvider
    public Iterator<Object[]> browserVersions() {
        final List<Object[]> versions = new ArrayList<>();
        versions.add(new Object[]{"stable"});
        versions.add(new Object[]{"beta"});
        versions.add(new Object[]{"dev"});
        versions.add(new Object[]{"canary"});
        return versions.iterator();
    }

    @Test(dataProvider = "browserVersions")
    public void testChromeVersionsWithSeleniumManager(final String browserVersion) {
        final ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion(browserVersion);
        this.driver = new ChromeDriver(options);
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnChromeOldVersionWithWebDriverManager() {
        final ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("113");
        this.driver = WebDriverManager.chromedriver().capabilities(options).create();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
        System.out.println(this.driver.getTitle());
    }

    @Test
    public void testChromeLatestVersionWithWebDriverManager() {
        this.driver = WebDriverManager.chromedriver().create();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnChromeBySettingEnvVariablePath() {

        //Provide the chromedriver.exe path in the Environment variable before running this test.
        this.driver = new ChromeDriver();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

    }

    @Test
    public void testOnChromeBySettingBinaryPathUsingSetProperty() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnFirefoxLatestVersionWithSeleniumManager() {
        this.driver = new FirefoxDriver();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @Test
    public void testOnEdgeLatestVersionWithSeleniumManager() {
        this.driver = new EdgeDriver();
        this.driver.get("https://ecommerce-playground.lambdatest.io/");

        assertEquals(this.driver.getTitle(), "Your Store");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}
