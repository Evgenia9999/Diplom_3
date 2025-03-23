package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UsersApi {

    public String accessToken;

    public static String email = "maria999000@example.com";
    public static String password  = "password123";
    public static String name = "Мария";


    public void deleteUser() {

        UserDataHelper userLogin = new UserDataHelper(email, password);


        Response loginResponse = given()
                .header("Content-type", "application/json")
                .body(userLogin) // Передаем объект пользователя
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

        accessToken = loginResponse.then().extract().path("accessToken");

        given()
                .header("Authorization", accessToken)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .statusCode(202);
    }

    public void createUser() {

        UserDataHelper userRegister = new UserDataHelper(email, password, name);


        Response loginResponse = given()
                .header("Content-type", "application/json")
                .body(userRegister) // Передаем объект пользователя
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");


    }

}
