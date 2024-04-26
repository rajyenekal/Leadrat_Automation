package api.test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import api.endpoints.addLeadAPI;
import io.restassured.response.Response;
import test.base.Api_Token;

public class TC0002_api {
    
    private static final Logger logger = LogManager.getLogger(TC0002_api.class);
    public  String token;
    public String uuidRegex;
    public String uniqueId;

    @Test
    public void addLead() {
    
        token = Api_Token.getToken();
        
        logger.info("---- Creating new Lead ----");
        
        Response response = addLeadAPI.testLead(token);

         uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

         uniqueId = response.jsonPath().getString("data");
        logger.info("---- New Lead Created with ID Token: " + uniqueId);
    }
}
