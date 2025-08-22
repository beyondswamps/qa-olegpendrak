package reqresNoPojo;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresNoPojoTest {
    private final static String URL = "https://reqres.in/";

    @Test
    void checkAvatarsNoPojoTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        List<String> emails = jsonPath.get("data.email");
        List<String> ids = jsonPath.get("data.id");
        List<String> first_names = jsonPath.get("data.first_name");
        List<String> last_names = jsonPath.get("data.last_name");
        List<String> avatars = jsonPath.get("data.avatar");

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

        Assert.assertTrue(emails.stream().allMatch(x-> x.endsWith("@reqres.in")));

    }

    @Test
    void successUserReqNoPojoTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");

        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("id");
        String token = jsonPath.get("token");
        Assert.assertEquals(4, id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }

    @Test
    void unsuccessUserRegNoPojo() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "sydney@fife");

        Response response = given()
                .header("x-api-key", "reqres-free-v1")
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("error", equalTo("Missing password"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals("Missing password", jsonPath.get("error"));

    }
}
