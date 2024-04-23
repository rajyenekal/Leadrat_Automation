package api.test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import api.endpoints.leadCreation;
import io.restassured.response.Response;

public class TC0001_api {
	
    private static final Logger logger = LogManager.getLogger(TC0001_api.class);
    
    
    @Test(enabled = true)
    public void magicBricks() {
        try {
            logger.info("---- Creating MagicBricks Lead ----");

            Response response = leadCreation.magicBricks();

            response.then()
            .statusCode(200)
            .log().all()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- MagicBricks Lead Created ----");
            
        } catch (Exception e) {
            logger.error("An error occurred during MagicBricks Lead Creation:", e);
            throw e;
        }
}


	    @Test(enabled = true)
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
	            logger.error("An error occurred during Housing Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    
	    @Test(enabled = true)
	    public void NinetyNineAcres() {
	        try {
	            logger.info("---- Creating NinetyNineAcres Lead ----");
	
	            Response response = leadCreation.ninetynineacres();
	
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
	            logger.error("An error occurred during NinetyNineAcres Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    @Test(enabled = true)
	    public void quikrHomes() {
	        try {
	            logger.info("---- Creating QuikrHomes Lead ----");
	
	            Response response = leadCreation.quikrHomes();
	
	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));
	
	            logger.info("---- QuikrHomes Lead Created ----");
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during QuikrHomes Lead Creation:", e);
	            throw e;
	       }
	    }
	    
	    @Test(enabled = true)
	    public void website() {
	        try {
	            logger.info("---- Creating Website Lead ----");

	            Response response = leadCreation.website();

	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));

	            logger.info("---- Website Lead Created ----");
	            
	        } catch (AssertionError assertionError) {
	            logger.error("Assertion error occurred during Website Lead Creation:", assertionError);
	            throw assertionError;
	        } catch (Exception e) {
	            logger.error("An error occurred during Website Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    @Test(enabled = true)
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
	            logger.error("An error occurred during MicrosoftAds Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    @Test(enabled = true)
	    public void estateDekho() {
	        try {
	            logger.info("---- Creating EstateDekho Lead ----");
	
	            Response response = leadCreation.estatedekho();
	
	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));
	
	            logger.info("---- EstateDekho Lead Created ----");
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during EstateDekho Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    @Test(enabled = false)
	    public void realestaeIndia() {
	        try {
	            logger.info("---- Creating RealEstaeIndia Lead ----");
	
	            Response response = leadCreation.estatedekho();
	
	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));
	
	            logger.info("---- RealEstaeIndia Lead Created ----");
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during RealEstaeIndia Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    @Test(enabled = true)
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
	            logger.error("An error occurred during RoofandFloor Lead Creation", e);
	            throw e;
	        }
	    }
	    
	    
	    
	    @Test(enabled = true)
	    public void googleAds() {
	        try {
	            logger.info("---- Creating GoogleAds Lead ----");
	
	            Response response = leadCreation.googleAds();
	
	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));
	
	            logger.info("---- GoogleAds Lead Created ----");
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during GoogleAds Lead Creation:", e);
	            throw e;
	        }
	    }
	    
	    
	    @Test(enabled = true)
	    public void commonFloor() {
	        try {
	            logger.info("---- Creating commonFloor Lead ----");
	
	            Response response = leadCreation.commonFloor();
	
	            response.then()
	            .statusCode(200)
	            .log().all()
	            .assertThat()
	            .body("succeeded", equalTo(true),
	                    "message", nullValue(),
	                    "errors", nullValue(),
	                    "data", equalTo(true));
	
	            logger.info("---- commonFloor Lead Created ----");
	            
	        } catch (Exception e) {
	            logger.error("An error occurred during commonFloor Lead Creation:", e);
	            throw e;
	        }
	    }
	
	   
    
}