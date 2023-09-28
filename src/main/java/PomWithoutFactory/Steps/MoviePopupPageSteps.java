package PomWithoutFactory.Steps;

import PomWithoutFactory.Pages.MoviePopupPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static HelperFunctions.PerformScrollAndClick.performScrollAndClick;

public class MoviePopupPageSteps{
    private final WebDriver driver;
    private final JavascriptExecutor js;
    private final MoviePopupPage moviePopupPage;
    private final MoviePageSteps moviePageSteps;

    public MoviePopupPageSteps(WebDriver driver, JavascriptExecutor js){
        this.driver = driver;
        this.js = js;
        this.moviePopupPage = new MoviePopupPage(driver);
        this.moviePageSteps = new MoviePageSteps(driver, js);
    }

    @Step("Check if movie information before selection is equal to information after selection")
    public MoviePopupPageSteps validateMovieInformation(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(moviePopupPage.getAllInfo()));

        String movieNameAfter = moviePopupPage.getMovieNameAfterElement().getText();
        String cinemaTitleAfter = moviePopupPage.getCinemaTitleAfterElement().getText();
        String[] seanceDateTimeAfterArr = moviePopupPage.getSeanceDateTimeAfterElement().getText().split(" ");
        String seanceDateTimeAfter = seanceDateTimeAfterArr[0] + seanceDateTimeAfterArr[seanceDateTimeAfterArr.length - 1];

        Assert.assertEquals(movieNameAfter, moviePageSteps.getMovieNameBefore(),"Invalid Seance!!!");
        Assert.assertEquals(cinemaTitleAfter, moviePageSteps.getCinemaTitleBefore(), "Invalid Seance!!!");
        Assert.assertEquals(seanceDateTimeAfter, moviePageSteps.getSeanceDateTimeBefore(),"Invalid Seance!!!");
        System.out.println("Information checking completed successfully 🥳");

        return this;
    }

    @Step("Choose random vacant place")
    public MoviePopupPageSteps locateAndChooseRandomVacantPlace(){
        List<WebElement> vacantPlaces = moviePopupPage.getVacantPlaces();
        int numberOfVacantPlaces = vacantPlaces.size();
        //   Choose random vacant place
        Random random = new Random();
        int randomVacantPlaceNumber = random.nextInt(numberOfVacantPlaces);
        WebElement randomVacantPlace = vacantPlaces.get(randomVacantPlaceNumber);
        performScrollAndClick(randomVacantPlace, js);
        System.out.println("Random vacant place chosen!");


        return this;
    }

    @Step("Congratulations, the Test has passed successfully! 🥳 Final Message: {finalMessage}")
    public void endTheTest(String finalMessage){
        //    Finish the test peacefully 😉
        System.out.println(finalMessage);
    }

}
