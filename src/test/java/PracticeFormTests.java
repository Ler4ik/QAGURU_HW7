import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        String firstName = "Kharlova";
        String lastName = "Valeriya";
        String userEmail = "123@mail.com";
        String userNumber = "5-09-08";
        File file = new File("src/test/resources/test.xlsx");


        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption("December");
        $("select.react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__month").$(byText("31")).click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(file);



        sleep(4000);

    }
}
