package app.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class DropdownPage extends BasePage {
    private final SelenideElement dropdown = $("#dropdown");

    public DropdownPage() {
        super("/dropdown");
    }

    public void selectOption(String option) {
        dropdown.selectOption(option);
    }

    public String getSelectedOption() {
        return dropdown.getSelectedOption().getText();
    }
}