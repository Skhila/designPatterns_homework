package HelperFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PerformScrollAndClick {
    public static void performScrollAndClick(WebElement target, JavascriptExecutor js){
        js.executeScript("arguments[0].scrollIntoView(true);" +
                "arguments[0].click()", target);
    }
}
