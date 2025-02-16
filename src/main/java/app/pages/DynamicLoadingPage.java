package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class DynamicLoadingPage extends BasePage {
    private final SelenideElement startButton = $("#start button");
    private final SelenideElement loadingIndicator = $("#loading");
    private final SelenideElement finishText = $("#finish h4");

    public DynamicLoadingPage() {
        super("/dynamic_loading/1");
    }

    public void clickStart() {
        startButton.click();
    }

    public void waitForLoading() {
        loadingIndicator.should(Condition.appear);
        loadingIndicator.should(Condition.disappear);
    }

    public String getFinishText() {
        finishText.should(Condition.visible);
        return finishText.getText();
    }
}