package PomWithoutFactory.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private static final String PAGE_URL="https://www.swoop.ge/";
    public HomePage(WebDriver driver) {
        this.driver=driver;
        driver.get(PAGE_URL);
    }

//    Locators
    private final By movieButton = By.xpath("//li[contains(@class,'MoreCategories')]/a[contains(normalize-space(), 'კინო')]");

//    Methods to get elements
    public WebElement getMovieButton(){
        return driver.findElement(movieButton);
    }
}
