This simple example demonstrates how to use Selenium Manager in Selenium 4.6 (and above). For the demonstration, I have
made use of Selenium 4.11.0

## What is Selenium Manager

Selenium Manager is a new tool that helps to get a working environment to run Selenium out of the box.

Available with Selenium v4.6 (and above), it automatically configures the browser drivers for Chrome, Firefox, Internet
Explorer, and Edge.

More information about Selenium Manager is available in the following locations:

* [Introducing Selenium Manager](https://www.selenium.dev/blog/2022/introducing-selenium-manager/)
* [Selenium Manager GitHub Repo](https://github.com/SeleniumHQ/selenium/tree/trunk/common/manager)
* [Selenium Manger in Java](https://github.com/SeleniumHQ/selenium/commit/eecdacae2d83b611cb9c089f7d3cb0220218b78e)

## How to use Selenium Manager in Java

* Add [Selenium Java 4.11.0](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.11.0) dependency
  in pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.11.0</version>
</dependency>
```

## Execution

Here is all what is needed to instantiate the browsers:

* Chrome ------> WebDriver driver = new ChromeDriver();
* Firefox ------> WebDriver driver = new FirefoxDriver();
* Edge --------> WebDriver driver = new EdgeDriver();

For demonstration, I used the *getInstance* method in *SeleniumManager* to print the location where the respective
browser drivers are downloaded:

<img width="1420" alt="VS_IDE_Selenium_Manager_2" src="https://user-images.githubusercontent.com/1688653/207524076-dfa57992-93fb-460b-9ee5-1d4d85cd6fcc.png">

On execution, the browser drivers are downloaded in */Users/applemacbook_pro/.cache/selenium* folder. These would be
re-downloaded in case there is any update in the browser version.

<img width="728" alt="CMD_Selenium_Manager" src="https://user-images.githubusercontent.com/1688653/207521761-bcebdaa1-e30a-4743-8b62-8d350d98ab3f.png">
