package pages;

import com.codeborne.selenide.SelenideElement;
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


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirth.click();
        calendarComponent.setDate(day, month,year);

        return this;
    }

    public RegistrationPage setSubject(String value){
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value){
        hobby.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadFile(File file){
        uploadPicture.uploadFile(file);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        state.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value){
        city.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage clickSubmitButton(){
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key,String value){
        registrationResultsModal.verifyResult(key,value);

        return this;
    }
}
