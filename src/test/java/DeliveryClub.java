import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DeliveryClub {
    private static WebDriver webDriver;

    @BeforeAll
    public static void beforeClass() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.get("https://market-delivery.yandex.ru/");
    }

    @Tag("regression")
    @Test
    @Step("Позитивный сценарий. Заказ из ресторана 'KFC' до экрана оплаты")
    @SneakyThrows
    public void positiveLevelKitchen() {
        restaurantChoice("Москва, Новокосинская улица, 12к1", "KFC");
        webDriver.findElement(By.xpath("//*[@class='RestaurantMenu_list']//*[text()='Комбо c Шефбургер Де Люкс']")).click();
        webDriver.findElement(By.xpath("//*[contains(@class,'ModalHeader_defaultStyle')][text()='Комбо c Шефбургер Де Люкс']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[@class='ModalOptionsItem_name'][text()='Шефбургер Де Люкс Оригинальный']")).click();
        webDriver.findElement(By.xpath("//*[@class='ModalOptionsItem_name'][text()='9 Наггетсов']")).click();
        webDriver.findElement(By.xpath("//*[@class='ModalOptionsItem_name'][text()='Соус Кисло-Сладкий Чили']")).click();
        webDriver.findElement(By.xpath("//*[contains(@class,'UICounter_increment')]")).click();
        webDriver.findElement(By.xpath("//*[@class='ModalMenuItemOptions_foot']/button")).click();

        webDriver.findElement(By.xpath("//*[contains(@class,'DesktopHeader_rightBlock')]/button")).click();
        webDriver.findElement(By.xpath("//*[contains(@class,'NewCart_title')]//h2[text()='Корзина']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'NewCartPriceButton_text')][text()='Верно, к оплате']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'AppPopup_root')]//*[text()='Очистить']")).click();

        webDriver.findElement(By.xpath("//*[contains(@class,'UiKitConfirmModal_title')][contains(text(),'Очистить корзину')]")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'UiKitConfirmModal')]//span[contains(text(),'Да, очистить')]")).click();
    }

    @Tag("regression")
    @Test
    @Step("Позитивный сценарий. Заказ из ресторана 'Pronto Pizza' до экрана оплаты")
    @SneakyThrows
    public void positiveProntoPizza() {
        restaurantChoice("Москва, Новокосинская улица, 12к1", "Pronto Pizza");
        webDriver.findElement(By.xpath("//*[@data-testid='product-card-root']//*[text()='Цезарь с индейкой и беконом']")).click();
        webDriver.findElement(By.xpath("//*[contains(@class,'ModalHeader_defaultStyle')][text()='Цезарь с индейкой и беконом']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[@class='ModalMenuItemOptions_foot']/button")).click();

        webDriver.findElement(By.xpath("//*[contains(@class,'DesktopHeader_rightBlock')]/button")).click();
        webDriver.findElement(By.xpath("//*[contains(@class,'NewCart_title')]//h2[text()='Корзина']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'NewCartPriceButton_text')][contains(text(),'Добавьте еще')]")).isDisplayed();
        webDriver.findElement(By.xpath("//*[@data-testid='desktop-popup']//*[contains(@class,'UiKitCounter_squareIncrement')]")).click();

        webDriver.findElement(By.xpath("//*[contains(@class,'NewCartPriceButton_text')][text()='Верно, к оплате']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'AppPopup_root')]//*[text()='Очистить']")).click();

        webDriver.findElement(By.xpath("//*[contains(@class,'UiKitConfirmModal_title')][contains(text(),'Очистить корзину')]")).isDisplayed();
        webDriver.findElement(By.xpath("//*[contains(@class,'UiKitConfirmModal')]//span[contains(text(),'Да, очистить')]")).click();
    }

    @Tag("regression")
    @Test
    @Step("Негативный сценарий авторизации по номеру телефона'")
    public void negativeAuth() {
        webDriver.findElement(By.xpath("//*[contains(@class,'DesktopUIButton_root')]/span")).click();

        webDriver.findElement(By.xpath("//*[@data-t='title'][text()='Введите номер телефона']")).isDisplayed();
        webDriver.findElement(By.xpath("//*[@inputmode='tel']")).sendKeys("9169999999");
        webDriver.findElement(By.xpath("//*[@class='Phone-controls layout_controls']/descendant::button")).click();

        webDriver.findElement(By.xpath("//*[@data-t='title']/div[contains(text(),'Введите код из смс')]")).isDisplayed();
        webDriver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("000000");
    }


    @Step("Поиск ресторана")
    @SneakyThrows
    private void restaurantChoice(String addressHome, String name) {
        webDriver.findElement(By.xpath("//*[contains(@class,'DesktopAddressButton_address')]")).click();
        WebElement address = webDriver.findElement(By.xpath("//*[@data-testid='address-input']"));
        for (char adr : addressHome.toCharArray()) {
            address.sendKeys(String.valueOf(adr));
        }
        address.sendKeys(Keys.ENTER);
        webDriver.findElement(By.xpath("//*[contains(@class,'DesktopLocationModal_ok')]/span")).click();
        WebElement searchField = webDriver.findElement(By.xpath("//*[@data-testid='search-input']"));
        searchField.sendKeys(name);
        searchField.sendKeys(Keys.ENTER);
        String xpath = String.format("//*[text()='%s']", name);
        webDriver.findElement(By.xpath(xpath)).click();
    }

    @AfterAll
    public static void quit() {
        webDriver.quit();
    }
}