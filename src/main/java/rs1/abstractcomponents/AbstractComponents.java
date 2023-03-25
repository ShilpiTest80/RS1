package rs1.abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rs1.pageobjects.CartPage;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //PageFactory
    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
    public void waitForElementToAppear(By findBy){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        // Application taking 4 seconds to move ahead due to another spinner to get disappeared
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.invisibilityOf(ele));
        Thread.sleep(2000);
    }

    public CartPage goToCartPage(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
        //Changes
        //Changes made in github
    }

}
