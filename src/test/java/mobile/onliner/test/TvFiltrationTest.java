package mobile.onliner.test;

import mobile.framework.BaseTest;
import mobile.onliner.pageobjects.menu.MainMenu;
import mobile.onliner.pageobjects.pages.CatalogPage;
import mobile.onliner.pageobjects.pages.TvPage;
import org.testng.annotations.Test;
import static mobile.framework.BasePage.softAssert;

public class TvFiltrationTest extends BaseTest {

    @Test
    public void TVFilterCheck() {
        new MainMenu()
                .burgerMenuClick()
                .catalogChoice("\u041a\u0430\u0442\u0430\u043b\u043e\u0433");
        new CatalogPage()
                .allSectionsClick("\u0412\u0441\u0435\u0020\u0440\u0430\u0437\u0434\u0435\u043b\u044b")
                .electronicaChoice("\u042d\u043b\u0435\u043a\u0442\u0440\u043e\u043d\u0438\u043a\u0430")
                .tvAndVideoChoice("\u0422\u0435\u043b\u0435\u0432\u0438\u0434\u0435\u043d\u0438\u0435")
                .tvChoice("\u0422\u0435\u043b\u0435\u0432\u0438\u0437\u043e\u0440\u044b");

        new TvPage()
                .openFilter("\u0424\u0438\u043b\u044c\u0442\u0440\u044b")
                .manufacturerChoice("Samsung")
                .maxPriceInput("\u0434\u043e", "2000")
                .minResolutionChoice("from", "40")
                .maxResolutionChoice("to", "50")
                .closeFilter()
                .manufacturerValidation()
                .priceValidation()
                .resolutionValidation();

        softAssert.assertAll();
    }
}
