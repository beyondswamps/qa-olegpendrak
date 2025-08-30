package restassured;

import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarIdTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);


        users.forEach(userData -> Assert.assertTrue(userData.getAvatar().contains(userData.getId().toString())));

        Assert.assertTrue(users.stream().allMatch(userData -> userData.getEmail().contains("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());

        List<String> ids = users.stream().map(userData -> userData.getId().toString()).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void successRegTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReq =
                given()
                    .header("x-api-key", "reqres-free-v1")
                    .body(user)
                .when()
                    .post("api/register")
                .then()
                    .log().all()
                    .extract().as(SuccessReg.class);

        Assert.assertNotNull(successReq.getId());
        Assert.assertNotNull(successReq.getToken());
        Assert.assertEquals(id, successReq.getId());
        Assert.assertEquals(token, successReq.getToken());

    }

    @Test
    public void unSuccessRegTest() throws InterruptedException {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK400());

        Register user = new Register("sydney@fife", "");
        RequestSpecification requestSpecification = given();
        UnSuccessReg unSuccessReg = given()
                .header("x-api-key", "reqres-free-v1")
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);

        Assert.assertEquals("Missing password", unSuccessReg.getError());

    }

    @Test
    public void ascendingYearsTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        List<Integer> years = given()
                .when()
                .get("api/unknown/")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorData.class)
                .stream()
                .map(ColorData::getYear)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> sortedYears = years.stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < years.size(); i++) {
            Assert.assertEquals(years.get(i), sortedYears.get(i));
        }

        Assert.assertEquals(years, sortedYears);

    }

    @Test
    public void deleteUserTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL),
                Specifications.responseSpecUnique(204));

        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    void sameTimeLocalAndServerTest() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .header("x-api-key", "reqres-free-v1")
                .body(user)
                .when()
                .put("api/users/2")
                .then()
                .log().all()
                .extract().as(UserTimeResponse.class);

        String regex = "\\.[0-9]+Z";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");

        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
    }
}
