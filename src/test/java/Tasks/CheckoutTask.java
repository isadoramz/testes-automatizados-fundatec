package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.CheckoutPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private static WebDriver driver;
    private static PageObjects.CheckoutPage checkoutPage;
    private static LoginPage loginPage;
    private static Waits wait;

    public CheckoutTask(WebDriver driver) {
        this.driver = driver;
        checkoutPage = new PageObjects.CheckoutPage(this.driver);
        loginPage = new LoginPage(this.driver);
        wait = new Waits(this.driver);
    }

    public void finishSale(){
        validateShop();
        checkoutPage.getFinishButton().click();
    }

    private void validateShop() {
        try {
            Assertions.assertEquals(checkoutPage.getFinishtextLabel().getText(), "Payment Information:");
            Report.extentTest.log(Status.PASS, "Compra finalizada", ScreenShot.base64(driver));
        } catch (Exception e) {
            Report.extentTest.log(Status.FAIL, "Compra não finalizada", ScreenShot.base64(driver));
        }
    }
}
