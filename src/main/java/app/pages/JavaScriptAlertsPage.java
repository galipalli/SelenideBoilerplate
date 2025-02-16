package app.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class JavaScriptAlertsPage extends BasePage {
    private final SelenideElement jsAlertButton = $("[onclick='jsAlert()']");
    private final SelenideElement jsConfirmButton = $("[onclick='jsConfirm()']");
    private final SelenideElement jsPromptButton = $("[onclick='jsPrompt()']");
    private final SelenideElement result = $("#result");

    public JavaScriptAlertsPage() {
        super("/javascript_alerts");
    }

    public void clickJsAlert() {
        jsAlertButton.click();
        switchTo().alert().accept();
    }

    public void clickJsConfirm(boolean accept) {
        jsConfirmButton.click();
        if (accept) {
            switchTo().alert().accept();
        } else {
            switchTo().alert().dismiss();
        }
    }

    public void clickJsPrompt(String text) {
        jsPromptButton.click();
        switchTo().alert().sendKeys(text);
        switchTo().alert().accept();
    }

    public String getResult() {
        return result.getText();
    }
}