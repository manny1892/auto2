package ru.netology.rest;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("http://localhost:9999/api/v1")
      // Выполняемые действия
      .when()
          .get("/demo/accounts")
      // Проверки
      .then()
                .statusCode(200)
                // static import для JsonSchemaValidator.matchesJsonSchemaInClasspath
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}
