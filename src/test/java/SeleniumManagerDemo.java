import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.manager.SeleniumManager;

public class SeleniumManagerDemo
{
    protected static ThreadLocal<WebDriver> ThreadLocal
            = new ThreadLocal<WebDriver>();

    String testURL = "https://www.lambdatest.com";

    @Test(description="Demonstration of Toggle Buttons on LambdaTest Selenium Grid")
    public void testEdge() throws InterruptedException {
        /* Selenium Manager - MS Edge */
        /* [Start] Optional - Printing path of browser driver */
        /*
        SeleniumManager manager = SeleniumManager.getInstance();
        String path = manager.getDriverPath("msedgedriver");
        System.out.println(path);
        */
        /* [End] Optional - Printing path of browser driver */

        /* Voila, only this line is sufficient */

        WebDriver driver = new EdgeDriver();

        ThreadLocal.set(driver);

        driver.get(testURL);

        Thread.sleep(3000);

        driver.quit();
        ThreadLocal.remove();

        Thread.sleep(5000);
    }

    @Test(description="Demonstration of Toggle Buttons on LambdaTest Selenium Grid")
    public void testFirefox() throws InterruptedException {
        /* Selenium Manager - Firefox */
        /* [Start] Optional - Printing path of browser driver */
        /*
        SeleniumManager manager = SeleniumManager.getInstance();
        String path = manager.getDriverPath("geckodriver");
        System.out.println(path);
         */
        /* [End] Optional - Printing path of browser driver */

        /* Voila, only this line is sufficient */
        
        WebDriver driver = new FirefoxDriver();
        ThreadLocal.set(driver);

        driver.get(testURL);

        Thread.sleep(3000);

        driver.quit();
        ThreadLocal.remove();

        Thread.sleep(5000);
    }

    @Test(description="Demonstration of Toggle Buttons on LambdaTest Selenium Grid")
    public void testChrome() throws InterruptedException {
        /* Selenium Manager - Chrome */
        /* [Start] Optional - Printing path of browser driver */
        /*
        SeleniumManager manager = SeleniumManager.getInstance();
        String path = manager.getDriverPath("chromedriver");
        System.out.println(path);
        */
        /* [End] Optional - Printing path of browser driver */

        /* Voila, only this line is sufficient */

        WebDriver driver = new ChromeDriver();

        ThreadLocal.set(driver);

        driver.get(testURL);

        Thread.sleep(3000);

        driver.quit();
        ThreadLocal.remove();

        Thread.sleep(5000);
    }
}
