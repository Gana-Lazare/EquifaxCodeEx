package stepDefinitions;

import AmazonWebElements.AmazonWebElements;
import BaseWeb.BaseWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

public class AmazonStepDefinitions {

    BaseWeb baseWeb = new BaseWeb();
     AmazonWebElements amazonWebElements = new AmazonWebElements();
public static WebDriver driver;

    @Before
    public void setup() {

        driver =baseWeb.Setup();
        baseWeb = PageFactory.initElements(driver, BaseWeb.class);
        amazonWebElements = PageFactory.initElements(driver,AmazonWebElements.class);
    }


    @Given("i type {string} in amazon search Bar")
    public void i_type_in_amazon_search_bar(String item) {
        //WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement dropDownSelectMenu = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        baseWeb.clickOnSelectDropDown(dropDownSelectMenu, "Books");

        amazonWebElements.searchbox.sendKeys(item);
        amazonWebElements.searchbox.submit();

    }

    @Given("i click on the first item in the list  result")
    public void i_click_on_the_first_item_in_the_list_result() {
        //the xpath bellow can be cutumized for any index of item
        //to choose the item  n just change @data-index = n
    amazonWebElements.firstItemIntheListofResult.click();
    }

    @Given("i assert {string} after click on first item")
    public void i_assert_after_click_on_first_item(String price) {


        baseWeb.ExplicitelyWait(amazonWebElements.priceElement);
String expectedResult = price;
String actualResult = amazonWebElements.priceElement.getText();
        Assert.assertEquals(actualResult,expectedResult,"Price Expected is Different from  Actual Price");
    }

    @Given("i Click on Add to Cart")
    public void i_click_on_add_to_cart() {

        baseWeb.moveToAnElement(amazonWebElements.addToCartWebElement);
        amazonWebElements.addToCartWebElement.click();
    }

    @Given("i assert {string} after click on add to cart")
    public void i_assert_after_click_on_add_to_cart(String price) {
          baseWeb.ExplicitelyWait(amazonWebElements.cartSubTotalWebElement);
   String expectedPrice = price;
   String actualPrice = amazonWebElements.cartSubTotalWebElement.getText();
   Assert.assertEquals(actualPrice,expectedPrice,"Expected Price different from Actual Price");
    }

    @When("I click  on proceed to checkout")
    public void i_click_on_proceed_to_checkout() {
        amazonWebElements.proceedToCheckOutWebElement.click();
    }

    @Then("i assert {string} after checkout")
    public void i_assert_after_checkout(String price) {
        String expectedresult = price;
        try{String actualresult = amazonWebElements.cartSubPoceedTotalWebElement.getText();
            Assert.assertEquals(actualresult,expectedresult,"ExpectedPrice different from Actual Price ");
        }
catch (Exception e){
    System.out.println("Element not visible");
}


    }
   @After
    public void afterearchScenario() throws IOException {

        //baseWeb.getdriver().close();
    }


}
