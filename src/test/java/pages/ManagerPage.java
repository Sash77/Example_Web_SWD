package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import appmanager.HelperBase;

import java.util.stream.Collectors;

public class ManagerPage extends HelperBase{
    public ManagerPage(WebDriver wd) {
        super(wd);
    }

    public int qntOfContracts(){
        return wd.findElements(By.xpath("//div[@id='ember760']//span[contains(@class,'cucumber-contract-status_text')]"))
                .stream().filter(webElement -> webElement.getText().equals("Gut versichert"))
                .collect(Collectors.toList()).size();
    }


}
