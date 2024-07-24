package api.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.testng.annotations.Test;
import api.endpoints.leadCreation;
import io.restassured.response.Response;
import test.base.Api_Token;
import test.base.RetryAnalyzer;

public class TC0001_api extends Api_Token {

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_MagicBricks_Lead() {
        try {
            logger.info("---- Creating MagicBricks Lead ----");

            Response response = leadCreation.magicBricks();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- MagicBricks Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during MagicBricks Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_Housing_Lead() {
        try {
            logger.info("---- Creating Housing Lead ----");

            Response response = leadCreation.housing();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- Housing Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during Housing Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_NinetyNineAcres_Lead() {
        try {
            logger.info("---- Creating NinetyNineAcres Lead ----");

            Response response = leadCreation.ninetynineacres();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- NinetyNineAcres Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during NinetyNineAcres Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_quikrHomes_Lead() {
        try {
            logger.info("---- Creating QuikrHomes Lead ----");

            Response response = leadCreation.quikrHomes();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- QuikrHomes Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during QuikrHomes Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_Website_Lead() {
        try {
            logger.info("---- Creating Website Lead ----");

            Response response = leadCreation.website();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- Website Lead Created ----"+"\n");

        } catch (AssertionError assertionError) {
            logger.error("Assertion error occurred during Website Lead Creation:", assertionError);
            throw assertionError;
        } catch (Exception e) {
            logger.error("An error occurred during Website Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_MicrosoftAds_Lead() {
        try {
            logger.info("---- Creating MicrosoftAds Lead ----");

            Response response = leadCreation.microsoftAds();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- MicrosoftAds Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during MicrosoftAds Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_EstateDekho_Lead() {
        try {
            logger.info("---- Creating EstateDekho Lead ----");

            Response response = leadCreation.estatedekho();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- EstateDekho Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during EstateDekho Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = false, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_RealestaeIndia_Lead() {
        try {
            logger.info("---- Creating RealEstaeIndia Lead ----");

            Response response = leadCreation.realestateIndia();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- RealEstaeIndia Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during RealEstaeIndia Lead Creation:", e);
            throw e;
        }
    }


    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_RoofFloor_Lead() {
        try {
            logger.info("---- Creating RoofandFloor Lead ----");

            Response response = leadCreation.roofandFloor();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- RoofandFloor Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during RoofandFloor Lead Creation", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_GoogleAds_Lead() {
        try {
            logger.info("---- Creating GoogleAds Lead ----");

            Response response = leadCreation.googleAds();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- GoogleAds Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during GoogleAds Lead Creation:", e);
            throw e;
        }
    }

    @Test(enabled = true, retryAnalyzer = RetryAnalyzer.class)
    public void Creating_CommonFloor_Lead() {
        try {
            logger.info("---- Creating commonFloor Lead ----");

            Response response = leadCreation.commonFloor();

            response.then()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("succeeded", equalTo(true),
                    "message", nullValue(),
                    "errors", nullValue(),
                    "data", equalTo(true));

            logger.info("---- commonFloor Lead Created ----"+"\n");

        } catch (Exception e) {
            logger.error("An error occurred during commonFloor Lead Creation:", e);
            throw e;
        }
    }
}
