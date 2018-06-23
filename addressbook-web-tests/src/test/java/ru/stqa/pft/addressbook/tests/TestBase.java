package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

    public static final String PATH_TO_RESOURCES = "src\\test\\resources\\";

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    private Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod(enabled = false)
    public void logTestStart(Method n, Object[] p) {
        logger.info("Start test " + n.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(enabled = false)
    public void logTestStop(Method n) {
        logger.info("Stop test " + n.getName());
    }

    public static String getDataProperties (String param) throws IOException {
        Properties props = new Properties();
        props.load(new InputStreamReader(new FileInputStream(PATH_TO_RESOURCES + "data.properties"), "UTF-8"));
        return props.getProperty(param);
    }
}
