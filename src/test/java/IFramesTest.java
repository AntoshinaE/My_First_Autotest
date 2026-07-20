import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class IFramesTest {
    @Test
    void test01IFrame01() {
        //Configuration.pageLoadTimeout = 120_000;
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/frames");
        getWebDriver().manage().window().maximize();
        switchTo().frame($("#frame1"));
        $x("//h1")
                .shouldBe(visible)
                .shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
    }
        @Test
        void test0IFrame02() {
            //Configuration.pageLoadTimeout = 120_000;
            Configuration.pageLoadStrategy = "eager";
            open("https://demoqa.com/frames");
            getWebDriver().manage().window().maximize();
            switchTo().frame($("#frame2"));
            $x("//h1")
                    .shouldBe(visible)
                    .shouldHave(text("This is a sample page"));
            switchTo().defaultContent();

        }
    }
