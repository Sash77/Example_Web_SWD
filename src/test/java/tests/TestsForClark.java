package tests;

import appmanager.DataProviderDocument;
import model.EntityBedarf;
import model.EntityRente;
import model.EntityVertrage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestsForClark extends TestBase {

    @Test(dataProvider = "validVertrage", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testVertrage(EntityVertrage dataProvider) {

        app.goTo().openManagerPage();

        assertTrue(app.getManagerPage().qntOfContracts(dataProvider.getContractType()) == dataProvider.getExpectedQnt());

    }

    @Test(dataProvider = "validRente", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testRente(EntityRente dataProvider) {

        app.goTo().openCockpitPage();

        assertTrue(app.getCockpitPage().returnRenten() >= dataProvider.getAmmount());

    }

    @Test(dataProvider = "validBedarf", dataProviderClass = DataProviderDocument.class, alwaysRun = true)
    public void testBedarf(EntityBedarf dataProvider) {

        app.goTo().openRecommendations();

        assertTrue(app.getRecommendPage().searchTextInAllColumns(dataProvider.getText()));

    }

}
