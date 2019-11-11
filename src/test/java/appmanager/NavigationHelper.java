package appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void openloginPage(){
        wd.get("https://www.clark.de/de/login");
    }

    public void openManagerPage(){
        wd.get("https://www.clark.de/de/app/manager");
    }

    public void openCockpitPage(){
        wd.get("https://www.clark.de/de/app/retirement/cockpit");
    }

    public void openRecommendations(){
        wd.get("https://www.clark.de/de/app/manager/recommendations");
    }

}
