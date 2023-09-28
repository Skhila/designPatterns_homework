package ConfigClasses;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.reportsFolder;

public class BaseConfigSelenide {
    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        timeout=15000;

        screenshots=true;
        savePageSource = false;
        reportsFolder="src/main/resources/Reports/FailedTests";

    }

    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
