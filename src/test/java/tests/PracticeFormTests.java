package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

public class PracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("ru"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = "Female";
        String userNumber = faker.number().digits(10);
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
