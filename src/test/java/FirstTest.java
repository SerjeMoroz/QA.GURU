import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

public class FirstTest extends TestBase{

    @Test
    void firstTest() {
        open("/automation-practice-form");
        $("div[class='practice-form-wrapper'] h5").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        $("#firstName").setValue("Serje");
        $("#lastName").setValue("Moroz");
        $("#userEmail").setValue("Serje@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--022:not(react-datepicker__day--weekend)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/blueBird.jpg"));
        $("#currentAddress").setValue("Pushkina-kolotushkina");
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[normalize-space()='Student Name']/following-sibling::td")).shouldHave(text("Serje Moroz"));
        $(byXpath("//td[normalize-space()='Student Email']/following-sibling::td")).shouldHave(text("Serje@gmail.com"));
        $(byXpath("//td[normalize-space()='Date of Birth']/following-sibling::td")).shouldHave(text("22 June,1994"));
        $(byXpath("//td[normalize-space()='Hobbies']/following-sibling::td")).shouldHave(text("Music"));
        $(byXpath("//td[normalize-space()='Picture']/following-sibling::td")).shouldHave(text("blueBird.jpg"));
        $(byXpath("//td[normalize-space()='Address']/following-sibling::td")).shouldHave(text("Pushkina-kolotushkina"));
        $(byXpath("//td[normalize-space()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }
}