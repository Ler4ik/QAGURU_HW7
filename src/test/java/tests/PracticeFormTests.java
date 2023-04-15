package tests;

import com.github.javafaker.Faker;
import data.GenerateRandom;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

@Tag("simple")
public class PracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("ru"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = faker.options().option("Female", "Male", "Other");
        String userNumber = faker.number().digits(10);
        String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String year = faker.number().numberBetween(1940,2005) + "";
        String day = faker.number().numberBetween(10,28) + "";
        String subject =  faker.options().option("Chemistry","Hindi", "Social Studies", "Data Science");
        String hobbies = faker.options().option("Sports", "Music");
        String fileName = "test.xlsx";
        File file = new File("src/test/resources/" + fileName);
        String currentAddress = faker.address().streetAddress();
        String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        String city = GenerateRandom.setCity(state);

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
