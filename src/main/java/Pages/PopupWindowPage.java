package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PopupWindowPage {

    public SelenideElement studentInfoTable = $(".table-responsive table");

    public SelenideElement popupTitle = $("div.modal-title");
    public ElementsCollection studentInfoTableRows = studentInfoTable.$$("tbody tr"),
            studentInfoTableColumns = studentInfoTable.$$("th");
}
