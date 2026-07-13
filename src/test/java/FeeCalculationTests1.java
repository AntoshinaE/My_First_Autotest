import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

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
}
