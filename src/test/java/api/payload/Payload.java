package api.payload;

import com.github.javafaker.Faker;

public class Payload {
	
	public static String getPayload() {
		
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phNo = faker.phoneNumber().cellPhone();
        
		String body = "{\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "   \"mobile\": \""+phNo+"\",\r\n"
				+ "  \"state\": \"Rajasthan\",\r\n"
				+ "  \"city\": \"Mangalore\",\r\n"
				+ "  \"location\": \"Yelahanka 4th Phase, Yelahanka 4th Phase, Yelahanka New Town\",\r\n"
				+ "  \"budget\": \"5403192\",\r\n"
				+ "  \"notes\": \"comments\",\r\n"
				+ "  \"email\": \"\",\r\n"
				+ "  \"countryCode\": \"91\",\r\n"
				+ "  \"property\": \"Villa\",\r\n"
				+ "  \"leadExpectedBudget\": \"6000000\",\r\n"
				+ "  \"propertyType\": \"Flat\",\r\n"
				+ "  \"submittedDate\": \"28-03-18\",\r\n"
				+ "  \"submittedTime\": \"22:22:32\",\r\n"
				+ "  \"subsource\": \"\",\r\n"
				+ "  \"leadStatus\": \"Schedule Site Visit or Schedule Meeting or Booked or Booking Cancel\",\r\n"
				+ "  \"callRecordingUrl\": \"\",\r\n"
				+ "  \"leadScheduledDate\": \"28-03-18\",\r\n"
				+ "  \"leadScheduleTime\": \"22:22:32\",\r\n"
				+ "  \"bhkType\": \"Simplex/Duplex/PentHouse/Others\",\r\n"
				+ "  \"leadBookedDate\": \"28-03-18\",\r\n"
				+ "  \"leadBookedTime\": \"22:22:32\",\r\n"
				+ "  \"additionalProperties\": {\r\n"
				+ "    \"EnquiredFor\": \"Buy/Sale/Rent\",\r\n"
				+ "    \"BHKType\": \"Simplex/Duplex/PentHouse/Others\",\r\n"
				+ "    \"NoOfBHK\": \"0\",\r\n"
				+ "    \"key1\": \"value1\",\r\n"
				+ "    \"key2\": \"value1\"\r\n"
				+ "    }\r\n"
				+ "  }";
		return body;
		
	}

}
