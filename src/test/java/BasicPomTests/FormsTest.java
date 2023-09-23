package BasicPomTests;

import ConfigClasses.BaseConfigSelenide;
import basicpom.Data.StudentData;
import basicpom.Steps.FormsPageSteps;
import basicpom.Steps.HomePageSteps;
import basicpom.Steps.PopupWindowPageSteps;
import basicpom.Steps.PracticeFormPageSteps;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseConfigSelenide {
    StudentData studentData = new StudentData();
    HomePageSteps homePageSteps = new HomePageSteps();
    FormsPageSteps formsPageSteps = new FormsPageSteps();
    PracticeFormPageSteps practiceFormPageSteps = new PracticeFormPageSteps();
    PopupWindowPageSteps popupWindowPageSteps = new PopupWindowPageSteps();

    @Test(description = "Forms filling and Validating scenario")
    @Description("Success form fill scenario")
    @Story("Valid firstname, lastname, gender and mobile phone form fill test")
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
