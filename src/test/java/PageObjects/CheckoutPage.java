package PageObjects;

import FrameWork.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private Waits wait;


    public CheckoutPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getFinishtextLabel() {
        return wait.visibilityOfElement(By.className("summary_info_label"));
    }

    public WebElement getFinishButton() {
        return this.driver.findElement(By.id("finish"));
    }
}
