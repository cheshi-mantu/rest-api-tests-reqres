package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class ReqResInApiTests extends TestBase {

    @Test
    @DisplayName("Checking 3rd record in the JSON response is " + CREATED_USER)
    void parseJsonParseJsonDeeper() {
        String email;
        RestAssured.baseURI = baseUrl;
            given()
                    .log().all();
        System.out.println("Opening " + baseURI);
            email = get("/api/users?page=2")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .path("data[2].email");
        System.out.println("Extracted email is " + email);
            assertThat(email, is(CREATED_USER));
    }

}

