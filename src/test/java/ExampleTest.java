import io.qameta.allure.*;
import static io.qameta.allure.Allure.step;
import org.testng.annotations.Test;
import helpers.Driver;

@Epic("Authentication")
@Feature("Login")
public class ExampleTest extends A_BaseTest
{
    @Test(description = "Login via email test")
    @Story("User can login with email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test login functionality with valid email credentials")
    public void loginViaEmail() {
        step("Open login page", () -> {
            app.loginPage.open();
        });
        
        step("Enter credentials", () -> {
            app.loginPage.login("tomsmith", "SuperSecretPassword!");
        });
        
        step("Verify successful login", () -> {
            logger.info("Sample info message");
            logger.warn("Sample warn message");
            softAssert.assertEquals(2, 2);
            softAssert.assertAll();
        });
    }

    @Test
    @Story("Clear cookies functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test clearing cookies functionality")
    public void clearCookies() {
        step("Clear browser cookies", () -> {
            Driver.clearCookies();
        });
    }
}
