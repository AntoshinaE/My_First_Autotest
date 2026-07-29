
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestgoogleTitle {
    @Test
     void Test01(){
        Configuration.browser="Chrome";
        open("https://www.google.com");
        $("body").shouldHave(text("Google"));
    }
    @Test
    void Test02(){
        Configuration.browser="Chrome";
        open("https://www.google.com");
        $("body").shouldHave(text("Pangya"));
    }
}
