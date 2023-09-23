package PomWithFactorySwoopTest;

import ConfigClasses.BaseConfigSelenium;
import PomWithFactory.Steps.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void swoopTestWithFactory(){
        homePageSteps.goToMoviesPage();

        moviesPageSteps.clickFirstEastPointMovie();

        moviePageSteps.clickOnLastDate().validateSeances().locateAndClickOnLastSeance();

        moviePopupPageSteps.validateMovieInformation().locateAndChooseRandomVacantPlace().endTheTest();
    }
}
