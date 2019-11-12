package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void openloginPage() {
        wd.get("https://www.clark.de/de/login");
    }

    public void openManagerPage() {
        wd.get("https://www.clark.de/de/app/manager");
    }

    public void openCockpitPage() {
        wd.get("https://www.clark.de/de/app/retirement/cockpit");

    }

    public void openRecommendations() {

        wd.get("https://www.clark.de/de/app/manager/recommendations");

        if (isElementPresent(By.xpath("//*[contains(@class,'cucumber-no1-modal-close')]"))&&wd.findElement(By.xpath("//*[contains(@class,'cucumber-no1-modal-close')]")).isDisplayed()) {
            click(By.xpath("//*[contains(@class,'cucumber-no1-modal-close')]"));
        }

    }

}
