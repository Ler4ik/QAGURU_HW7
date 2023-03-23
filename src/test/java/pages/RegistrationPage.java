package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private String titleText = "Practice Form";

    public void openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(titleText));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void setFirstName(String value){
        $("#firstName").setValue(value);
    }

    public void setLastName(String value){
        $("#lastName").setValue(value);
    }

    public void setEmail(String value){
        $("#userEmail").setValue(value);
    }

    public void setGender(String value){
        $(byText(value)).click();
    }

    public void setNumber(String value){
        $("#userNumber").setValue(value);
    }
}
