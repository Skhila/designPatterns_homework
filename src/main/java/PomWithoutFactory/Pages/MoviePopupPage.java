package PomWithoutFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoviePopupPage {
    private final WebDriver driver;
    public MoviePopupPage(WebDriver driver) {
        this.driver=driver;
    }

//    Locators
    private final By allInfo = By.cssSelector("div.tickets-corns div.right-content div.content-header"),
        movieNameAfterElement = By.cssSelector("div.tickets-corns div.right-content div.content-header p:nth-child(1)"),
        cinemaTitleAfterElement = By.cssSelector("div.tickets-corns div.right-content div.content-header p:nth-child(2)"),
        seanceDateTimeAfterElement = By.cssSelector("div.tickets-corns div.right-content div.content-header p:nth-child(3)"),
        vacantPlaces = By.cssSelector("div.tickets-corns div#cinema-tickets div.seat.free");

//    Methods to get elements
    public WebElement getAllInfo(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(allInfo));
        return driver.findElement(allInfo);
    }
    public WebElement getMovieNameAfterElement(){
        return driver.findElement(movieNameAfterElement);
    }
    public WebElement getCinemaTitleAfterElement(){
        return driver.findElement(cinemaTitleAfterElement);
    }
    public WebElement getSeanceDateTimeAfterElement(){
        return driver.findElement(seanceDateTimeAfterElement);
    }
    public List<WebElement> getVacantPlaces(){
        return driver.findElements(vacantPlaces);
    }
}
