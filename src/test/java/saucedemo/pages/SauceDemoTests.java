package saucedemo.pages;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Тесты для SauceDemo")
public class SauceDemoTests {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.pageLoadStrategy = "eager";
            }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println(" " + testInfo.getDisplayName() + " - начали выполнение.");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        loginPage.open();
    }


    @AfterAll
    static void afterAll() {
        System.out.println("=== ВСЕ ТЕСТЫ SAUCEDEMO ЗАВЕРШЕНЫ ===");
    }


    @Test
    @DisplayName("01. Успешный логин")
    void test01SuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce")
                .checkInventoryVisible()
                .checkLogo("Swag Labs")
                .checkCartVisible();
    }

    @Test
    @DisplayName("02. Неверный пароль")
    void test02WrongPassword() {
        loginPage.loginWithError("standard_user", "123456")
                .checkError("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @DisplayName("03. Пустой логин")
    void test03EmptyUsername() {
        loginPage.loginWithError("", "secret_sauce")
                .checkError("Epic sadface: Username is required");
    }


    @Test
    @DisplayName("04. Пустой пароль")
    void test04EmptyPassword() {
        loginPage.loginWithError("standard_user", "")
                .checkError("Epic sadface: Password is required");
    }


    @Test
    @DisplayName("05. Неверный логин")
    void test05WrongUsername() {
        loginPage.loginWithError("Helen", "secret_sauce")
                .checkError("Epic sadface: Username and password do not match any user in this service");
    }

        @ParameterizedTest
    @CsvSource({
            "standard_user, secret_sauce",
            "problem_user, secret_sauce",
            "performance_glitch_user, secret_sauce"
    })
    @DisplayName("07. Логин под разными пользователями")
    void test06MultiLogin(String username, String password) {
        loginPage.login(username, password)
                .checkInventoryVisible()
                .checkLogo("Swag Labs");
    }
}
