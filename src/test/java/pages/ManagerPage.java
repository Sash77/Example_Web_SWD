package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class ManagerPage extends HelperBase {
    public ManagerPage(WebDriver wd) {
        super(wd);
    }

    public int qntOfContracts(String contractType) {

        waitElement(By.xpath("//span[contains(@class,'cucumber-contract-status')]"), 2000);

        return wd.findElements(By.xpath("//span[contains(@class,'cucumber-contract-status')]"))
                .stream().filter(webElement -> webElement.getText().toLowerCase().equals(contractType.toLowerCase()))
                .collect(Collectors.toList()).size();
    }

}
