package utils;

import java.util.Random;

public class Helper {

    public static String generateRandomEmail(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + getRandomNumber() + "@testdata.com";
    }

    public static String getRandomNumber() {
        return String.valueOf(new Random().nextInt(10000));
    }

}
