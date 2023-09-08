import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pages.BasePage;
import steps.ActionsWithElements;
import steps.ActionsWithList;

public class TestYandex extends BasePage {

    @Test
    @Tag("smoke")
    @Step("Позитивный сценарий. Поиск: 'Java курсы skillbox'")
    @SneakyThrows
    public void positive() {
        new ActionsWithElements()
                .setValue("Java курсы skillbox")
                .clickBtn("Найти");

        new ActionsWithList()
                .isValuePresent("Java курсы skillbox");

    }

    // Метод для создания и добавления скриншота в отчет Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}