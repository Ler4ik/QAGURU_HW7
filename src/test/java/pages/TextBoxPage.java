package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
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

    @Step("Открыть страницу text-box")
    public TextBoxPage openPage(){
        open("/text-box");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Установить значение Full Name")
    public TextBoxPage setFullName(String value){
        fullNameInput.setValue(value);

        return this;
    }

    @Step("Установить значение Email")
    public TextBoxPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Установить значение Current Address")
    public TextBoxPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    @Step("Установить значение Permanent Address")
    public TextBoxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);

        return this;
    }

    @Step("Нажать кнопку ОК")
    public TextBoxPage clickSubmitButton(){
        submitButton.click();

        return this;
    }

    @Step("Проверить значения в таблице")
    public void verifyResult(String fullName, String userEmail, String currentAddress){
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(fullName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(currentAddress));
    }
}
