package PomWithFactorySwoopTest;

import ConfigClasses.BaseConfigSelenium;
import ConfigClasses.Listeners.SeleniumListener;
import PomWithFactory.Steps.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SeleniumListener.class)
@Epic("Ticket Booking Tests (PageFactory)")
@Feature("Swoop.ge Movies Tests Using PageFactory")
public class SwoopTestWithFactory extends BaseConfigSelenium{
    HomePageSteps homePageSteps;
    MoviesPageSteps moviesPageSteps;
    MoviePageSteps moviePageSteps;
    MoviePopupPageSteps moviePopupPageSteps;

    @BeforeMethod
    public void initializePages(){
        homePageSteps = new HomePageSteps(driver, js);
        moviesPageSteps = new MoviesPageSteps(driver, js);
        moviePageSteps = new MoviePageSteps(driver, js);
        moviePopupPageSteps = new MoviePopupPageSteps(driver, js);
    }


    @Test(description = "Swoop.ge Test using PageFactory")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Swoop.ge Full Test With PageFactory")
    @Description("Test Description: This Swoop test opens Swoop.ge, navigates to the /events page and chooses the first movie which has seances in Cavea East Eoint." +
            "Then, chooses the last seance of the last date in Cavea East Eoint." +
            " Finally, it chooses a random vacant place. (Using a POM design pattern and pageFactory/fluentAPI)")
    public void swoopTestWithFactory(){
        homePageSteps.goToMoviesPage();

        moviesPageSteps.clickFirstEastPointMovie();

        moviePageSteps.clickOnLastDate().validateSeances().locateAndClickOnLastSeance();

        moviePopupPageSteps.validateMovieInformation().locateAndChooseRandomVacantPlace().endTheTest("That's all for this test 🥳👌");
    }
}
