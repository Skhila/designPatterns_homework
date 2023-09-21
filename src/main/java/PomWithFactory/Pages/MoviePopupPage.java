package PomWithFactory.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.util.List;

public class MoviePopupPage {
    private WebDriver driver;

    @FindBy(css = "div.tickets-corns div.right-content div.content-header")
    public WebElement allInfo;
    @FindBy(css = "div.tickets-corns div.right-content div.content-header p:nth-child(1)")
    public WebElement movieNameAfterElement;

    @FindBy(css = "div.tickets-corns div.right-content div.content-header p:nth-child(2)")
    public WebElement cinemaTitleAfterElement;

    @FindBy(css = "div.tickets-corns div.right-content div.content-header p:nth-child(3)")
    public WebElement seanceDateTimeAfterElement;

    @FindBy(css = "div.tickets-corns div#cinema-tickets div.seat.free")
    public List<WebElement> vacantPlaces;
    public MoviePopupPage(WebDriver driver){
        this.driver = driver;
        initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
}
