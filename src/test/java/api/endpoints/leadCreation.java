package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import api.payload.Payload;
import io.restassured.http.ContentType;

public class leadCreation {
	
	
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
	
	public static Response roofandFloor() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.housing_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.roofandFloor_url);
			
				return response;
			
		}
	
	public static Response microsoftAds() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.housing_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.microsoftAds_url);
			
				return response;
			
		}
	
	public static Response NinetyNineAcres() {
		Response response= given()
				
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("API-Key",Routes.housing_key)
						.body(Payload.getPayload())
						.when()
						.post(Routes.ninetyNineAcres_url);
			
				return response;
			
		}

}
