package PomWithFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MoviePage {
    private WebDriver driver;
    @FindBy(css = "div[aria-hidden=false] div.calendar-tabs ul li:last-child a")
    public WebElement eastPointLastDate;
    @FindBy(css = "div[class*='ui-tabs-panel'][aria-hidden=false] div[class*='seanse-details'][aria-hidden=false] a")
    public List<WebElement> caveaSeances;
    @FindBy(css = "div.info p.name")
    public WebElement movieNameElement;

    public MoviePage(WebDriver driver){
        this.driver = driver;
        initElements(new AjaxElementLocatorFactory(driver,15), this);
    }
}
