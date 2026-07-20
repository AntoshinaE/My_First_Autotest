import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AlertsTest {

    @BeforeAll
    static void setUp() {
        // Базовая настройка браузера
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void test01SimpleAlert() {
        // 1. Открываем страницу и нажимаем кнопку для простого алерта
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "Click Button to see alert"
        $("#alertButton").click();

        // Переключаемся на алерт и принимаем его (нажимаем OK)
        Alert simpleAlert = switchTo().alert();
        System.out.println("Текст простого алерта: " + simpleAlert.getText());
        simpleAlert.accept();

        // Небольшая пауза для наглядности (в реальных тестах можно убрать)
        sleep(1000);
    }

    @Test
    void test02TimedAlert() {
        // 2. Открываем страницу и нажимаем кнопку для алерта с задержкой
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "On button click, alert will appear after 5 seconds"
        $("#timerAlertButton").click();

        // Ожидаем появления алерта (Selenide сам будет ждать до 10 секунд)
        // Можно добавить явное ожидание: sleep(5000);
        Alert timedAlert = switchTo().alert();
        System.out.println("Текст алерта с таймером: " + timedAlert.getText());
        timedAlert.accept();

        sleep(1000);
    }

    @Test
    void test03ConfirmAlertAccept() {
        // 3.1 Открываем страницу и нажимаем кнопку для подтверждения
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "On button click, confirm box will appear"
        $("#confirmButton").click();

        // Переключаемся на алерт и принимаем его (нажимаем OK)
        Alert confirmAlert = switchTo().alert();
        System.out.println("Текст confirm-алерта: " + confirmAlert.getText());
        confirmAlert.accept();

        // Проверяем, что на странице отобразился результат
        $("#confirmResult").shouldHave(text("You selected Ok"));

        sleep(1000);
    }

    @Test
    void test04ConfirmAlertDismiss() {
        // 3.2 Открываем страницу и нажимаем кнопку для подтверждения
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "On button click, confirm box will appear"
        $("#confirmButton").click();

        // Переключаемся на алерт и отклоняем его (нажимаем Cancel)
        Alert confirmAlert = switchTo().alert();
        System.out.println("Текст confirm-алерта: " + confirmAlert.getText());
        confirmAlert.dismiss();

        // Проверяем, что на странице отобразился результат
        $("#confirmResult").shouldHave(text("You selected Cancel"));

        sleep(1000);
    }

    @Test
    void test05PromptAlertAccept() {
        // 4.1 Открываем страницу и нажимаем кнопку для алерта с полем ввода
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "On button click, prompt box will appear"
        $("#promtButton").click(); // Обратите внимание на ID! В демо он 'promtButton'

        // Переключаемся на алерт, вводим текст и принимаем его
        Alert promptAlert = switchTo().alert();
        System.out.println("Текст prompt-алерта: " + promptAlert.getText());
        promptAlert.sendKeys("Сергей Александрович"); // Вводим имя
        promptAlert.accept();

        // Проверяем, что на странице отобразился введенный текст
        $("#promptResult").shouldHave(text("You entered Сергей Александрович"));

        sleep(1000);
    }

    @Test
    void test06PromptAlertDismiss() {
        // 4.2 Открываем страницу и нажимаем кнопку для алерта с полем ввода
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        // Кликаем по кнопке "On button click, prompt box will appear"
        $("#promtButton").click();

        // Переключаемся на алерт, вводим текст и отклоняем его
        Alert promptAlert = switchTo().alert();
        System.out.println("Текст prompt-алерта: " + promptAlert.getText());
        promptAlert.sendKeys("Сергей Александрович"); // Вводим имя
        promptAlert.dismiss();

        // Проверяем, что на странице отобразился результат отмены
        $("#promptResult").shouldHave(text("You entered null"));

        sleep(1000);
    }
}
