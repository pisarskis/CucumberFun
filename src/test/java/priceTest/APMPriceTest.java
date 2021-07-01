package priceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormPage;

public class APMPriceTest {
    WebDriver driver;
    FormPage formPage;

    @Given("I start chrome")
    public void i_start_chrome() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("I go to {string}")
    public void i_go_to(String string) {
        driver.get(string);
    }

    @And("I close cookies popup")
    public void i_close_cookies_popup() throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.closeCookiesPopup();
    }

    @And("I close bottom cookies popup")
    public void i_close_bottom_cookies_popup() throws InterruptedException {
        formPage.closeBottomCookiesPopup();
    }

    @When("I click apm parcel size {string}")
    public void i_apm_click_parcel_size(String string) {
        formPage.clickParcesSize(string);
    }

    @Then("APM price in summary is {string}")
    public void apm_price_in_summary_is(String string) {
        Assert.assertEquals(string, formPage.getParcelPrice().getText());
        driver.quit();
    }
}
