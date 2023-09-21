package PomWithoutFactory.Steps;


import PomWithoutFactory.Pages.MoviePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static HelperFunctions.PerformScrollAndClick.performScrollAndClick;

public class MoviePageSteps {
    private final WebDriver driver;
    private final JavascriptExecutor js;
    private final MoviePage moviePage;

    public MoviePageSteps(WebDriver driver, JavascriptExecutor js){
        this.driver = driver;
        this.js = js;
        this.moviePage = new MoviePage(driver);
    }

    @Step("Click on last date to see seances")
    public MoviePageSteps clickOnLastDate(){
        performScrollAndClick(moviePage.getEastPointLastDate(), js);
        return this;
    }

    @Step("Validate Seances - check if all of them are located in cavea east point")
    public MoviePageSteps validateSeances(){
        //    Iterate through all present seances and ensure that all of them are located in Cavea EastPoint cinema.
        for (WebElement seance : moviePage.getCaveaSeances()) {
            String cinemaActualName = seance.findElement(By.cssSelector("p.cinema-title")).getText();
            Assert.assertEquals("კავეა ისთ ფოინთი", cinemaActualName, "Seance out of Cavea Eastpoint detected!!!");
        }
        System.out.println("All seances are from Cavea EastPoint 🥳");

        return this;
    }

    @Step("Get movie name before selecting seance")
    public String getMovieNameBefore(){
        return moviePage.getMovieNameElement().getText();
    }

    @Step("Get seance date and time before selecting seance")
    public String getSeanceDateTimeBefore(){
        WebElement caveaLastSeance = moviePage.getCaveaSeances().get(moviePage.getCaveaSeances().size()-1);
        String seanceDateBefore = moviePage.getEastPointLastDate().getText().split(" ")[0];
        String seanceTimeBefore = caveaLastSeance.getText().split("\n")[0];

        return seanceDateBefore + seanceTimeBefore;
    }

    @Step("Get cinema title before selecting seance")
    public String getCinemaTitleBefore(){
        WebElement caveaLastSeance = moviePage.getCaveaSeances().get(moviePage.getCaveaSeances().size()-1);
        return caveaLastSeance.findElement(By.cssSelector("p.cinema-title")).getText();
    }

    @Step("Select last seance")
    public MoviePageSteps locateAndClickOnLastSeance(){
        WebElement caveaLastSeance = moviePage.getCaveaSeances().get(moviePage.getCaveaSeances().size()-1);
        performScrollAndClick(caveaLastSeance, js);
        return this;
    }

}
