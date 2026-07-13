import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class UsernameTest {
    @Test
    void Username(){
        open("https://www.saucedemo.com/");
        $(By.id("user-name")).sendKeys("Елена");
        sleep(10000);
          }
}

