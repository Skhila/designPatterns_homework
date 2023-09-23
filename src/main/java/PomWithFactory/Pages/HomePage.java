package PomWithFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage {
    private WebDriver driver;
    private static final String PAGE_URL="https://www.swoop.ge/";
    @FindBy(xpath = "//li[contains(@class,'MoreCategories')]/a[contains(normalize-space(), 'კინო')]")
    public WebElement movieButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(PAGE_URL);
        initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
}
