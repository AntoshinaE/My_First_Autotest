import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTests {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
    }

    @ParameterizedTest(name = "Тест: {0}")
    @CsvSource({
            "standard_user, stand_pass1, Иванов Иван Иванович",
            "problem_user, prob_pass3, Сидорова Анна Владимировна",
            "performance_glitch_user, perf_pass4, Кузнецов Дмитрий Сергеевич",
            "error_user, erro_pass5, Смирнова Елена Александровна",
            "visual_user, visu_pass6, Федоров Алексей Николаевич"
    })
    void testLogin(String username, String password, String fullName) {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        getWebDriver().manage().window().maximize();
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("#loginButton").click();
        $("#loginContainer").shouldNotBe(visible);
        $("#logoutButton").shouldBe(visible);
        $("#logoutButton").shouldBe(clickable);
        String expectedGreeting = "Добро пожаловать, " + fullName + "!";
        $("#greeting").shouldHave(text(expectedGreeting));
        $("#greeting").shouldBe(visible);
    }
}
