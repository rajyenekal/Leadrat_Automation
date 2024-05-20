package api.endpoints;

import static io.restassured.RestAssured.given;

import Utilities.RandomDataUtil;
import api.payload.Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjProp {
	
	public static Response testProject(String token) {
		
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.projectBody(RandomDataUtil.getranName()))
				.when()
				.post(Routes.projectUrl);
		return response;
		
	}
	
	public static Response testUnit(String token,String projectId) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.unitBody(RandomDataUtil.getranName(),projectId))
				.when()
				.post(Routes.unitUrl);
		return response;
	}
	
	public static Response testBlock(String token,String projectId) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.blockBody(RandomDataUtil.getranName(), projectId))
				.when()
				.post(Routes.blockUrl);
		return response;
	}

	public static Response postAmenity(String token,String projectId) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.amenityBody(projectId))
				.when()
				.post(Routes.ameniyUrl);
		return response;
	}
	
	public static Response putGallery(String token,String projectId) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.galleryBody(projectId))
				.when()
				.put(Routes.galleryUrl);
		return response;
	}

	public static Response addProperty(String token) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.propertyBody(RandomDataUtil.getranName()))
				.when()
				.post(Routes.propertyUrl);
		return response;
	}
	
	public static Response testProperty(String token,String propId) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.moreInfo(RandomDataUtil.getranName(),propId))
				.when()
				.put(Routes.propertyUrl+"/"+propId);
		return response;
	}
	
	
	
}
