package PomWithoutFactorySwoopTest;

import ConfigClasses.BaseConfigSelenium;
import ConfigClasses.Listeners.SeleniumListener;
import PomWithoutFactory.Steps.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(SeleniumListener.class)
@Epic("Ticket Booking Tests (Without PageFactory)")
@Feature("Swoop.ge Movies Tests Without PageFactory")
public class SwoopWithoutFactory extends BaseConfigSelenium {
    HomePageSteps homePageSteps;
    MoviesPageSteps moviesPageSteps;
    MoviePageSteps moviePageSteps;
    MoviePopupPageSteps moviePopupPageSteps;

    @BeforeMethod
    public void initializePageSteps(){
        homePageSteps = new HomePageSteps(driver, js);
        moviesPageSteps = new MoviesPageSteps(driver, js);
        moviePageSteps = new MoviePageSteps(driver, js);
        moviePopupPageSteps = new MoviePopupPageSteps(driver, js);
    }


    @Test(description = "Swoop.ge Test Without PageFactory")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Swoop.ge Full Test Without PageFactory")
    @Description("Test Description: This Swoop test opens Swoop.ge, navigates to the /events page and chooses the first movie which has seances in Cavea East Eoint." +
            "Then, chooses the last seance of the last date in Cavea East Eoint." +
            " Finally, it chooses a random vacant place. (Using a POM design pattern and fluentAPI)")
    public void swoopTestWithoutFactory(){
        homePageSteps.goToMoviesPage();

        moviesPageSteps.clickFirstEastPointMovie();

        moviePageSteps.clickOnLastDate().validateSeances().locateAndClickOnLastSeance();

        moviePopupPageSteps.validateMovieInformation().locateAndChooseRandomVacantPlace().endTheTest("That's all for this test 🥳👌");
    }
}
