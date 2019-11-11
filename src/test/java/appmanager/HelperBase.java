package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HelperBase {
    protected WebDriver wd;
    private WebDriverWait webDriverWait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void makeSelect(String locator, String text) {
        Select select = new Select(wd.findElement(By.xpath(locator)));
        select.selectByValue(text);
    }

    public WebDriverWait getWait() {

        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(wd, 10);
        }

        return webDriverWait;
    }
}
