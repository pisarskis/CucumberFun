package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FormPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private Actions actions;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 60);
    }

// cookies
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesButton;

    @FindBy(className = "btn-cookie-trigger")
    private WebElement cookiesBottomButton;

// type of parcel
    @FindBy(css = "[for = deliveryTypeboxmachine")
    private WebElement deliveryToAPM;

    @FindBy(css = "[for = deliveryTypeaddress")
    private WebElement deliveryToAddress;

    @FindBy(css = "[for = parcelSizeA]>span")
    private WebElement parcelSizeA;

    @FindBy(css = "[for = parcelSizeB]>span")
    private WebElement parcelSizeB;

    @FindBy(css = "[for = parcelSizeC]>span")
    private WebElement parcelSizeC;

    @FindBy(xpath = "//*[@id=\"parcelForm\"]/div/div[2]/div[2]/app-parcel-form-summary/div/div[2]/div/span[2]")
    private WebElement parcelPrice;



    public FormPage closeCookiesPopup() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
        cookiesButton.click();
        TimeUnit.SECONDS.sleep(1);
        return this;
    }

    public FormPage chooseDeliveryToAPM() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[for = deliveryTypeboxmachine")));
        deliveryToAPM.click();
        TimeUnit.SECONDS.sleep(1);
        return this;
    }

    public FormPage chooseDeliveryC2D() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[for = deliveryTypeaddress")));
        deliveryToAddress.click();
        TimeUnit.SECONDS.sleep(1);
        return this;
    }

    public FormPage closeBottomCookiesPopup() throws InterruptedException {
        cookiesBottomButton.click();
        TimeUnit.SECONDS.sleep(1);
        return this;
    }

    public FormPage clickParcesSize(String size) {
        WebElement parcel = driver.findElement(By.cssSelector("[for = parcelSize" + size + "]>span"));
        actions.moveToElement(parcel).build().perform();
        parcel.click();
        return this;
    }

    public FormPage clickA() {
        actions.moveToElement(parcelSizeA).build().perform();
        parcelSizeA.click();
        return this;
    }

    public FormPage clickB() {
        actions.moveToElement(parcelSizeB).build().perform();
        parcelSizeA.click();
        return this;
    }

    public FormPage clickC() {
        actions.moveToElement(parcelSizeC).build().perform();
        parcelSizeA.click();
        return this;
    }

    public WebElement getParcelPrice() {
        return parcelPrice;
    }
}

