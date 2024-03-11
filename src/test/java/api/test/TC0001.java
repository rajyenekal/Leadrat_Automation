package api.test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import api.endpoints.leadCreation;
import io.restassured.response.Response;

public class TC0001 {
	
    private static final Logger logger = LogManager.getLogger(TC0001.class);

    @Test
    public void postHousing() {
        try {
            logger.info("---- Creating Housing Lead ----");

            Response response = leadCreation.housing();

            response.then()
            .statusCode(200)
            .log().all()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- Housing Lead Created ----");
            
        } catch (Exception e) {
            logger.error("An error occurred during test execution:", e);
            throw e;
        }
    }
    
    
    @Test
    public void postRoofFloor() {
        try {
            logger.info("---- Creating RoofandFloor Lead ----");

            Response response = leadCreation.roofandFloor();

            response.then()
            .statusCode(200)
            .log().all()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- RoofandFloor Lead Created ----");
            
        } catch (Exception e) {
            logger.error("An error occurred during test execution:", e);
            throw e;
        }
    }
    
    @Test
    public void postmicrosoftAds() {
        try {
            logger.info("---- Creating MicrosoftAds Lead ----");

            Response response = leadCreation.microsoftAds();

            response.then()
            .statusCode(200)
            .log().all()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- MicrosoftAds Lead Created ----");
            
        } catch (Exception e) {
            logger.error("An error occurred during test execution:", e);
            throw e;
        }
    }
    
    @Test
    public void NinetyNineAcres() {
        try {
            logger.info("---- Creating NinetyNineAcres Lead ----");

            Response response = leadCreation.NinetyNineAcres();

            response.then()
            .statusCode(200)
            .log().all()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- NinetyNineAcres Lead Created ----");
            
        } catch (Exception e) {
            logger.error("An error occurred during test execution:", e);
            throw e;
        }
    }

}
