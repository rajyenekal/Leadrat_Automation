package Utilities;

import java.util.Random;

public class RandomDataUtil {
	
	public static long getPhoneNo() {
		Random random = new Random();
        long randomNumber = 1000000000L + random.nextLong(9000000000L);
		return randomNumber;
	}
	public static String getName() {
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        StringBuilder randomNameBuilder = new StringBuilder();
        Random random = new Random();

        // Ensure the first letter is a consonant to make it more name-like
        randomNameBuilder.append(consonants.charAt(random.nextInt(consonants.length())));

        for (int i = 1; i < 10; i++) {
            // Alternate between vowels and consonants
            if (i % 2 == 0) {
                randomNameBuilder.append(vowels.charAt(random.nextInt(vowels.length())));
            } else {
                randomNameBuilder.append(consonants.charAt(random.nextInt(consonants.length())));
            }
        }

        return randomNameBuilder.toString();
    }
	
	public static String getEmail(String userName) {
        String domain = getDomain(5) + ".com";
        return userName + "@" + domain;
    }

	public static String getDomain(int length) {
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        StringBuilder randomNameBuilder = new StringBuilder();
        Random random = new Random();

        // Ensure the first letter is a consonant to make it more name-like
        randomNameBuilder.append(consonants.charAt(random.nextInt(consonants.length())));

        for (int i = 1; i < length; i++) {
            // Alternate between vowels and consonants
            if (i % 2 == 0) {
                randomNameBuilder.append(vowels.charAt(random.nextInt(vowels.length())));
            } else {
                randomNameBuilder.append(consonants.charAt(random.nextInt(consonants.length())));
            }
        }

        return randomNameBuilder.toString();
    }
   
}
