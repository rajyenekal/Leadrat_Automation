package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import api.payload.Payload;
import io.restassured.http.ContentType;

public class leadCreation {
	
	
	public static Response magicBricks() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.magicBricks_key)
						.body(Payload.getPayload())
				        .when()
						.post(Routes.magicBricks_url);
			
				return response;
			
		}
	
	 public static Response housing() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.housing_key)
						.body(Payload.getPayload())
				        .when()
						.post(Routes.housing_url);
			
				return response;
			
		}
	
	
	public static Response ninetynineacres() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.ninetyNineAcres_key)
						.body(Payload.getPayload())
				        .when()
						.post(Routes.ninetyNineAcres_url);
			
				return response;
			
		}
	
	public static Response quikrHomes() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.quikrHomes_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.quikrHomes_url);
			
				return response;
			
		}
	public static Response website() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.website_key)
						.body(Payload.websitePayload())
						.when()
						.post(Routes.website_url);
			
				return response;
			
		}
	public static Response microsoftAds() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.microsoftAds_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.microsoftAds_url);
			
				return response;
			
		}
	
	public static Response estatedekho() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.estateDekho_key)
						.body(Payload.getPayload())
				        .when()
						.post(Routes.estateDekho_url);
			
				return response;
			
		}
	
     public static Response realestateIndia() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.realEstateIndia_key)
						.body(Payload.getPayload())
				        .when()
						.post(Routes.realEstateIndia_url);
			
				return response;
			
		}
	public static Response roofandFloor() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.roofandFloor_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.roofandFloor_url);
			
				return response;
			
		}
	
	public static Response googleAds() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.googleAds_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.googleAds_url);
			
				return response;
			
		}
	
	public static Response commonFloor() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.commonFloor_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.commonFloor_url);
			
				return response;
			
		}
		

}
