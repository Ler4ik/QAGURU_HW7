package data;

import com.github.javafaker.Faker;

public class GenerateRandom {
    static Faker faker = new Faker();

    public static String setCity(String state){
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
}
