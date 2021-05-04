package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import FrameWork.Utils.FakerGeneration;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.InformationPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class InformationTask {

    private static WebDriver driver;
    private static InformationPage informationPage;
    private static CheckoutPage checkoutPage;
    private static CartPage cartPage;
    private static Waits wait;
    private static FakerGeneration faker;

    public InformationTask(WebDriver driver) {

        this.driver = driver;
        informationPage = new InformationPage(this.driver);
        checkoutPage = new CheckoutPage(this.driver);
        wait = new Waits(this.driver);
        cartPage = new CartPage(this.driver);
        faker = new FakerGeneration(this.driver);
    }

    public void fillInformation(){
        informationPage.getFirstNameTextField().sendKeys(faker.getFirstName());
        informationPage.getLastNameTextField().sendKeys(faker.getLastName());
        informationPage.getZipTextField().sendKeys(faker.getZipCode());
        validateInfo();
        informationPage.getContinueButton().click();
        validatePage();
        informationPage.getFinishButton().click();
    }

    private void validateInfo(){
        try {
            Assertions.assertFalse(informationPage.getFirstNameTextField().getAttribute("value").equalsIgnoreCase(" "));
            Report.extentTest.log(Status.PASS, "Dados preenchidos corretamente", ScreenShot.base64(driver));

        } catch (Exception e){

            Report.extentTest.log(Status.FAIL, "Dados não foram preenchidos" , ScreenShot.base64(driver));
        }
    }

    private void validatePage(){
        try {
            wait.loadElement(cartPage.getPageLabel());
            String label = cartPage.getPageLabel().getText();
            Assertions.assertEquals(label, "Checkout: Overview");
            Report.extentTest.log(Status.INFO , "Pagina carregada", ScreenShot.base64(driver));
        } catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Pagina carregada", ScreenShot.base64(driver));
        }
    }



}
