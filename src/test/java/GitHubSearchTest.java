import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GitHubSearchTest {
    @Test
    void githubTest() {
        open("https://github.com");
        Configuration.browserSize = "1920x1080";
        $("span[class='flex-1']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$(".Box-sc-g0xbh4-0.JcuiZ").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $(byText("Soft assertions")).shouldHave(text("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
