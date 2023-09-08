package steps;

import org.openqa.selenium.WebElement;
import pages.HomeSearchPage;

public class ActionsWithList extends HomeSearchPage {

    public boolean isValuePresent(String name) {
        WebElement element = getValue;
        if (element != null) {
            return element.getText().contains(name);
        }
        return false;
    }
}
