package ConfigClasses.Listeners;

import ConfigClasses.BaseConfigSelenium;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SeleniumListener extends BaseConfigSelenium implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult){
        takeScreenshot(BaseConfigSelenium.driver);
        saveLogs(iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String saveLogs(String message){
        return message;
    }
}
