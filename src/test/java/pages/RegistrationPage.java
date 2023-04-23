package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submitButton = $("#submit"),
            uploadPicture = $("#uploadPicture"),
            dateOfBirth = $("#dateOfBirthInput");


    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Установить значение для First Name")
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Установить значение для Last Name")
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Установить значение для Email")
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Установить значение для Gender")
    public RegistrationPage setGender(String value){
        gender.$(byText(value)).click();

        return this;
    }

    @Step("Установить значение для Number")
    public RegistrationPage setNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Установить значение для Birth Date")
    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirth.click();
        calendarComponent.setDate(day, month,year);

        return this;
    }

    @Step("Установить значение для Subject")
    public RegistrationPage setSubject(String value){
        subject.setValue(value).pressEnter();

        return this;
    }

    @Step("Установить значение для Hobby")
    public RegistrationPage setHobby(String value){
        hobby.$(byText(value)).click();

        return this;
    }

    @Step("Загрузить файл")
    public RegistrationPage uploadFile(File file){
        uploadPicture.uploadFile(file);

        return this;
    }

    @Step("Установить значение для Current Address")
    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    @Step("Установить значение для State")
    public RegistrationPage setState(String value){
        state.setValue(value).pressEnter();

        return this;
    }

    @Step("Установить значение для City")
    public RegistrationPage setCity(String value){
        city.setValue(value).pressEnter();

        return this;
    }

    @Step("Нажать кнопку ОК")
    public RegistrationPage clickSubmitButton(){
        submitButton.click();

        return this;
    }

    @Step("Проверить заголовок модалки")
    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    @Step("Проверить значения в таблице")
    public RegistrationPage verifyResult(String key,String value){
        registrationResultsModal.verifyResult(key,value);

        return this;
    }
}
