import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        String userName = "Харлова Валерия";
        String userEmail = "123@mail.com";
        String currentAddress = "Кутателадзе 4г";
        String permanentAddress = "Кутателадзе 4а";

        open("/text-box"); //открыть https://demoqa.com/text-box
        $(".main-header").shouldHave(text("Text Box"));//проверить, что странца открылась
        $("#userName").setValue(userName);//Заполнить Full Name
        $("#userEmail").setValue(userEmail);//Заполнить Email
        $("#currentAddress").setValue(currentAddress);//Заполнить Current Address
        $("#permanentAddress").setValue(permanentAddress);//Заполнить Permanent Address
        $("#submit").click();//Нажать Submit

        //Проверить, что в output-e отображается введенная информация
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }


}
