package api.payload;

import com.github.javafaker.Faker;

public class Payload {
	static Faker faker = new Faker();

	public static String getPayload(String leadName) {
		
        String phNo = "5" + faker.number().digits(9);
        
		String body = "{\r\n"
				+ "  \"name\": \""+leadName+"\",\r\n"
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
	
	
	public static String websitePayload(String leadName) {

        String phNo = "5" + faker.number().digits(9);
        
        String body = "[\r\n"
                + "{\r\n"
                + "  \"name\": \""+leadName+"\",\r\n"
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
                + "  }\r\n"
                + "]";

		return body;
		
	}
	
	public static String tokenBody(String userName,String pwd) {
		String body ="{\r\n"
				+ "  \"username\": \""+userName+"\",\r\n"
				+ "  \"password\": \""+pwd+"\"\r\n"
				+ "}";
		
		return body;
		
	}
	
	public static String leadBody(String name) {

        String phNo = "5" + faker.number().digits(9);
        
		String body="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"contactNo\": \""+phNo+"\",\r\n"
				+ "    \"alternateContactNo\": \"+917098765423\",\r\n"
				+ "    \"email\": \"testing@gmail.com\",\r\n"
				+ "    \"leadSource\": \"Direct\",\r\n"
				+ "    \"subSource\": null,\r\n"
				+ "    \"lowerBudget\": 800000,\r\n"
				+ "    \"currency\": null,\r\n"
				+ "    \"upperBudget\": 899998,\r\n"
				+ "    \"assignTo\": \"2844c2dd-23ee-4f49-8221-6f27a95516f4\",\r\n"
				+ "    \"secondaryAssignTo\": \"5007a9f2-f747-4244-8d1b-a6f33c2d804d\",\r\n"
				+ "    \"locationId\": {\r\n"
				+ "        \"id\": \"2d77c6a1-1753-40c7-b526-a4db84cf27fe\",\r\n"
				+ "        \"location\": \", Bangaluru, HSR, Karnataka, India\",\r\n"
				+ "        \"placeId\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"enquiredLocality\": null,\r\n"
				+ "    \"enquiredCity\": null,\r\n"
				+ "    \"enquiredState\": null,\r\n"
				+ "    \"enquiredFor\": \"Buy\",\r\n"
				+ "    \"propertyTypeId\": \"Residential\",\r\n"
				+ "    \"propSubType\": \"Independent House\",\r\n"
				+ "    \"noOfBHK\": \"2\",\r\n"
				+ "    \"bhkType\": \"Duplex\",\r\n"
				+ "    \"notes\": \"Lead Added through \",\r\n"
				+ "    \"projectsList\": [\r\n"
				+ "        \"RajProject\"\r\n"
				+ "    ],\r\n"
				+ "    \"propertiesList\": [\r\n"
				+ "        \"City centre \"\r\n"
				+ "    ],\r\n"
				+ "    \"agencyName\": \"BALAJI REALTY\",\r\n"
				+ "    \"referralName\": \"\",\r\n"
				+ "    \"referralContactNo\": \"\",\r\n"
				+ "    \"companyName\": \"LeadRat\",\r\n"
				+ "    \"designation\": \"Quality Analyst\",\r\n"
				+ "    \"possessionDate\": \"2024-04-04T18:30:00.000Z\",\r\n"
				+ "    \"carpetArea\": 30000,\r\n"
				+ "    \"carpetAreaUnitId\": \"fd8de64b-47c4-4083-84a5-571f746e6c87\",\r\n"
				+ "    \"closingManager\": null,\r\n"
				+ "    \"sourcingManager\": null,\r\n"
				+ "    \"profession\": 3,\r\n"
				+ "    \"address\": {\r\n"
				+ "        \"subLocality\": null,\r\n"
				+ "        \"city\": null,\r\n"
				+ "        \"state\": null\r\n"
				+ "    },\r\n"
				+ "    \"customerLocationId\": null,\r\n"
				+ "    \"customerLocality\": null,\r\n"
				+ "    \"customerCity\": null,\r\n"
				+ "    \"customerState\": null,\r\n"
				+ "    \"channelPartnerList\": null,\r\n"
				+ "    \"channelPartnerExecutiveName\": null,\r\n"
				+ "    \"channelPartnerContactNo\": \"\",\r\n"
				+ "    \"secondaryUserId\": \"5007a9f2-f747-4244-8d1b-a6f33c2d804d\",\r\n"
				+ "    \"enquiry\": {\r\n"
				+ "        \"enquiredFor\": 1,\r\n"
				+ "        \"leadSource\": 0,\r\n"
				+ "        \"subSource\": null,\r\n"
				+ "        \"lowerBudget\": 700000,\r\n"
				+ "        \"upperBudget\": 899998,\r\n"
				+ "        \"currency\": null,\r\n"
				+ "        \"noOfBHK\": \"2\",\r\n"
				+ "        \"bhkType\": 2,\r\n"
				+ "        \"address\": {\r\n"
				+ "            \"locationId\": \"2d77c6a1-1753-40c7-b526-a4db84cf27fe\",\r\n"
				+ "            \"placeId\": \"\",\r\n"
				+ "            \"subLocality\": null,\r\n"
				+ "            \"city\": null,\r\n"
				+ "            \"state\": null\r\n"
				+ "        },\r\n"
				+ "        \"possessionDate\": \"2024-04-05T00:00:00.000Z\",\r\n"
				+ "        \"carpetArea\": 30000,\r\n"
				+ "        \"carpetAreaUnitId\": \"fd8de64b-47c4-4083-84a5-571f746e6c87\",\r\n"
				+ "        \"conversionFactor\": 0.092903,\r\n"
				+ "        \"propertyTypeId\": \"7d583139-e87d-4d2e-9d04-3bffebf82942\"\r\n"
				+ "    }\r\n"
				+ "}";
		return body;
		
	}
	
	public static String dataBody(String name) {

        String phNo = "5" + faker.number().digits(9);
        
        String body = "{\r\n"
        		+ "    \"name\": \""+name+"\",\r\n"
        		+ "    \"contactNo\": \""+phNo+"\",\r\n"
        		+ "    \"alternateContactNo\": \"+918765432109\",\r\n"
        		+ "    \"email\": \"test^@gmail.com\",\r\n"
        		+ "    \"notes\": \"Testing Data\",\r\n"
        		+ "    \"assignTo\": \"2844c2dd-23ee-4f49-8221-6f27a95516f4\",\r\n"
        		+ "    \"assignedFrom\": \"2844c2dd-23ee-4f49-8221-6f27a95516f4\",\r\n"
        		+ "    \"agencyName\": \"360 Realtors\",\r\n"
        		+ "    \"companyName\": \"Leadrat\",\r\n"
        		+ "    \"designation\": \"Quality Analyst\",\r\n"
        		+ "    \"possesionDate\": \"2024-04-08T00:00:00.000Z\",\r\n"
        		+ "    \"profession\": 3,\r\n"
        		+ "    \"closingManager\": \"6114b0d1-ec42-45cf-96c7-cac3d32193e6\",\r\n"
        		+ "    \"sourcingManager\": \"5007a9f2-f747-4244-8d1b-a6f33c2d804d\",\r\n"
        		+ "    \"addressDto\": {\r\n"
        		+ "        \"locationId\": \"00000000-0000-0000-0000-000000000000\",\r\n"
        		+ "        \"placeId\": \"ChIJZ83YgrIVrjsR-N-HEV3Giwg\",\r\n"
        		+ "        \"subLocality\": null,\r\n"
        		+ "        \"city\": null,\r\n"
        		+ "        \"state\": null\r\n"
        		+ "    },\r\n"
        		+ "    \"channelPartnerList\": [\r\n"
        		+ "        \"Sufiyan Channel Partner\"\r\n"
        		+ "    ],\r\n"
        		+ "    \"executiveName\": null,\r\n"
        		+ "    \"executiveContactNo\": \"+918765432151\",\r\n"
        		+ "    \"enquiry\": {\r\n"
        		+ "        \"enquiryType\": 1,\r\n"
        		+ "        \"subSource\": \"office\",\r\n"
        		+ "        \"lowerBudget\": 600000,\r\n"
        		+ "        \"upperBudget\": 799999,\r\n"
        		+ "        \"currency\": null,\r\n"
        		+ "        \"noOfBHKs\": 1.5,\r\n"
        		+ "        \"bhkType\": 2,\r\n"
        		+ "        \"address\": {\r\n"
        		+ "            \"locationId\": \"2d77c6a1-1753-40c7-b526-a4db84cf27fe\",\r\n"
        		+ "            \"placeId\": \"\",\r\n"
        		+ "            \"subLocality\": null,\r\n"
        		+ "            \"city\": null,\r\n"
        		+ "            \"state\": null\r\n"
        		+ "        },\r\n"
        		+ "        \"possessionDate\": \"2024-04-08T00:00:00.000Z\",\r\n"
        		+ "        \"carpetArea\": 6000,\r\n"
        		+ "        \"carpetAreaUnitId\": \"fd8de64b-47c4-4083-84a5-571f746e6c87\",\r\n"
        		+ "        \"conversionFactor\": 0.092903,\r\n"
        		+ "        \"propertyTypeId\": \"8d178b31-8008-4e19-8eeb-5189f7578044\",\r\n"
        		+ "        \"prospectSourceId\": \"a849000a-ed4f-4ac2-9c44-26a7b49d8519\"\r\n"
        		+ "    },\r\n"
        		+ "    \"propertiesList\": [\r\n"
        		+ "        \" budget 1.5cr.\"\r\n"
        		+ "    ],\r\n"
        		+ "    \"projectsList\": [\r\n"
        		+ "        \" Mani Casadona\"\r\n"
        		+ "    ]\r\n"
        		+ "}";
		return body;
        
	}

}
