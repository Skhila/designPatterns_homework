package BasicPomTests;

import ConfigClasses.BaseConfigSelenide;
import ConfigClasses.Listeners.SelenideListener;
import basicpom.Data.StudentData;
import basicpom.Steps.FormsPageSteps;
import basicpom.Steps.HomePageSteps;
import basicpom.Steps.PopupWindowPageSteps;
import basicpom.Steps.PracticeFormPageSteps;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SelenideListener.class)
@Epic("Tests Using selenide")
@Feature("Forms Test")
public class FormsTest extends BaseConfigSelenide {
    StudentData studentData = new StudentData();
    HomePageSteps homePageSteps = new HomePageSteps();
    FormsPageSteps formsPageSteps = new FormsPageSteps();
    PracticeFormPageSteps practiceFormPageSteps = new PracticeFormPageSteps();
    PopupWindowPageSteps popupWindowPageSteps = new PopupWindowPageSteps();

    @Test(description = "Forms filling and Validating scenario")
    @Severity(SeverityLevel.MINOR)
    @Story("Valid firstname, lastname, gender and mobile phone form fill test")
    @Description("This test navigates to practice forms page and simulates form fill")
    public void formsTest(){
        open("https://demoqa.com/");

        homePageSteps.navigateToFormsPage();

        formsPageSteps.navigateToPracticeFormPage();

        practiceFormPageSteps.setFirstName().setLastName().setGender().setMobileNumber().submit();

        Assert.assertTrue(popupWindowPageSteps.checkModalTitleVisibilityAndText(), "There is NOT a valid modal title");

        Assert.assertTrue(popupWindowPageSteps.compareFullName(), "\nStudent name is not correct!\n");
        Assert.assertTrue(popupWindowPageSteps.compareGender(), "\nStudent gender is not correct!\n");
        Assert.assertTrue(popupWindowPageSteps.compareMobileNumber(), "\nStudent mobile number is not correct!\n");

        System.out.printf("\nStudent: %s %s registered successfully!\n", studentData.firstName, studentData.lastName);
    }
}
