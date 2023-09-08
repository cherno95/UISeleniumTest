package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeSearchPage extends BasePage {

    @FindBy(xpath = "//*[@class='arrow__input mini-suggest__input']")
    protected WebElement setValue;

    @FindBy(xpath = "//*[@class='arrow__button']")
    protected WebElement clickBtn;

    @FindBy(xpath = "//*[@class='OrganicTitleContentSpan organic__title']")
    protected WebElement getValue;
}
