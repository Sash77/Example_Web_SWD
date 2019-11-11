package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CockpitPage extends HelperBase {
    public CockpitPage(WebDriver wd) {
        super(wd);
    }

    public double returnRenten() {
        return Double.parseDouble(wd.findElement(By.xpath("//*[contains(@class,'_actual-income__value')]"))
                .getText().split(" ")
                [0].replace(".", "").replace(",", "."));


    }
}
