package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

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

       textBoxPage.verifyResult(generateRandom.fullName, generateRandom.userEmail, generateRandom.currentAddress);

    }


}
