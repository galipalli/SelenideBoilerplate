package app.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage extends BasePage {
    private final SelenideElement fileInput = $("#file-upload");
    private final SelenideElement uploadButton = $("#file-submit");
    private final SelenideElement uploadedFiles = $("#uploaded-files");

    public FileUploadPage() {
        super("/upload");
    }

    public void uploadFile(String filePath) {
        fileInput.uploadFromClasspath(filePath);
        uploadButton.click();
    }

    public String getUploadedFileName() {
        return uploadedFiles.getText();
    }
}