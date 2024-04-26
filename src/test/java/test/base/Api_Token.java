package test.base;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.endpoints.addLeadAPI;
import io.restassured.response.Response;

public class Api_Token {
	
	 protected static final Logger logger = LogManager.getLogger(Api_Token.class);
	 protected String token;
	 protected String uuidRegex;
	 protected String uniqueId;
	 protected static String idToken;
	 protected static String BearerToken;

	
	public static String getToken() {
        logger.info("---- Generating Bearer Token ----");

        Response response = addLeadAPI.postToken();

        response.then()
                .statusCode(200)
                .assertThat()
                .body("data.idToken", not(emptyString()),
                        "data.accessToken", not(emptyString()));

         idToken = response.jsonPath().getString("data.idToken");
         BearerToken = "Bearer " + idToken;
        logger.info("---- Bearer Token Generated : "+BearerToken+"----");
        return BearerToken;
    }

}
