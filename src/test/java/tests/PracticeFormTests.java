package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Tags({@Tag("simple"), @Tag("smoke")})
    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(generateRandom.firstName)
                .setLastName(generateRandom.lastName)
                .setEmail(generateRandom.userEmail)
                .setGender(generateRandom.userGender)
                .setNumber(generateRandom.userNumber)
                .setBirthDate(generateRandom.day,generateRandom.month,generateRandom.year)
                .setSubject(generateRandom.subject)
                .setHobby(generateRandom.hobbies)
                .uploadFile(generateRandom.file)
                .setCurrentAddress(generateRandom.currentAddress)
                .setState(generateRandom.state)
                .setCity(generateRandom.city)
                .clickSubmitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name",generateRandom.firstName + " " +generateRandom.lastName)
                .verifyResult("Student Email", generateRandom.userEmail)
                .verifyResult("Gender",generateRandom.userGender)
                .verifyResult("Mobile", generateRandom.userNumber)
                .verifyResult("Date of Birth",generateRandom.day + " " + generateRandom.month + "," + generateRandom.year)
                .verifyResult("Subjects", generateRandom.subject)
                .verifyResult("Hobbies", generateRandom.hobbies)
                .verifyResult("Picture", generateRandom.fileName)
                .verifyResult("Address",generateRandom.currentAddress)
                .verifyResult("State and City",generateRandom.state + " " + generateRandom.city);
    }
}
