package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.ChooseProductPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private static WebDriver driver;
    private static LoginPage login;
    private static ChooseProductPage chooseProduct;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        login = new LoginPage(this.driver);
    }

    public void login(){
        login.getUsernameTextField().sendKeys("standard_user");
        login.getPasswordTextField().sendKeys("secret_sauce");
        login.getLoginButton().click();
        checkLogin();
    }

    private void checkLogin() {
        try {
            String label = chooseProduct.getHomeLabelText().getText();
            Assertions.assertEquals(label, "Products");
            Report.extentTest.log(Status.PASS, "Foi realizado o login : " + label, ScreenShot.base64(driver));
        } catch (Exception e) {

            Report.extentTest.log(Status.FAIL, "Não foi realizado o login", ScreenShot.base64(driver));
        }
    }
}
