package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;

    private ManagerPage managerPage;
    private CockpitPage cockpitPage;
    private RecommendPage recommendPage;


    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));

        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);

        managerPage = new ManagerPage(wd);
        cockpitPage = new CockpitPage(wd);
        recommendPage = new RecommendPage(wd);

    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSession() {
        return sessionHelper;
    }

    public ManagerPage getManagerPage() {
        return managerPage;
    }

    public CockpitPage getCockpitPage() {
        return cockpitPage;
    }

    public RecommendPage getRecommendPage() {
        return recommendPage;
    }

    public Properties getProperties() {
        return properties;
    }

    public List getBrowserLogs(){
        return wd.manage().logs().get("browser").getAll();
    }
}
