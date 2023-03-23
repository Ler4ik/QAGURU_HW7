import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        String firstName = "Valeriya";
        String lastName = "Kharlova";
        String userEmail = "123@mail.com";
        String userGender = "Female";
        String userNumber = "8982345789";
        String dateOfBirth = "31 December,1988";
        String subject = "Chemistry";
        String hobbies = "Sports, Reading";
        File file = new File("src/test/resources/test.xlsx");
        String fileName = "test.xlsx";
        String currentAddress = "Кутателадзе 4г";
        String stateAndCity = "NCR Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber);


        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption("December");
        $("select.react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__month").$(byText("31")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName + " " + lastName),text(userEmail),text(userGender),
                text(userNumber),text(dateOfBirth),text(subject),text(hobbies),text(fileName),
                text(currentAddress),text(stateAndCity));
    }
}
