package lesson9;

import base.pojos.createUser.CreateUserRequest;
import base.pojos.createUser.CreateUserResponse;
import base.pojos.getPets.Pet;
import base.pojos.getUser.GetUserData;
import base.pojos.updateUser.UpdateUserResponse;
import com.codeborne.selenide.As;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static base.helpers.Specifications.*;
import static io.restassured.RestAssured.given;

public class PojoTest {
    public static final String BASE_URL = "https://petstore.swagger.io";

    //    @Test
    public void getUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<GetUserData> userData = given()
                .when()
                .get("users?page=2")
                .then()
                .extract().body().jsonPath().getList("data", GetUserData.class);

        Assert.assertNotNull(userData);

        for (int i = 0; i < userData.size(); i++) {
            Assert.assertTrue(userData.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(userData.get(i).getAvatar().contains(userData.get(i).getId().toString()));
        }
    }

    //    @Test
    public void createUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));
        CreateUserRequest request = new CreateUserRequest();

        request.setName("morpheus");
        request.setJob("leader");

        CreateUserResponse createUserResponse = given()
                .body(request)
                .when()
                .post("users")
                .then()
                .log().body().extract().as(CreateUserResponse.class);

        Assert.assertNotNull(createUserResponse);

        Assert.assertEquals(request.getName(), createUserResponse.getName());
        Assert.assertEquals(request.getJob(), createUserResponse.getJob());
    }

    //    @Test
    public void updateUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        CreateUserRequest requestUpdate = new CreateUserRequest("morpheus", "leader");

        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());
    }

    @Test
    public void getPetsTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        Pet[] petResponse = given()
                .when()
                .get("/v2/pet/findByStatus?status=available")
                .then()
                .extract().as(Pet[].class);

        List<Pet> petList = Arrays.asList(petResponse);

        for (Pet pet : petList) {
            Assert.assertEquals(pet.getStatus(), "available");
        }

    }
}
