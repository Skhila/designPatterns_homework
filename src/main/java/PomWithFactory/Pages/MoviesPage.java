package PomWithFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.util.List;

public class MoviesPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='movie-logos']//a[@class='movie-icons']//img[contains(@src, 'cavea-istFointi')]")
    public WebElement firstMovieWithEastPoint;

    public MoviesPage(WebDriver driver){
        this.driver = driver;
        initElements(new AjaxElementLocatorFactory(driver,10), this);
    }




}
