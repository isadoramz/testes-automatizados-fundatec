package PageObjects;

import FrameWork.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage {

    private WebDriver driver;
    private Waits wait;

    public DetailsPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getCartButton() {
        return wait.visibilityOfElement(By.className("shopping_cart_link"));
    }

    public WebElement getAddCartButton() {
        return this.driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getProductCartLabel() {
        return this.driver.findElement(By.className("inventory_details_name"));
    }

}
