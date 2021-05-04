package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.DetailsPage;
import PageObjects.ChooseProductPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ChooseProductTask {

    private static WebDriver driver;
    private static ChooseProductPage chooseProduct;
    private static DetailsPage detailsPage;

    public ChooseProductTask(WebDriver driver) {
        this.driver = driver;
        chooseProduct = new ChooseProductPage(this.driver);
        detailsPage = new DetailsPage(this.driver);
    }

    public void chooseProduct(){
        chooseProduct.getProductLinkImage().click();
        checkProduct();
    }

    private void checkProduct(){
        try{
            Assertions.assertTrue(detailsPage.getProductCartLabel().isDisplayed());
            Report.extentTest.log(Status.PASS, "Item selecionado com sucesso", ScreenShot.base64(driver));

        } catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Nenhum Produto foi selecionado", ScreenShot.base64(driver));
        }
    }
}
