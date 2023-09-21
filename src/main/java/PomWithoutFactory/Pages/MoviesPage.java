package PomWithoutFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoviesPage {
    private final WebDriver driver;
    public MoviesPage(WebDriver driver) {
        this.driver=driver;
    }
//    Locator
    private final By firstMovieWithEastPoint = By.xpath("//div[@class='movie-logos']//a[@class='movie-icons']//img[contains(@src, 'cavea-istFointi')]");

//    Methods to get elements
    public WebElement getFirstMovieWithEastPoint(){
        return driver.findElement(firstMovieWithEastPoint);
    }
}
