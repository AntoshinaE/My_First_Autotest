import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Тесты аутентификации на странице ChatGPTLogin")
public class SecondLoginTests {

        @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        System.out.println("=== НАЧАЛО ВСЕХ ТЕСТОВ ===");
    }
    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println(" " + testInfo.getDisplayName() + " - начали выполнение.");
        open("https://slqa.ru/cases/ChatGPTLogin/");
        getWebDriver().manage().window().maximize();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=== ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ ===");
    }

       @ParameterizedTest(name = "01. Успешный вход, #{index}, username: {0}")
    @ValueSource(strings = {
            "standard_user",
            "problem_user",
            "performance_glitch_user",
            "error_user",
            "visual_user"
    })
    @DisplayName("01. Успешный вход по кнопке Login")
    void test01_success_login_button(String username) {
            $("#username").sendKeys(username);
        $("#password").sendKeys("secret_sauce");
        $("#loginButton").click();
        $("#message")
                .shouldHave(text("Вход в систему выполнен успешно! Загрузка..."))
                .shouldBe(visible)
                .shouldBe(cssClass("success"));
             $("#greeting")
                .shouldHave(text("Welcome, " + username + "!"))
                .shouldBe(visible);
    }
       @Test
    @Order(1)
    @DisplayName("02. Неправильный пароль → ошибка")
    void test02_error_wrong_password() {
            $("#username").sendKeys("standard_user");
        $("#password").sendKeys("wrong_password");
        $("#loginButton").click();

        $("#message")
                .shouldHave(text("Invalid username or password."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));

                $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }
    @Test
    @Order(2)
    @DisplayName("03. Успешный вход по клавише Enter")
    void test03_success_login_enter() {
            $("#username").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");

        // 2. Нажимаем Enter в поле пароля
        $("#password").pressEnter();

                $("#message")
                .shouldHave(text("Вход в систему выполнен успешно! Загрузка..."))
                .shouldBe(visible)
                .shouldBe(cssClass("success"));

                $("#greeting")
                .shouldHave(text("Welcome, standard_user!"))
                .shouldBe(visible);
    }

    // ========== ТЕСТ 04: Выход из системы ==========
    @Test
    @Order(3)
    @DisplayName("04. Выход из системы")
    void test04_logout_success() {
            $("#username").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#loginButton").click();
        $("#message").shouldHave(text("Вход в систему выполнен успешно! Загрузка..."));
        $("#logoutButton").click();
        $("#logoutButton").shouldNotBe(visible);
        $("#loginContainer").shouldBe(visible);
        $("#loginInfo").shouldBe(visible);
        $("#username").shouldBe(visible);
        $("#password").shouldBe(visible);
        $("#loginButton").shouldBe(visible);
    }
    @Test
    @Order(4)
    @DisplayName("05. Неправильный логин → ошибка")
    void test05_wrong_login_correct_password() {
            $("#username").sendKeys("incorrect_login");
        $("#password").sendKeys("secret_sauce");

        $("#loginButton").click();

               $("#message")
                .shouldHave(text("Invalid username or password."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));
                $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }
    @Test
    @Order(5)
    @DisplayName("07. Заблокированный пользователь → ошибка")
    void test07_error_blocked_user() {
            $("#username").sendKeys("locked_out_user");
        $("#password").sendKeys("secret_sauce");
           $("#loginButton").click();

                $("#message")
                .shouldHave(text("Пользователь заблокирован."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));

        $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }

    @Test
    @Order(6)
    @DisplayName("08. Пустой логин → ошибка")
    void test08_empty_login_correct_password() {
               $("#password").sendKeys("secret_sauce");
              $("#loginButton").click();
              $("#message")
                .shouldHave(text("Username is required."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));
        $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }

        @Test
    @Order(7)
    @Tag("SmokeTest")
    @DisplayName("09. Пустой пароль → ошибка")
    void test09_error_empty_password() {

        $("#username").sendKeys("standard_user");
        $("#loginButton").click();
                $("#message")
                .shouldHave(text("Password is required."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));
                $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }
    @Test
    @Order(8)
    @Tag("SmokeTest")
    @DisplayName("10. Пустые логин и пароль → ошибка")
    void test10_error_empty_login_and_password() {

        $("#loginButton").click();
               $("#message")
                .shouldHave(text("Username and Password are required."))
                .shouldBe(visible)
                .shouldBe(cssClass("error"));
              $("#greeting")
                .shouldBe(empty)
                .shouldNotBe(visible);
    }
    @Disabled("Этот тест дублирует test01_success_login_button")
    @Test
    @DisplayName("12. Вход под разными пользователями (отключен)")
    void test12_success_logins_different_users() {
        String[] users = {"standard_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"};

        for (String username : users) {
            $("#username").setValue(username);
            $("#password").setValue("secret_sauce");
            $("#loginButton").click();

            $("#message")
                    .shouldHave(text("Вход в систему выполнен успешно! Загрузка..."))
                    .shouldBe(visible)
                    .shouldBe(cssClass("success"));

            $("#greeting")
                    .shouldHave(text("Welcome, " + username + "!"))
                    .shouldBe(visible);

            $("#logoutButton").click();
        }
    }
}