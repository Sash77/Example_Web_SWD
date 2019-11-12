package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver wd;

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

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean waitElement(By locator, int mlSec) {
        Boolean present = false;
        long timeStart = System.currentTimeMillis();
        long timeEnd = timeStart + mlSec;
        while (timeStart <= timeEnd) {
            present = isElementPresent(locator);
            timeStart = System.currentTimeMillis();
            if (present) {
                break;
            }
        }
        return present;
    }

    public boolean waitTextValue(By locator, int mlSec) {
        Boolean present = false;
        long timeStart = System.currentTimeMillis();
        long timeEnd = timeStart + mlSec;
        while (timeStart <= timeEnd) {
            present = !wd.findElement(locator).getText().equals("");
            timeStart = System.currentTimeMillis();
            if (present) {
                break;
            }
        }
        return present;
    }
}
