package ConfigClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseConfigSelenium {
    //    Setup Driver
    protected static WebDriver driver;
    public Actions action;
    public JavascriptExecutor js;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    //    Quit Driver
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
