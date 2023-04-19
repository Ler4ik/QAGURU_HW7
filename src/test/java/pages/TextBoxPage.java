package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private String TITLE_TEXT = "Text Box";
    private SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage(){
        open("/text-box");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value){
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);

        return this;
    }

    public  TextBoxPage clickSubmitButton(){
        submitButton.click();

        return this;
    }
}
