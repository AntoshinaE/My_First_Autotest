import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FeeCalculationTests1 {
    @Test
    void test01Open() {
        open("https://slqa.ru/cases/fc/v01/index.php");
        sleep(3_000);
        $(By.name("sum")).sendKeys("100");
        $(By.name("submit")).click();
        $(By.name("sum")).clear();
        $(By.name("sum")).setValue("200");
        $(By.name("submit")).click();
        $(By.name("sum")).type("300");
        $(By.name("submit")).click();

             sleep(3_000);
    }
    @Test
    void test02IFrameByIndex() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/frames");
        getWebDriver().manage().window().maximize();
        switchTo().frame(0);
        $x("//h1").shouldHave(text("This is a sample page"));
        sleep(5000);
        switchTo().defaultContent();
        switchTo().frame("sampleHeading");
              $x("//sampleHeading").shouldHave(text("This is a sample page"));
        sleep(5000);
        switchTo().parentFrame();
    }
    @Test
    void testAlertsDemoQA() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 15_000;
        open("https://demoqa.com/alerts");
        getWebDriver().manage().window().maximize();

        $("#alertButton").click();

        switchTo().alert().getText();

        switchTo().alert().accept();




        $("#timerAlertButton").click();


        sleep(5_000);


        switchTo().alert().accept();




        $("#confirmButton").click();

        switchTo().alert().accept();

        $("#confirmResult").shouldHave(text("You selected Ok"));




        $("#confirmButton").click();

        switchTo().alert().dismiss();

        $("#confirmResult").shouldHave(text("You selected Cancel"));




        $("#promtButton").click();

        switchTo().alert().sendKeys("Тестировщик");

        switchTo().alert().accept();

        $("#promptResult").shouldHave(text("You entered Тестировщик"));




        $("#promtButton").click();

        switchTo().alert().dismiss();

        $("#promptResult").shouldHave(text("You entered null"));



        sleep(3_000);
    }
}
