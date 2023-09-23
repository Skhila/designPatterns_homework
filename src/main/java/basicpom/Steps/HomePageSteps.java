package basicpom.Steps;

import basicpom.Pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    @Step("Open the home page, then scroll and click on the 'Forms' link")
    public void navigateToFormsPage(){
        homePage.linkToForm.scrollTo().click();
    }
}
