package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecommendPage extends HelperBase {
    public RecommendPage(WebDriver wd) {
        super(wd);
    }

    public boolean searchTextInAllColumns(String text) {

        boolean byDefaultValue = false;
        boolean currentValue = false;

        waitElement(By.xpath("//div[@class='ember_page__wrapper']/div/div/div"), 2000);

        List<WebElement> listWebElements = wd.findElements(By.xpath("//div[@class='ember_page__wrapper']/div/div/div"));
        for (int i = 0; i < listWebElements.size(); i++) {
            try {
                currentValue = listWebElements.get(i)
                        .findElement(By.xpath(".//*[@class='manager__optimisations__optimisation-list__done__title']")).getText().equals(text);
            } catch (Exception e) {
            }

            if (currentValue & i == 0) {
                byDefaultValue = true;
            } else if (currentValue & i != 0) {
                byDefaultValue = false;
            }

            currentValue = false;
        }

        return byDefaultValue;
    }

    public void pressLinkInviteFriend(String text) {
        waitElement(By.xpath("//a[contains(.,'Clark jetzt empfehlen')]"), 2000);
        click(By.xpath(String.format("//a[contains(.,'%s')]", text)));
    }

}
