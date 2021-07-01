package priceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormPage;

public class C2DPriceTest {
    WebDriver driver;
    FormPage formPage;

    @Given("I start web browser")
    public void i_start_web_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("I go to page {string}")
    public void i_go_to_page(String string) throws InterruptedException {
        driver.get(string);
        formPage = new FormPage(driver);
        formPage.closeCookiesPopup();
        formPage.closeBottomCookiesPopup();
    }

    @When("I click C2D delivery method")
    public void i_click_c2d_delivery_mothod() throws InterruptedException {
        formPage.chooseDeliveryC2D();
    }

    @And("I click c2d parcel size {string}")
    public void i_click_c2d_parcel_size(String string) {
        formPage.clickParcesSize(string);
    }

    @Then("C2D price in summary is {string}")
    public void c2d_price_in_summary_is(String string) {
        Assert.assertEquals(string, formPage.getParcelPrice().getText());
        driver.quit();
    }
}
