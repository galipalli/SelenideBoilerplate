package helpers;

public class TestConfig {
    private static String browser = System.getProperty("browser", "chrome"); // Default to chrome if not specified

    public static String getBrowser() {
        return browser.toLowerCase();
    }

    public static void setBrowser(String browserName) {
        browser = browserName.toLowerCase();
    }

    public static boolean isChrome() {
        return getBrowser().equals("chrome");
    }

    public static boolean isEdge() {
        return getBrowser().equals("edge");
    }

    public static String headless = "0";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
}
