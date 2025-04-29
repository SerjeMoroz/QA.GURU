import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

public class FirstTest extends TestBase{

    @Test
    void firstTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        $("#firstName").setValue("Serje");
        $("#lastName").setValue("Moroz");
        $("#userEmail").setValue("Serje@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("01234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__day--022:not(react-datepicker__day--weekend)").click();
        $("#subjectsContainer").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/blueBird.jpg"));
        $("#currentAddress").setValue("Pushkina-kolotushkina");
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

    }
}