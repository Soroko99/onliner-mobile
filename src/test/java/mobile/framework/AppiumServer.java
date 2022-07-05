package mobile.framework;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.testng.Reporter;

public class AppiumServer {

    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;

    public static void startServer() {
        System.setProperty(AppiumServiceBuilder.APPIUM_PATH, "C://Users//Vladislav.Saroka//node_modules//appium//build//lib//main.js");
        builder = new AppiumServiceBuilder();
        builder.usingPort(4723);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");
        builder.withArgument(()->"--allow-insecure","chromedriver_autodownload");
        builder.withArgument(new ServerArgument() {
            public String getArgument() {
                return "--avd";
            }
        }, "Pixel_XL_API_28");
        try {
            service = AppiumDriverLocalService.buildService(builder);
            Reporter.log("Start appium server");
            service.start();
        }
        catch (Exception e) {
        Reporter.log("Exception in the appium server start: " + e);
        if (service.isRunning()) {
            Reporter.log("Found that appium service is running. Stopping appium server..");
            service.stop();
            Reporter.log("Build appium service..");
            service = AppiumDriverLocalService.buildService(builder);
            Reporter.log("Start appium server again..");
            service.start();
        }
    }
    }

    public static void stopServer() {
        Reporter.log("Stop appium server");
        service.stop();

    }

    }

