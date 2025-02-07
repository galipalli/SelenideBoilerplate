import app.App;
import helpers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import helpers.TestConfig;

class A_BaseTest {

    protected App app;
    protected SoftAssert softAssert;
    protected Logger logger;

    @BeforeClass
    public void setUp() {
        // Use the new property name for Selenium 4
        System.setProperty("selenium.webdriver.http.factory", "jdk-http-client");
        
        Driver.initDriver();

        app = new App();
        softAssert = new SoftAssert();

        logger = LogManager.getLogger("");
        DOMConfigurator.configure("src/main/resources/log4j.xml");

        setupBrowser();
    }

    private void setupBrowser() {
        if (TestConfig.isEdge()) {
            WebDriverManager.edgedriver().setup();
            Configuration.browser = "edge";
        } else {
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
        }

        Configuration.browserSize = "1920x1080";
        
        // Browser binary setup for different OS/architectures
        if (TestConfig.isChrome() && System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("selenide.browserBinary", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        } else if (TestConfig.isEdge() && System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("selenide.browserBinary", "/Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge");
        }
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        Driver.close();
    }
}
