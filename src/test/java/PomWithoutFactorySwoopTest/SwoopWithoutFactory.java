package PomWithoutFactorySwoopTest;

import ConfigClasses.BaseConfigSelenium;
import PomWithoutFactory.Steps.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwoopWithoutFactory extends BaseConfigSelenium {
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
    public void swoopTestWithoutFactory(){
        homePageSteps.goToMoviesPage();

        moviesPageSteps.clickFirstEastPointMovie();

        moviePageSteps.clickOnLastDate().validateSeances().locateAndClickOnLastSeance();

        moviePopupPageSteps.validateMovieInformation().locateAndChooseRandomVacantPlace().endTheTest();
    }
}
