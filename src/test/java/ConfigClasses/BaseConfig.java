package ConfigClasses;

import com.codeborne.selenide.Selenide;
import io.netty.channel.unix.SocketWritableByteChannel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.reportsFolder;

public class BaseConfig {
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
