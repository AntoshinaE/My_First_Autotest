import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ModalTests1 {
    @Test
    void test01(){
        Configuration.pageLoadStrategy="eager";
        open("https://demoqa.com/modal-dialogs");
        $("#showSmallModal").click();
        $x("//div[@id='example-modal-sizes-title-sm']")
                        .shouldBe(visible)
                       .shouldHave(text("Small Modal"));
        $x("//button[@id='closeSmallModal']").click();
        $x("//div[@id='example-modal-sizes-title-sm']").shouldNotBe(visible);
        $("#showLargeModal").click();
        $x("//div[@id='example-modal-sizes-title-lg']")
                        .shouldBe(visible)
                       .shouldHave(text("Large Modal"));
        $x("//button[@id='closeLargeModal']").click();
        $x("//div[@id='example-modal-sizes-title-lg']").shouldNotBe(visible);
    }
    @Test
    void test02(){
        Configuration.pageLoadStrategy="eager";
        open("https://demoqa.com/modal-dialogs");
        $("#showSmallModal").click();
        $x("//div[@id='example-modal-sizes-title-sm']")
                      .shouldBe(visible)
                      .shouldHave(text("Small Modal"));
        $x("//button[@class='btn-close']").click();
        $x("//div[@id='closeSmallModal']").shouldNotBe(visible);

        $("#showLargeModal").click();
        $x("//div[@id='example-modal-sizes-title-lg']").shouldBe(visible);
        $x("//div[@id='example-modal-sizes-title-lg']")
                .shouldHave(text("Large Modal"));
        $x("//button[@class='btn-close']").click();
        $x("//div[@id='example-modal-sizes-title-lg']").shouldNotBe(visible);
    }
    }






