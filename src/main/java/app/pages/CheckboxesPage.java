package app.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPage extends BasePage {
    private final ElementsCollection checkboxes = $$("#checkboxes input");

    public CheckboxesPage() {
        super("/checkboxes");
    }

    public void toggleCheckbox(int index) {
        checkboxes.get(index).click();
    }

    public boolean isCheckboxChecked(int index) {
        return checkboxes.get(index).isSelected();
    }
}