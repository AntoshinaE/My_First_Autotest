import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SimpleAlertsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }
    @Test
    void test01() {
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();
        $("#alertButton").click();
         switchTo().alert().accept();
    }

    @Test
    void test02() {
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();
        $("#timerAlertButton").click();
        switchTo().alert().accept();
           }

    @Test
    void test03() {
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();
        $("#confirmButton").click();
        switchTo().alert().accept();
        $("#confirmResult").shouldHave(text("You selected Ok"));
    }

    @Test
    void test04() {
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();
        $("#confirmButton").click();
        switchTo().alert().dismiss();
        $("#confirmResult").shouldHave(text("You selected Cancel"));
           }

    @Test
            void test05() {
            open("https://demoqa.com/alerts");
            getWebDriver().manage().window().maximize();
            $("#promtButton").click();
             switchTo().alert().sendKeys("Елена");
            $("#promptResult").shouldHave(text("You entered Елена"));
    }
    @Test
    void test06() {
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();
        $("#promtButton").click();
        switchTo().alert().sendKeys("Елена");
        switchTo().alert().dismiss();
    }
}
