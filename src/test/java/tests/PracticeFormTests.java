package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = "Valeriya";
        String lastName = "Kharlova";
        String userEmail = "123@mail.com";
        String userGender = "Female";
        String userNumber = "8982345789";
        String day = "31";
        String month = "December";
        String year = "1988";
        String subject = "Chemistry";
        String hobbies = "Sports";
        String fileName = "test.xlsx";
        File file = new File("src/test/resources/" + fileName);
        String currentAddress = "Кутателадзе 4г";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(day,month,year)
                .setSubject(subject)
                .setHobby(hobbies)
                .uploadFile(file)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name",firstName + " " +lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender",userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth",day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", fileName)
                .verifyResult("Address",currentAddress)
                .verifyResult("State and City",state + " " + city);
    }
}
