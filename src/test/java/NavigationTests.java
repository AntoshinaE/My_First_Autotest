import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class NavigationTests {
    @Test
    void testNavigation(){
      open("https://www.pangea-center.ru/");
      sleep(3_000);
        open("https://www.pangea-center.ru/vrachi/oftalmolog");
        sleep(3_000);
        open("https://www.pangea-center.ru/programms/dispancerization");
        sleep(3000);
      back();
      sleep(3000);
        back();
        sleep(3000);
        forward();
        sleep(3000);
    }
}
