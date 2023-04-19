package data;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

public class GenerateRandom {
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String fullName = faker.name().firstName() + " " + faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = faker.options().option("Female", "Male", "Other");
    public String userNumber = faker.number().digits(10);
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = faker.number().numberBetween(1940,2005) + "";
    public String day = setDay();
    public String subject =  faker.options().option("Chemistry","Hindi", "Social Studies");
    public String hobbies = faker.options().option("Sports", "Music");
    public String fileName = "test.xlsx";
    public File file = new File("src/test/resources/" + fileName);
    public String currentAddress = faker.address().streetAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = setCity(state);


    String setCity(String state){
        String city = null;
        if(state == "NCR"){
            city = faker.options().option("Gurgaon", "Delhi", "Noida");
        } else if (state == "Uttar Pradesh"){
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state == "Haryana"){
            city = faker.options().option("Karnal", "Panipat");
        } else if (state == "Rajasthan"){
            city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }

    String setDay(){
        String day = faker.number().numberBetween(1,28) + "";
        if(Integer.parseInt(day) < 10){
            day = "0" + day + "";
        }
        return day;
    }
}
