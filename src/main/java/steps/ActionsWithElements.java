package steps;

import org.openqa.selenium.WebElement;
import pages.HomeSearchPage;

public class ActionsWithElements extends HomeSearchPage {

    public ActionsWithElements setValue(String name) {
        setValue.sendKeys(name);
        return this;
    }

    public ActionsWithElements clickBtn(String name) {
        if (clickBtn.getText().equals(name)) {
            clickBtn.click();
        }
        return this;
    }

    public boolean isValuePresent(String name) {
        WebElement element = getValue;
        if (element != null) {
            return element.getText().contains(name);
        }
        return false;
    }
}
