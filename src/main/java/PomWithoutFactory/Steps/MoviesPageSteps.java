package PomWithoutFactory.Steps;

import PomWithoutFactory.Pages.MoviesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static HelperFunctions.PerformScrollAndClick.performScrollAndClick;

public class MoviesPageSteps{
    private final WebDriver driver;
    private final JavascriptExecutor js;
    private final MoviesPage moviesPage;

    public MoviesPageSteps(WebDriver driver, JavascriptExecutor js){
        this.driver = driver;
        this.js = js;
        this.moviesPage = new MoviesPage(driver);
    }

    @Step("Go to the first Movie which has Cavea east point seances")
    public MoviesPageSteps clickFirstEastPointMovie(){
        performScrollAndClick(moviesPage.getFirstMovieWithEastPoint(), js);
        return this;
    }
}
