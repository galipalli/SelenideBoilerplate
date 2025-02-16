package app;

import app.pages.*;

public class App {
    public LoginPage loginPage;
    public DynamicLoadingPage dynamicLoadingPage;
    public FileUploadPage fileUploadPage;
    public CheckboxesPage checkboxesPage;
    public DropdownPage dropdownPage;
    public JavaScriptAlertsPage javascriptAlertsPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        dynamicLoadingPage = PageBuilder.buildDynamicLoadingPage();
        fileUploadPage = PageBuilder.buildFileUploadPage();
        checkboxesPage = PageBuilder.buildCheckboxesPage();
        dropdownPage = PageBuilder.buildDropdownPage();
        javascriptAlertsPage = PageBuilder.buildJavaScriptAlertsPage();
    }
}
