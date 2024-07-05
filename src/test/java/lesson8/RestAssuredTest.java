package lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTest {
    public static final String BASE_URL = "https://reqres.in/api/";

    @Test
    public void getTest() {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//
//        System.out.println(response.asString());
//
//        int statusCode = response.statusCode();
//
//        Assert.assertEquals(statusCode, 200);
//
//        given()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200).log().body()
//                .body("data.id[0]", equalTo(7));

        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200).log().body()
                .body("total", equalTo(12));

        Response response = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "users?page=2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("data.first_name[2]"), "Tobias");

    }

    @Test
    public void postTest() {
        Map request = new HashMap();

        request.put("name", "Marian");
        request.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post(BASE_URL + "users")
                .then()
                .statusCode(201).log().body();
    }
    @Test
    public void putTest(){
        Map request = new HashMap();

        request.put("name", "Marian");
        request.put("job", "teacher");

        given()
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .put(BASE_URL + "users/343")
                .then()
                .statusCode(200).log().body();
    }
    @Test
    public void deleteTest(){
        given()
                .delete(BASE_URL + "users/2")
                .then()
                .statusCode(204).log().all();
    }
}
