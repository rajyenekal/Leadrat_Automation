package Utilities;

import java.util.Calendar;
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
   
	public static String getranName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 3) {
            StackTraceElement caller = stackTrace[2]; // Index 2 is the caller of this method
            String methodName = caller.getMethodName();

            Calendar currentDate = Calendar.getInstance();
            int year = currentDate.get(Calendar.YEAR);
            int month = currentDate.get(Calendar.MONTH) + 1; // Adding 1 because months are zero-based
            int day = currentDate.get(Calendar.DAY_OF_MONTH);
            int hour = currentDate.get(Calendar.HOUR_OF_DAY);
            int minute = currentDate.get(Calendar.MINUTE);
            int second = currentDate.get(Calendar.SECOND);

            String yearShort = Integer.toString(year).substring(2); // Last two digits of the year
            String monthNum = String.format("%02d", month);
            String dayNum = String.format("%02d", day);

            hour = (hour % 12 == 0) ? 12 : hour % 12;

            String hour12 = String.format("%02d", hour);
            String minuteNum = String.format("%02d", minute);
            String secondNum = String.format("%02d", second);

            String dateFormat = dayNum + "/" + monthNum + "/" + yearShort;

            return methodName + "_" + hour12 + ':' + minuteNum + ':' + secondNum + " _" + dateFormat;
        }
        return "Unknown";
    }

	
//	public static String getMethodName() {
//        // Use reflection to get the name of the calling method
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        if (stackTrace.length >= 3) {
//            return stackTrace[2].getMethodName(); // Index 2 is the caller of this method
//        }
//        return "Unknown";
//    }
}
