package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormsPage {

    public SelenideElement linkToPracticeForm = $(byText("Practice Form"));

}
