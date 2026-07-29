package travel;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Тесты для AgileWay Travel")
public class AgileTravelTests {

    private AgileLoginPage loginPage;
    private AgileSearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        System.out.println("=== НАЧАЛО ТЕСТОВ AGILEWAY ===");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("▶ " + testInfo.getDisplayName() + " - начали выполнение.");
        open("https://travel.agileway.net/");
        getWebDriver().manage().window().maximize();
        loginPage = new AgileLoginPage();
        searchPage = new AgileSearchPage();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("◀ " + testInfo.getDisplayName() + " - закончили выполнение.\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=== ВСЕ ТЕСТЫ AGILEWAY ЗАВЕРШЕНЫ ===");
    }

    // ============================================================
    // ТЕСТ 1: Успешный логин
    // ============================================================
    @Test
    @DisplayName("01. Успешный логин")
    void test01SuccessfulLogin() {
        loginPage.login("standard_user", "stand_pass1")
                .isLoginSuccessful();
    }

    // ============================================================
    // ТЕСТ 2: Неуспешный логин
    // ============================================================
    @Test
    @DisplayName("02. Неуспешный логин")
    void test02FailedLogin() {
        loginPage.login("wrong_user", "wrong_pass")
                .isLoginUnsuccessful();
    }

    // ============================================================
    // ТЕСТ 3: Поиск рейсов
    // ============================================================
    @Test
    @DisplayName("03. Поиск рейсов")
    void test03SearchFlights() {
        loginPage.login("standard_user", "stand_pass1")
                .isLoginSuccessful();

        searchPage.search("Москва", "Нью-Йорк", "2026-07-28", "2026-08-01")
                .isFlightsFound();
    }

    // ============================================================
    // ТЕСТ 4: Поиск - рейсов нет
    // ============================================================
    @Test
    @DisplayName("04. Поиск - рейсов нет")
    void test04NoFlights() {
        loginPage.login("standard_user", "stand_pass1")
                .isLoginSuccessful();

        searchPage.search("Москва", "Лондон", "2026-07-28", "2026-08-01")
                .isNoFlights();
    }

    // ============================================================
    // ТЕСТ 5: Параметризованный логин
    // ============================================================
    @ParameterizedTest
    @CsvSource({
            "standard_user, stand_pass1",
            "problem_user, prob_pass3"
    })
    @DisplayName("05. Логин под разными пользователями")
    void test05MultiLogin(String username, String password) {
        loginPage.login(username, password)
                .isLoginSuccessful();
    }
}


