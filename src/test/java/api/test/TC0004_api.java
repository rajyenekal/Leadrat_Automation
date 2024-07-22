package api.test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import api.endpoints.AddProjProp;
import io.restassured.response.Response;
import test.base.Api_Token;
import test.base.RetryAnalyzer;

public class TC0004_api extends Api_Token{
	
	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void testProject() {

        token=Api_Token.getToken();
        
        logger.info("---- Creating new Project ----");

        Response response = AddProjProp.testProject(token);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        projectUniqueId = response.jsonPath().getString("data");
        logger.info("---- New Project Created with ID Token: " + projectUniqueId +"\n");
    }

	@Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void testUnit() {

        logger.info("---- Creating new Unit ----");

        Response response = AddProjProp.testUnit(token, projectUniqueId);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        uniqueId = response.jsonPath().getString("data");
        logger.info("---- New Unit Created with ID Token: " + uniqueId +"\n");
    }

	@Test(priority = 3)
    public void testBlock() {

        logger.info("---- Creating new Block ----");

        Response response = AddProjProp.testBlock(token, projectUniqueId);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        uniqueId = response.jsonPath().getString("data");
        logger.info("---- New Block Created with ID Token: " + uniqueId + "\n");
    }


	@Test(priority = 4)
    public void testAmenity() {

        logger.info("---- Adding Amenities ----");

        Response response = AddProjProp.postAmenity(token, projectUniqueId);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        uniqueId = response.jsonPath().getString("data");
        logger.info("---- New Unit Created with ID Token: " + uniqueId + "\n");
    }


	@Test(priority = 5)
    public void testGallery() {

        logger.info("---- Adding images to project Gallery ----");

        Response response = AddProjProp.putGallery(token, projectUniqueId);
        
        uuidRegex = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$";

        response.then()
        		.log().body()
                .statusCode(200)
                .assertThat()
                .body("succeeded", is(true),
                        "data", not(emptyString()),
                        "data", matchesRegex(uuidRegex));

        uniqueId = response.jsonPath().getString("data");
        logger.info("---- Images added to project gallery with ID Token: " + uniqueId + "\n");
    }


}
