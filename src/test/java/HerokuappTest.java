import io.qameta.allure.*;
import static io.qameta.allure.Allure.step;
import org.testng.annotations.Test;

@Epic("Herokuapp Features")
public class HerokuappTest extends A_BaseTest {

    @Test
    @Story("Dynamic Loading")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test dynamic loading functionality")
    public void testDynamicLoading() {
        step("Open dynamic loading page", () -> {
            app.dynamicLoadingPage.open();
        });

        step("Click start button", () -> {
            app.dynamicLoadingPage.clickStart();
        });

        step("Wait for loading to complete", () -> {
            app.dynamicLoadingPage.waitForLoading();
        });

        step("Verify finish text", () -> {
            softAssert.assertEquals(app.dynamicLoadingPage.getFinishText(), "Hello World!");
            softAssert.assertAll();
        });
    }

    @Test
    @Story("File Upload")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test file upload functionality")
    public void testFileUpload() {
        step("Open file upload page", () -> {
            app.fileUploadPage.open();
        });

        step("Upload file", () -> {
            app.fileUploadPage.uploadFile("test-files/test.txt");
        });

        step("Verify uploaded filename", () -> {
            softAssert.assertEquals(app.fileUploadPage.getUploadedFileName(), "test.txt");
            softAssert.assertAll();
        });
    }

    @Test
    @Story("Checkboxes")
    @Severity(SeverityLevel.MINOR)
    @Description("Test checkbox functionality")
    public void testCheckboxes() {
        step("Open checkboxes page", () -> {
            app.checkboxesPage.open();
        });

        step("Toggle first checkbox", () -> {
            app.checkboxesPage.toggleCheckbox(0);
        });

        step("Verify checkbox states", () -> {
            softAssert.assertTrue(app.checkboxesPage.isCheckboxChecked(0));
            softAssert.assertTrue(app.checkboxesPage.isCheckboxChecked(1)); // Second checkbox is checked by default
            softAssert.assertAll();
        });
    }

    @Test
    @Story("Dropdown")
    @Severity(SeverityLevel.MINOR)
    @Description("Test dropdown functionality")
    public void testDropdown() {
        step("Open dropdown page", () -> {
            app.dropdownPage.open();
        });

        step("Select Option 1", () -> {
            app.dropdownPage.selectOption("Option 1");
        });

        step("Verify selected option", () -> {
            softAssert.assertEquals(app.dropdownPage.getSelectedOption(), "Option 1");
            softAssert.assertAll();
        });
    }

    @Test
    @Story("JavaScript Alerts")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test JavaScript alerts functionality")
    public void testJavaScriptAlerts() {
        step("Open JavaScript Alerts page", () -> {
            app.javascriptAlertsPage.open();
        });

        step("Test JS Alert", () -> {
            app.javascriptAlertsPage.clickJsAlert();
            softAssert.assertEquals(app.javascriptAlertsPage.getResult(), "You successfully clicked an alert");
        });

        step("Test JS Confirm - Accept", () -> {
            app.javascriptAlertsPage.clickJsConfirm(true);
            softAssert.assertEquals(app.javascriptAlertsPage.getResult(), "You clicked: Ok");
        });

        step("Test JS Prompt", () -> {
            app.javascriptAlertsPage.clickJsPrompt("Hello World");
            softAssert.assertEquals(app.javascriptAlertsPage.getResult(), "You entered: Hello World");
            softAssert.assertAll();
        });
    }
}