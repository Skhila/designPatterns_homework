package Steps;

import Data.StudentData;
import Pages.PracticeFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPageSteps {
    StudentData studentData = new StudentData();
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Step("Fill firstName field")
    public PracticeFormPageSteps setFirstName(){
        practiceFormPage.firstNameField.setValue(studentData.firstName);
        return this;
    }
    @Step("Fill lastName field")
    public PracticeFormPageSteps setLastName(){
        practiceFormPage.lastNameField.setValue(studentData.lastName);
        return this;

    }

    @Step("Choose gender")
    public PracticeFormPageSteps setGender(){
        executeJavaScript("arguments[0].scrollIntoView(); " +
                "arguments[0].click()", practiceFormPage.genderRadioButton);
        return this;
    }

    @Step("Fill mobile number field")
    public PracticeFormPageSteps setMobileNumber(){
        practiceFormPage.mobileNumberField.setValue(studentData.mobileNumber);
        return this;
    }

    @Step("Submit form")
    public PracticeFormPageSteps submit(){
        executeJavaScript("arguments[0].scrollIntoView(); " +
                "arguments[0].click()", practiceFormPage.submitButton);
        return this;
    }
}
