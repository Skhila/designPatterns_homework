package basicpom.Steps;

import basicpom.Data.StudentData;
import basicpom.Pages.PopupWindowPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;

public class PopupWindowPageSteps {
    StudentData studentData = new StudentData();
    PopupWindowPage popupWindowPage = new PopupWindowPage();
    @Step("Check popup title visibility and text")
    public boolean checkModalTitleVisibilityAndText(){
//        Firstly, check if the title is visible
        popupWindowPage.popupTitle.should(appear);

        return popupWindowPage.popupTitle.getText().equals("Thanks for submitting the form");
    }
    @Step("Get student info from popup window")
    public HashMap<String, String> getStudentInfoFromPopup(){
        List<String> headers = popupWindowPage.studentInfoTableColumns.texts();
        int rowSize = popupWindowPage.studentInfoTableRows.size();

        int indexOfLabel = headers.indexOf("Label");
        int indexOfValues = headers.indexOf("Values");

//        Create HashMap to store student's information, Labels and Values
        HashMap<String, String> studentInfo = new HashMap<>();

//        Iterate through rows and columns, store information into StudentInfo hashMap
        for(int rowNum = 1; rowNum <= rowSize; rowNum++){

            String studentLabel = popupWindowPage.studentInfoTable.$(By.xpath(".//tbody/tr[" + rowNum + "]/td[" + (indexOfLabel + 1) + "]")).getText();
            String studentValue = popupWindowPage.studentInfoTable.$(By.xpath(".//tbody/tr[" + rowNum + "]/td[" + (indexOfValues + 1) + "]")).getText();

            if(!studentLabel.isEmpty()) studentInfo.put(studentLabel, studentValue);
        }

        return studentInfo;
    }
    private HashMap<String, String> studentInfo;
    @Step("Compare Full Name")
    public boolean compareFullName(){
        studentInfo = getStudentInfoFromPopup();
        String studentFullName = studentData.firstName + " " + studentData.lastName;
        return studentFullName.equals(studentInfo.get("Student Name"));
    }
    @Step("Compare Gender")
    public boolean compareGender(){
        studentInfo = getStudentInfoFromPopup();
        String studentGender = studentData.gender;
        return studentGender.equals(studentInfo.get("Gender"));
    }
    @Step("Compare Mobile Number")
    public boolean compareMobileNumber(){
        studentInfo = getStudentInfoFromPopup();
        String studentMobileNumber = studentData.mobileNumber;
        return studentMobileNumber.equals(studentInfo.get("Mobile"));
    }
}
