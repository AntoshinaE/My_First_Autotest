
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestgoogleTitle {
    @Test
     void Test01(){
        open("https://www.google.com");
        $("body").shouldHave(text("Google"));
    }
    @Test
    void Test02(){
        open("https://www.google.com");
        $("body").shouldHave(text("Pangya"));
    }
}
