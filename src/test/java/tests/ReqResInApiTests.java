package tests;

import helpers.AttachmentsHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ReqResInApiTests extends TestBase {

    @Test
    @DisplayName("Checking 3rd record in the JSON response is " + CREATED_USER)
    void parseJsonParseJsonDeeper() {
        String email;
        RestAssured.baseURI = baseUrl;
            given()
                    .log().all();

            email = get("/api/users?page=2")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .path("data[2].email");
            assertThat(email, is(CREATED_USER));
    }

}

