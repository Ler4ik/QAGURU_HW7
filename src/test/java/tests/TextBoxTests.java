package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Tag("simple")
    @Test
    void fillFormTest(){
       textBoxPage
               .openPage()
               .setFullName(generateRandom.fullName)
               .setEmail(generateRandom.userEmail)
               .setCurrentAddress(generateRandom.currentAddress)
               .setPermanentAddress(generateRandom.currentAddress)
               .clickSubmitButton();

        //Проверить, что в output-e отображается введенная информация
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(generateRandom.fullName));
        $("#output #email").shouldHave(text(generateRandom.userEmail));
        $("#output #currentAddress").shouldHave(text(generateRandom.currentAddress));
        $("#output #permanentAddress").shouldHave(text(generateRandom.currentAddress));
    }


}
