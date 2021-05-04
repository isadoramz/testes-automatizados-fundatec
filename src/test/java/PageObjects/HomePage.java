package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getHomeTitle(){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]"));
    }

    public WebElement getStartButton(){
        return driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
    }
}

