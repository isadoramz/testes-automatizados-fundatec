package TestCases;

import FrameWork.BaseTest;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CompleteShopTest extends BaseTest {

    private WebDriver driver = this.getDriver();

    LoginTask login = new LoginTask(driver);
    ChooseProductTask product = new ChooseProductTask(driver);
    DetailsTask  productDetails = new DetailsTask(driver);
    CartTask cart = new CartTask(driver);
    InformationTask information = new InformationTask(driver);
    CheckoutTask checkout = new CheckoutTask(driver);


    @Test
    public void CompleteShopTest(){
        try {
            Report.startReport("Compra realizada com sucesso");
            login.login();
            product.chooseProduct();
            productDetails.addToCart();
            cart.checkout();
            information.fillInformation();
            checkout.finishSale();
        } catch (Exception e){
            Report.extentTest.log(Status.ERROR, e.getMessage(), ScreenShot.base64(driver));
        }
    }
}
