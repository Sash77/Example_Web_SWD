package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void login(String username, String password) {
        type(By.id("user_email"), username);
        type(By.id("user_password"), password);
        click(By.xpath("//input[@type='submit' and @value='Login']"));
    }

}