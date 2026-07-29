import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CinemaTests {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Tag("SmokeTest")
    @ParameterizedTest(name = "Позитивный тест: возраст {0}, фильм {3}, цена {4} руб.")
    @CsvFileSource(resources = "cinema_data_positive.csv", numLinesToSkip = 1)
    void testPositiveCinema(String age, String date, String session, String film, String price) {
        open("https://slqamsk.github.io/cases/cinema/v02");

        $("input[name=age]").setValue(age);
        $("input[name='date']").setValue(date);
        $x("//input[@name='session' and @value='" + session + "']").click();
        $("input[name=film][value='" + film + "']").click();
        $x("//button[@type='submit']").click();
        $("#result").shouldBe(visible);
        String expectedMessage = "Стоимость билета: " + price + " рублей.";
        $("#result").shouldHave(text(expectedMessage));
    }
    @ParameterizedTest(name = "Негативный тест: возраст {0}, фильм {3}, ошибка: {4}")
    @CsvFileSource(resources = "cinema_data_negative.csv", numLinesToSkip = 1)
    void testNegativeCinema(String age, String date, String session, String film, String expectedError) {
        open("https://slqamsk.github.io/cases/cinema/v02");
        $("input[name=age]").setValue(age);
        $("input[name='date']").setValue(date);
        $x("//input[@name='session' and @value='" + session + "']").click();
        $("input[name=film][value='" + film + "']").click();
        $x("//button[@type='submit']").click();
        $("#result").shouldBe(visible);
        $("#result").shouldHave(text(expectedError));
    }
           @Test
    void test01_simple_cinema() {
        open("https://slqamsk.github.io/cases/cinema/v02");
        $("input[name=age]").setValue("35");
        $("input[name='date']").setValue("31.07.2026");
        $x("//input[@name='session' and @value='14:00']").click();
        $("input[name=film][value=crime]").click();
        $x("//button[@type='submit']").click();
        $("#result").shouldBe(visible);
        $("#result").shouldHave(text("Стоимость билета: 400 рублей."));
    }
}

