package Pages;

import Data.StudentData;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeFormPage {
    public String gender = new StudentData().gender;
    public SelenideElement firstNameField = $(By.id("firstName")),
            lastNameField = $(By.id("lastName")),
            genderRadioButton = $$("label").findBy(exactText(gender)),
            mobileNumberField = $(By.id("userNumber")),
            submitButton = $(By.id("submit"));
}
