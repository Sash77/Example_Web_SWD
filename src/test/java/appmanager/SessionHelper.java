package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        type(By.id("user_email"), username);
        type(By.name("user_password"), password);
        wd.findElement(By.xpath("//input[@type='submit' and @value='Login']"))
                .click();
    }

}