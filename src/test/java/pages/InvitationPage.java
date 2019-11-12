package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvitationPage extends HelperBase {
    public InvitationPage(WebDriver wd) {
        super(wd);
    }

    public void sendEmail(String email) {
        waitElement(By.xpath("//input[@id='email']"), 2000);
        type(By.xpath("//input[@id='email']"), email);
        click(By.xpath("//button[@id='sendInvitationEmail']"));
    }

    public boolean isSendEmailSuccess() {
        return waitElement(By.xpath("//div[@class='success-text']"), 5000);
    }

}
