package Pages;

import com.github.javafaker.Faker;

public class FakerHelper {
    public String generateUserName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
}
