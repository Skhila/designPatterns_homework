package basicpom.Steps;

import basicpom.Pages.FormsPage;
import io.qameta.allure.Step;

public class FormsPageSteps {
    FormsPage formsPage = new FormsPage();

    @Step("Scroll and click on the 'Practice Form' link")
    public void navigateToPracticeFormPage(){
        formsPage.linkToPracticeForm.scrollTo().click();
    }
}
