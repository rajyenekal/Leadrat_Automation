package api.test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import api.endpoints.addLeadAPI;
import io.restassured.response.Response;
import test.base.Api_Token;

public class TC0003_api extends Api_Token {
	
    @Test
    public void adddata() {

        token=Api_Token.getToken();
        
        logger.info("---- Creating new Data ----");

        Response response = addLeadAPI.testData(token);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        uniqueId = response.jsonPath().getString("data");
        logger.info("---- New Data Created with ID Token: " + uniqueId + "\n");
    }

}
