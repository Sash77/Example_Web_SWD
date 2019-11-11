package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();

        //Open login page
        app.goTo().openloginPage();

        //Logging in
        app.getSession()
                .login(app.getProperties().getProperty("web.adminLogin"),
                        app.getProperties().getProperty("web.adminPassword"));

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}