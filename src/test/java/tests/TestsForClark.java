package tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestsForClark extends TestBase{

    @Test
    public void testVertrage(){

        //Open login page
        app.goTo().openloginPage();

        //Logging in
        app.getSession()
                .login(app.getProperties().getProperty("web.adminLogin"),
                        app.getProperties().getProperty("web.adminPassword"));

    }


}
