package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.CartPage;
import PageObjects.DetailsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class DetailsTask {

    private static WebDriver driver;
    private static DetailsPage detailsPage;
    private static CartPage cartPage;

    public DetailsTask(WebDriver driver) {

        this.driver = driver;
        detailsPage = new DetailsPage(this.driver);
        cartPage = new CartPage(this.driver);
    }

    public void addToCart(){
        detailsPage.getAddCartButton().click();
        detailsPage.getCartButton().click();
        validateCart();
    }

    private void validateCart() {
        try {
            String label = cartPage.getPageLabel().getText();
            Assertions.assertEquals(label, "Your Cart");
            Report.extentTest.log(Status.INFO,"Página de Carrinho carregada", ScreenShot.base64(driver));
        } catch (Exception e){
            Report.extentTest.log(Status.FAIL,"Produto não foi adicionado no carrinho", ScreenShot.base64(driver));
        }
    }

}
