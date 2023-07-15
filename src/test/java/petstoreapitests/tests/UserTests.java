package petstoreapitests.tests;

import petstoreapitests.helpers.GenerateTestData;
import petstoreapitests.models.CreateUserRequest;
import petstoreapitests.models.CreateUserResponse;
import petstoreapitests.models.GetUserByUserNameNegativeResponse;
import petstoreapitests.models.GetUserByUserNamePositiveResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import petstoreapitests.servicemethods.ServiceMethodsForPetstoreTests;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Petstore")
@Tags({@Tag("API"), @Tag("Users")})
@DisplayName("Тестирование методов управления пользователями сервиса Petstore")
public class UserTests {

    GenerateTestData generateTestData = new GenerateTestData();
    ServiceMethodsForPetstoreTests serviceMethodsForPetstoreTests = new ServiceMethodsForPetstoreTests();
    @Test
    @Severity(BLOCKER)
    @DisplayName("Позитивный сценарий создания пользователя")
    void createUserTest() {

        int id = generateTestData.getRandomId();
        String userName = generateTestData.getRandomUserName();
        String firstName = generateTestData.getRandomFirstName();
        String lastName = generateTestData.getRandomLastName();
        String email = generateTestData.getRandomEmail();
        String password = generateTestData.getRandomPass();
        String phone = generateTestData.getRandomPhoneNumber(11);
        int userStatus = generateTestData.getRandomInt(0, 5);

        CreateUserRequest requestBody = CreateUserRequest.builder().id(id).username(userName).firstName(firstName).lastName(lastName).email(email).password(password).phone(phone).userStatus(userStatus).build();
        CreateUserResponse response =
                step("Отправка валидного POST запроса на создание пользователя", () ->
                        serviceMethodsForPetstoreTests.createUser(requestBody));

        step("Проверка тела ответа", () ->
            Assertions.assertAll( () -> {
                assertThat(response.getCode()).isEqualTo(200);
                assertThat(response.getType()).isEqualTo("unknown");
                assertThat(response.getMessage()).isEqualTo(String.valueOf(id));
            })
        );
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Позитивный сценарий получения пользователя")
    void getUserByUserNamePositiveTest() {

        int id = generateTestData.getRandomId();
        String userName = generateTestData.getRandomUserName();
        String firstName = generateTestData.getRandomFirstName();
        String lastName = generateTestData.getRandomLastName();
        String email = generateTestData.getRandomEmail();
        String password = generateTestData.getRandomPass();
        String phone = generateTestData.getRandomPhoneNumber(11);
        int userStatus = generateTestData.getRandomInt(0, 5);

        CreateUserRequest requestBody = CreateUserRequest.builder().id(id).username(userName).firstName(firstName).lastName(lastName).email(email).password(password).phone(phone).userStatus(userStatus).build();
        step("Отправка валидного POST запроса на создание пользователя", () ->
                serviceMethodsForPetstoreTests.createUser(requestBody));
        GetUserByUserNamePositiveResponse response =
                step("Отправка валидного GET запроса на получение существующего пользователя", () ->
                        serviceMethodsForPetstoreTests.getExistingUserByUserName(userName));
        step("Проверка тела ответа", () ->

            Assertions.assertAll(() -> {
                assertThat(response.getId()).isEqualTo(id);
                assertThat(response.getUsername()).isEqualTo(userName);
                assertThat(response.getFirstName()).isEqualTo(firstName);
                assertThat(response.getLastName()).isEqualTo(lastName);
                assertThat(response.getEmail()).isEqualTo(email);
                assertThat(response.getPassword()).isEqualTo(password);
                assertThat(response.getPhone()).isEqualTo(phone);
                assertThat(response.getUserStatus()).isEqualTo(userStatus);
            })
        );
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Негативный сценарий получения пользователя по несуществующему имени пользователя")
    void getUserByUserNameNegativeTest() {

        String userName = generateTestData.getRandomUserName();
        String type = "error";
        String message = "User not found";
        GetUserByUserNameNegativeResponse negativeResponse =
                step("Отправка валидного GET запроса на получение несуществующего пользователя", () ->
                        serviceMethodsForPetstoreTests.getNotExistingUserByUserName(userName));

        step("Проверка тела ответа", () ->

            Assertions.assertAll(() -> {
                assertThat(negativeResponse.getCode()).isEqualTo(1);
                assertThat(negativeResponse.getType()).isEqualTo(type);
                assertThat(negativeResponse.getMessage()).isEqualTo(message);
            })
        );
    }
}


