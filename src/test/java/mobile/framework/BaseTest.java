package mobile.framework;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import java.util.logging.Logger;
import static mobile.framework.AppiumServer.startServer;
import static mobile.framework.AppiumServer.stopServer;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {
    private final Logger logger = Logger.getLogger("mobile logger");
    public static Browser browser;

    @BeforeSuite
    protected void startAppiumServer() {
        logger.info("@BeforeSuite - startAppiumServer()");
        startServer();
    }

    @BeforeMethod
    public void setup() {
        try {
            browser = Browser.getInstance();
            browser.getDriver().get("https://www.onliner.by/");
        } catch (NullPointerException npe) {
            logger.info("browser wasn't started");
        }
    }

    @AfterMethod
    public void tearDown() {
        browser.exit();
    }

    @AfterSuite
    public void stop() {
        stopServer();
    }
}