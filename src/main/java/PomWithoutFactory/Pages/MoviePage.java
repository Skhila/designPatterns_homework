package PomWithoutFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MoviePage {
    private final WebDriver driver;
    public MoviePage(WebDriver driver) {
        this.driver=driver;
    }

//    Locate east point last date, cavea seances and movie name;
    private final By eastPointLastDate = By.cssSelector("div[aria-hidden=false] div.calendar-tabs ul li:last-child a"),
        caveaSeances = By.cssSelector("div[class*='ui-tabs-panel'][aria-hidden=false] div[class*='seanse-details'][aria-hidden=false] a"),
        movieNameElement = By.cssSelector("div.info p.name");

//    Methods to get elements
    public WebElement getEastPointLastDate(){
        return driver.findElement(eastPointLastDate);
    }
    public List<WebElement> getCaveaSeances(){
        return driver.findElements(caveaSeances);
    }
    public WebElement getMovieNameElement(){
        return driver.findElement(movieNameElement);
    }
}
