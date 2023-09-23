package PomWithFactory.Steps;

import PomWithFactory.Pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static HelperFunctions.PerformScrollAndClick.performScrollAndClick;

public class HomePageSteps{
    private final WebDriver driver;
    private final JavascriptExecutor js;
    private final HomePage homePage;

    public HomePageSteps(WebDriver driver, JavascriptExecutor js){
        this.driver = driver;
        this.js = js;
        this.homePage = new HomePage(driver);
    }
    @Step("Navigate to the Movies Page")
    public HomePageSteps goToMoviesPage(){
        performScrollAndClick(homePage.movieButton, js);
        return this;
    }
}
