import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserPropertiesTests {
    @Test
    void text_browser_properties(){
        Configuration.browser="firefox";
        Configuration.browserSize="1500x500";
        Configuration.browserPosition="150x300";
        open("https://www.pangea-center.ru/");
        sleep(10000);

        getWebDriver().manage().window().maximize();
        sleep(10000);
    }
}
