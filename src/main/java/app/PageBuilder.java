package app;

import app.pages.*;

public class PageBuilder {
    public static LoginPage buildLoginPage() {
        return new LoginPage("/login");
    }

    public static DynamicLoadingPage buildDynamicLoadingPage() {
        return new DynamicLoadingPage();
    }

    public static FileUploadPage buildFileUploadPage() {
        return new FileUploadPage();
    }

    public static CheckboxesPage buildCheckboxesPage() {
        return new CheckboxesPage();
    }

    public static DropdownPage buildDropdownPage() {
        return new DropdownPage();
    }

    public static JavaScriptAlertsPage buildJavaScriptAlertsPage() {
        return new JavaScriptAlertsPage();
    }
}
