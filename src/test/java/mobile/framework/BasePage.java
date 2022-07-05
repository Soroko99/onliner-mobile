package mobile.framework;

import lombok.extern.log4j.Log4j2;
import mobile.framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.Date;


@Log4j2
public class BasePage extends BaseTest {
    protected String title;
    protected By titleLocator;
    protected PropertyReader propertyReader = new PropertyReader("log.properties");
    public static SoftAssert softAssert = new SoftAssert();

    private void init(final By locator, final String pageTitle) {
        titleLocator = locator;
        title = pageTitle;
    }

}