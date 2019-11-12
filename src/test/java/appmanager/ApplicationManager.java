package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import pages.CockpitPage;
import pages.InvitationPage;
import pages.ManagerPage;
import pages.RecommendPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    private InvitationPage invitationPage;


    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    //Create web driver and all pages.
    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", String.format("%s/geckodriver.exe",properties.getProperty("driversFolder")));
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver.exe",properties.getProperty("driversFolder")));
            wd = new ChromeDriver();

        } else if (browser.equals(BrowserType.EDGE)) {
            System.setProperty("webdriver.ie.driver", String.format("%s/msedgedriver.exe",properties.getProperty("driversFolder")));
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));

        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);

        managerPage = new ManagerPage(wd);
        cockpitPage = new CockpitPage(wd);
        recommendPage = new RecommendPage(wd);
        invitationPage = new InvitationPage(wd);

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

    public InvitationPage getInvitationPage() {
        return invitationPage;
    }

    public Properties getProperties() {
        return properties;
    }

}
