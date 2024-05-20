package api.endpoints;

import static io.restassured.RestAssured.given;

import Utilities.RandomDataUtil;
import Utilities.ReadConfigFile;
import api.payload.Payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class addLeadAPI {
	
static ReadConfigFile rcf = new ReadConfigFile();

	
	public static Response postToken() {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("tenant","demo")
				.body(Payload.tokenBody(rcf.getusernamel(), rcf.getPwd()))
				.when()
				.post(Routes.tokenUrl);
		return response;
	}
	
	public static Response testLead(String token) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.leadBody(RandomDataUtil.getranName()))
				.when()
				.post(Routes.leadUrl);
		return response;
	}
	
	public static Response testData(String token) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
                .header("Authorization", token)
				.header("tenant","demo")
				.body(Payload.dataBody(RandomDataUtil.getranName()))
				.when()
				.post(Routes.dataUrl);
		return response;
	}
	
	
	
}
