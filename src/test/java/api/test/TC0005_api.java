package api.test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import api.endpoints.AddProjProp;
import io.restassured.response.Response;
import test.base.Api_Token;

public class TC0005_api extends Api_Token{
	
	@Test(priority = 1)
    public void testProperty() {

        token=Api_Token.getToken();
        
        logger.info("---- Creating new Property ----");

        Response response = AddProjProp.addProperty(token);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data.id", not(emptyString()),
                        "data.id", matchesRegex(uuidRegex));

        propertyUniqueId = response.jsonPath().getString("data.id");
        logger.info("---- New Property Created with ID Token: " + propertyUniqueId +"\n");
    }
	
	@Test(priority = 2)
    public void moreInfo() {

        logger.info("---- Adding more info to the property ----");

        Response response = AddProjProp.testProperty(token,propertyUniqueId);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data.id", not(emptyString()),
                        "data.id", matchesRegex(uuidRegex));

        propertyUniqueId = response.jsonPath().getString("data.id");
        logger.info("----Property added with more info: " + propertyUniqueId + "\n");
    }
	
	

}
